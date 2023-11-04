import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.google.gson.Gson;
import lambdaDataModel.dynamoDb.GameData;
import utils.DateUtils;

import java.util.List;
import java.util.Map;

import static logic.GetGameDetailsLogic.fillGameDataWithGameDetails;
import static logic.GetGameStatisticsLogic.fillGameDataWithGameStatistics;
import static logic.GetGamesFromDateLogic.getGamesFromDate;


public class DynamoDBUpdate {

    private static final String GAMES_TABLE_NAME = "Games";
    public static final String DATE = "date";
    public static final String GAME_ID = "gameId";
    private final Gson gson;
    private final DynamoDB dynamoDB;

    public DynamoDBUpdate() {
        gson = new Gson();
        AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder.defaultClient();
        dynamoDB = new DynamoDB(dynamoDBClient);
    }


    // Lambda handler
    public void backfillGames(Map<String, String> event, Context context) {
        final LambdaLogger logger = context.getLogger();
        final List<String> dates = DateUtils.getDatesFromBeginningOf2023();
        dates.forEach(date -> writeGamesFromDate(date, logger));
    }


    // Lambda handler
    public void updateDynamoDB(Map<String, String> event, Context context) {
        final LambdaLogger logger = context.getLogger();
        String date = event.getOrDefault("date", DateUtils.getTodayDate());
        if (date.isBlank()) {
            date = DateUtils.getTodayDate();
        }

        writeGamesFromDate(date, logger);
    }

    private void writeGamesFromDate(final String date, final LambdaLogger logger) {
        // get games from desired date
        final List<GameData> games = getGamesFromDate(date, logger, gson);
        if (games.isEmpty()) {
            logger.log("ERROR: No games found for date " + date);
            return;
        }

        // Rapid API allows for 10 calls in a minute; splitting to chunks to avoid throttling/
        // Since we make 2 calls for each game, and we initially make a call to get the list of games,
        // chunk size is set to 4 - the first minute will have 9 calls, and the rest will have up to 8.
        int chunkSize = 4;
        int delayInSeconds = 60; // 1 minute delay between chunks

        for (int i = 0; i < games.size(); i += chunkSize) {
            int end = Math.min(i + chunkSize, games.size());
            List<GameData> chunk = games.subList(i, end);

            // for each game: call gameDetails and gameStatistics endpoints and get the needed details
            chunk.forEach(gameData -> {
                fillGameData(gameData, logger, gson);
                logGameData(gameData, logger, gson);
            });

            // Sleep to ensure we don't exceed the rate limit
            try {
                Thread.sleep(delayInSeconds * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.log("Error while waiting for rate limit: " + e.getMessage());
            }
        }

        // upload all games to DDB
        final Table table = dynamoDB.getTable(GAMES_TABLE_NAME);
        final TableWriteItems gameItemsToWrite = new TableWriteItems(GAMES_TABLE_NAME);
        writeItemsToDynamoDB(logger, games, table, gameItemsToWrite);
    }

    private void fillGameData(GameData gameData, LambdaLogger logger, Gson gson) {
        fillGameDataWithGameDetails(gameData, logger, gson);
        fillGameDataWithGameStatistics(gameData, logger, gson);
    }
    private void writeItemsToDynamoDB(final LambdaLogger logger,
                                      final List<GameData> games,
                                      final Table table,
                                      final TableWriteItems gameItemsToWrite) {
        games.stream()
             .map(GameData::toDdbItem)
             .filter(item -> itemNotInTable(table, item, logger))
             .forEach(gameItemsToWrite::addItemToPut);
        if (gameItemsToWrite.getItemsToPut() == null) {
            logger.log("No items to write!");
            return;
        }
        logger.log("Number of item to write: " + gameItemsToWrite.getItemsToPut().size());
        BatchWriteItemOutcome outcome = dynamoDB.batchWriteItem(gameItemsToWrite);
        logResults(logger, outcome);
    }


    private boolean itemNotInTable(final Table table, final Item item, final LambdaLogger logger) {
        final Object itemGameId = item.get(GAME_ID);
        final Object itemDate = item.get(DATE);
        final boolean isItemInTable = table.getItem(DATE, itemDate, GAME_ID, itemGameId) != null;
        if (isItemInTable) {
            logger.log("Item " + itemDate + " - " + itemGameId + " already in table " + table.getTableName());
        }
        return !isItemInTable;
    }


    private void logGameData(GameData gameData, LambdaLogger logger, Gson gson) {
        final String gameDataJson = gson.toJson(gameData);
        final String message = String.format("Game Data for %s:\n%s", gameData.getId(), gameDataJson);
        logger.log(message);
    }

    private void logResults(final LambdaLogger logger, final BatchWriteItemOutcome outcome) {
        int numberOfFailures;
        try {
            numberOfFailures = outcome.getUnprocessedItems()
                                      .size();
        } catch (NullPointerException exception) {
            numberOfFailures = 0;
        }
        logger.log("Number of items failed to write: " + numberOfFailures);
    }



}
