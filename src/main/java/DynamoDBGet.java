import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamoDBGet {
    private static final String GAMES_TABLE_NAME = "Games";
    public static final String DATE = "date";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private final AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder.standard()
                                                                             .build();

    public static final String API_KEY = System.getenv("API_KEY");
    private final DynamoDB dynamoDB = new DynamoDB(dynamoDBClient);

    private final Gson gson = new GsonBuilder().setPrettyPrinting()
                                               .create();

    private final Map<String, String> reponseHeaders =
            Map.of("Access-Control-Allow-Headers", "x-api-key",
                   "Access-Control-Allow-Origin", "*",
                   "Content-Type", "application/json");

    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {
        final LambdaLogger logger = context.getLogger();
        logger.log(gson.toJson(event));
        final String date = event.getQueryStringParameters()
                                 .get("date");
        final String apiKey = event.getHeaders()
                                   .get("x-api-key");
        logger.log("got api key " + apiKey);
        if (!apiKey.equals(API_KEY)) {
            var response = new APIGatewayProxyResponseEvent().withStatusCode(400)
                                                             .withHeaders(reponseHeaders)
                                                             .withBody("Invalid API Key");
            logger.log(gson.toJson(response));
            return response;

        }
        if (date == null) {
            var response = new APIGatewayProxyResponseEvent().withStatusCode(400)
                                                             .withHeaders(reponseHeaders)
                                                             .withBody("Missing 'date' query parameter");
            logger.log(gson.toJson(response));
            return response;
        }
        try {
            DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            var response = new APIGatewayProxyResponseEvent().withStatusCode(400)
                                                             .withHeaders(reponseHeaders)
                                                             .withBody("Invalid date format. Expected format: yyyy-MM-dd");
            logger.log(gson.toJson(response));
            return response;
        }
        ObjectMapper mapper = buildObjectMapper();
        Map<String, Object> responseMap = new HashMap<>();
        List<Item> games = getGamesFromTable(context, date);
        responseMap.put("games", games);
        String responseBody;
        try {
            responseBody = mapper.writeValueAsString(responseMap);
            logger.log(responseBody);
        } catch (JsonProcessingException e) {
            var response = new APIGatewayProxyResponseEvent().withStatusCode(500)
                                                             .withHeaders(reponseHeaders)
                                                             .withBody("Failed to serialize response\n" + e);
            logger.log(gson.toJson(response));
            return response;
        }

        var response = new APIGatewayProxyResponseEvent().withStatusCode(200)
                                                         .withHeaders(reponseHeaders)
                                                         .withBody(responseBody);
        logger.log(gson.toJson(response));
        return response;
    }

    private ObjectMapper buildObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Item.class, new JsonSerializer<Item>() {
            @Override
            public void serialize(Item item, JsonGenerator jsonGen, SerializerProvider serializerProvider) throws IOException {
                Map<String, Object> attributes = item.asMap();
                jsonGen.writeStartObject();
                for (Map.Entry<String, Object> entry : attributes.entrySet()) {
                    String attributeName = entry.getKey();
                    Object attributeValue = entry.getValue();
                    jsonGen.writeObjectField(attributeName, attributeValue);
                }
                jsonGen.writeEndObject();
            }
        });
        mapper.registerModule(module);
        return mapper;
    }

    private List<Item> getGamesFromTable(final Context context, final String dateString) {
        QuerySpec querySpec = new QuerySpec().withKeyConditionExpression("#date = :dateValue")
                                             .withNameMap(new NameMap().with("#date", DATE))
                                             .withValueMap(new ValueMap().with(":dateValue", dateString));
        final Table table = dynamoDB.getTable(GAMES_TABLE_NAME);
        final ItemCollection<QueryOutcome> queriedGameItems = table.query(querySpec);
        final List<Item> games = new ArrayList<>();
        for (final Item item : queriedGameItems) {
            context.getLogger()
                   .log(item.toJSONPretty());
            games.add(item);
        }
        return games;
    }
}
