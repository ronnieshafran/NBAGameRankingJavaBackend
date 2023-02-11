import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.google.gson.Gson;
import lambdaDataModel.dynamoDb.GameData;
import utils.DateUtils;

import java.util.List;
import java.util.Map;

import static logic.GetTodaysGamesLogic.getGamesFromDate;


public class DynamoDBUpdate {

    private final Gson gson;
    private final DynamoDB dynamoDB;
    private static final String TABLE_NAME = "gameIds";

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
        // upload all games to DDB

//        String date = event.get("date");
//        logger.log("logged event date " + date);
//        Table table = dynamoDB.getTable(TABLE_NAME);
//        Item item = new Item()
//                .withPrimaryKey("gameIds", "gameId");
//        table.putItem(item);
    }




}
