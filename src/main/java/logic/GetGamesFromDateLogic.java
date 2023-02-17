package logic;

import clients.RapidAPIClient;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.google.gson.Gson;
import lambdaDataModel.dynamoDb.GameData;
import rapidAPIDataModel.gamesFromDate.Game;
import rapidAPIDataModel.gamesFromDate.GameUtils;
import rapidAPIDataModel.gamesFromDate.GamesFromDateResponse;
import utils.DateUtils;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetGamesFromDateLogic {
    public static List<GameData> getGamesFromDate(final String date, final LambdaLogger logger, final Gson gson) {
        // get games from the date mentioned that started before 5 and are finished
        // and the games from the date before and started after 3 and are finished
        // if needed - maintain a set of homeTeams/awayTeams to avoid duplicates (probs not)
        logger.log("Running gamesFromDate for date: " + date);
        Optional<HttpResponse<String>> gamesFromTodayResponse = RapidAPIClient.getGamesFromDate(date, logger);
        if (gamesFromTodayResponse.isEmpty()) {
            throw new RuntimeException("Failed to connect to API!");
        }
        GamesFromDateResponse todaysResponse = gson.fromJson(gamesFromTodayResponse.get()
                                                                                   .body(), GamesFromDateResponse.class);

        Optional<HttpResponse<String>> gamesFromYeterdayResponse = RapidAPIClient.getGamesFromDate(DateUtils.getDayBefore(date), logger);
        if (gamesFromYeterdayResponse.isEmpty()) {
            throw new RuntimeException("Failed to connect to API!");
        }
        GamesFromDateResponse yesterdaysResponse = gson.fromJson(gamesFromTodayResponse.get()
                                                                                       .body(), GamesFromDateResponse.class);

        List<Game> todaysGames = todaysResponse.getApi()
                                               .getGames()
                                               .stream()
                                               .filter(GameUtils::isGameFinished)
                                               .filter(GameUtils::gameStartedBeforeFive)
                                               .collect(Collectors.toList());

        List<Game> yesterdaysGames = todaysResponse.getApi()
                                                   .getGames()
                                                   .stream()
                                                   .filter(GameUtils::isGameFinished)
                                                   .filter(GameUtils::gameStartedAfterThree)
                                                   .collect(Collectors.toList());

        List<GameData> allGames = Stream.concat(todaysGames.stream(), yesterdaysGames.stream())
                                        .map(GameUtils::toGameData)
                                        .collect(Collectors.toList());
        logger.log("games found: " + allGames.stream()
                                             .map(GameData::getId)
                                             .collect(Collectors.toList()));
        allGames.forEach(gameData -> gameData.setDate(date));
        return allGames;
    }
}
