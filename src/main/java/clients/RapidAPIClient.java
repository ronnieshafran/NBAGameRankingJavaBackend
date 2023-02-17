package clients;

import com.amazonaws.services.lambda.runtime.LambdaLogger;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class RapidAPIClient {

    public static final String X_RAPID_API_KEY_HEADER = "X-RapidAPI-Key";
    public static final String X_RAPID_API_KEY = System.getenv("API_KEY");;
    public static final String X_RAPID_API_HOST_HEADER = "X-RapidAPI-Host";
    public static final String X_RAPID_API_HOST = "api-nba-v1.p.rapidapi.com";
    public static final String NBA_API_URL = "https://api-nba-v1.p.rapidapi.com";

    public static Optional<HttpResponse<String>> getGamesFromDate(final String date, final LambdaLogger logger) {
        //date format: YYYY-MM-DD
        final String gamesFromDateEndpoint = NBA_API_URL + "/games/date/";
        HttpRequest request = buildGetRequest(date, gamesFromDateEndpoint);
        return getHttpResponse(request, logger);
    }

    public static Optional<HttpResponse<String>> getGameDetails(final String gameId, final LambdaLogger logger) {
        final String gameDetailsEndpoint = NBA_API_URL + "/gameDetails/";
        HttpRequest request = buildGetRequest(gameId, gameDetailsEndpoint);
        return getHttpResponse(request, logger);
    }

    public static Optional<HttpResponse<String>> getGameStatistics(final String gameId, final LambdaLogger logger) {
        final String gameStatisticsEndpoint = NBA_API_URL + "/statistics/players/gameId/";
        HttpRequest request = buildGetRequest(gameId, gameStatisticsEndpoint);
        return getHttpResponse(request, logger);
    }

    private static HttpRequest buildGetRequest(final String param, final String endpoint) {
        return HttpRequest.newBuilder()
                          .uri(URI.create(endpoint + param))
                          .header(X_RAPID_API_KEY_HEADER, X_RAPID_API_KEY)
                          .header(X_RAPID_API_HOST_HEADER, X_RAPID_API_HOST)
                          .method("GET", HttpRequest.BodyPublishers.noBody())
                          .build();
    }


    private static Optional<HttpResponse<String>> getHttpResponse(final HttpRequest request, final LambdaLogger logger) {
        HttpResponse<String> response;
        try {
            response = HttpClient.newHttpClient()
                                 .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            logger.log(String.format("HTTP call returned error: %s", e.getMessage()));
            response = null;
        }
        return Optional.ofNullable(response);
    }
}
