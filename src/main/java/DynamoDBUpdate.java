import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
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

    private final Gson gson;
    private final DynamoDB dynamoDB;
    private static final String TABLE_NAME = "Games";

    public DynamoDBUpdate() {
        gson = new Gson();
        AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder.defaultClient();
        dynamoDB = new DynamoDB(dynamoDBClient);
    }

    public void updateDaily(Map<String, String> event, Context context) {
        LambdaLogger logger = context.getLogger();
        //GamesFromDateResponse testResponse = gson.fromJson(response.get().body(), GamesFromDateResponse.class);

        final String todaysDate = DateUtils.getTodayDate();
        List<GameData> todaysGames = getGamesFromDate(todaysDate, logger, gson);

        // for each game: call gameDetails and gameStatistics and get the needed details
        todaysGames.forEach(gameData -> fillGameData(gameData, logger, gson));
        todaysGames.forEach(gameData -> logGameData(gameData, logger, gson));

        // upload all games to DDB
        Table table = dynamoDB.getTable(TABLE_NAME);
        todaysGames.stream()
                   .map(GameData::toDdbItem)
                   .forEach(table::putItem);
    }

    private void logGameData(GameData gameData, LambdaLogger logger, Gson gson) {
        final String gameDataJson = gson.toJson(gameData);
        final String message = String.format("Game Data for %s:\n%s", gameData.getId(), gameDataJson);
        logger.log(message);
    }

    private void fillGameData(GameData gameData, LambdaLogger logger, Gson gson) {
        fillGameDataWithGameDetails(gameData, logger, gson);
        fillGameDataWithGameStatistics(gameData, logger, gson);
    }


}
