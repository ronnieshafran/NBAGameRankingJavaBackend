package logic;

import clients.RapidAPIClient;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.google.gson.Gson;
import lambdaDataModel.dynamoDb.GameData;
import lambdaDataModel.stars.StarsProvider;
import lambdaDataModel.stars.model.Star;
import rapidAPIDataModel.gameStatistics.GameStatisticsResponse;
import rapidAPIDataModel.gameStatistics.Statistic;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GetGameStatisticsLogic {
    public static void fillGameDataWithGameStatistics(GameData gameData, LambdaLogger logger, Gson gson) {
        Optional<HttpResponse<String>> gameStatisticsHttpResponse = RapidAPIClient.getGameStatistics(gameData.getId(), logger);
        if (gameStatisticsHttpResponse.isEmpty()) {
            throw new RuntimeException("Failed to reach gameStatistics API!");
        }
        GameStatisticsResponse gameStatisticsResponse = gson.fromJson(gameStatisticsHttpResponse.get().body(), GameStatisticsResponse.class);
        List<Statistic> stats = gameStatisticsResponse.getApi().getStatistics();
        List<Statistic> hTeamSpecialPerformers = stats.stream().filter(GetGameStatisticsLogic::isSpecialPerformance)
                .filter(statistic -> statistic.getTeamId().equals(gameData.getHomeTeamId())).collect(Collectors.toList());

        List<Statistic> vTeamSpecialPerformers = stats.stream().filter(GetGameStatisticsLogic::isSpecialPerformance)
                .filter(statistic -> statistic.getTeamId().equals(gameData.getAwayTeamId())).collect(Collectors.toList());

        gameData.setDuel(!hTeamSpecialPerformers.isEmpty() && !vTeamSpecialPerformers.isEmpty());
        gameData.setSpecialPerformance(!hTeamSpecialPerformers.isEmpty() || !vTeamSpecialPerformers.isEmpty());
        gameData.setInjuredPlayers(getInjuredPlayers(stats, gameData, logger));

    }

    private static List<String> getInjuredPlayers(final List<Statistic> stats, final GameData gameData, final LambdaLogger logger) {
        List<Statistic> stars =
                stats.stream().filter(statistic -> isStarPlayer(statistic, gameData)).collect(Collectors.toList());
        List<Statistic> injuredStars = stars.stream().filter(GetGameStatisticsLogic::wasInjured).collect(Collectors.toList());
        List<String> injuredStarsNames = injuredStars.stream().map(GetGameStatisticsLogic::getStarName).collect(Collectors.toList());
        if (injuredStarsNames.stream().anyMatch(String::isEmpty)) {
            logger.log("Empty Star Name In Game: " + gameData.getId());
        }
        return injuredStarsNames;
    }

    private static String getStarName(Statistic starStats) {
        Optional<String> starName = StarsProvider.TEAM_TO_STARS.get(starStats.getTeamId())
                .stream()
                .filter(star -> star.getId().equals(starStats.getPlayerId()))
                .map(Star::getName)
                .findFirst();
        if (starName.isEmpty()) {
            return "";
        }
        return starName.get();

    }

    private static boolean wasInjured(final Statistic statistic) {
        return Integer.parseInt(statistic.getMin()) <= 5;
    }

    private static boolean isStarPlayer(final Statistic statistic, final GameData gameData) {
        List<Star> hTeamStars = StarsProvider.TEAM_TO_STARS.getOrDefault(gameData.getHomeTeamId(), List.of());
        List<Star> vTeamStars = StarsProvider.TEAM_TO_STARS.getOrDefault(gameData.getAwayTeamId(), List.of());
        boolean isHTeamStar = hTeamStars.stream().anyMatch(star -> star.getId().equals(statistic.getPlayerId()));
        boolean isVTeamStar = vTeamStars.stream().anyMatch(star -> star.getId().equals(statistic.getPlayerId()));
        return isHTeamStar || isVTeamStar;
    }

    private static boolean isSpecialPerformance(final Statistic statline) {
        return Integer.parseInt(statline.getPoints()) > 40
                || playerHadSpecialDoubleDouble(statline)
                || playerHadSpecialTripleDouble(statline)
                || playerHadQuadrupleDouble(statline);
    }

    private static boolean playerHadSpecialDoubleDouble(final Statistic statline) {
        return playerHadMorePointsThan(statline, 20)
                && (playerHadMoreReboundsThan(statline, 20) || playerHadMoreAssistsThan(statline, 20));
    }
    private static boolean playerHadSpecialTripleDouble(final Statistic statline) {
        return playerHadMorePointsThan(statline, 35)
                && playerHadMoreAssistsThan(statline, 10) && playerHadMoreReboundsThan(statline, 10);
    }

    private static boolean playerHadQuadrupleDouble(final Statistic statline) {
        int specialStatsCounter = 0;
        if (playerHadMorePointsThan(statline, 10)) {
            specialStatsCounter++;
        }
        if (playerHadMoreAssistsThan(statline, 10)) {
            specialStatsCounter++;
        }
        if (playerHadMoreReboundsThan(statline, 10)) {
            specialStatsCounter++;
        }
        if (playerHadMoreStealsThan(statline, 10)) {
            specialStatsCounter++;
        }
        if (playerHadMoreBlocksThan(statline, 10)) {
            specialStatsCounter++;
        }
        return specialStatsCounter >= 4;
    }

    private static boolean playerHadMorePointsThan(final Statistic statline, int points) {
        return Integer.parseInt(statline.getPoints()) >= points;
    }
    private static boolean playerHadMoreAssistsThan(final Statistic statline, int assists) {
        return Integer.parseInt(statline.getAssists()) >= assists;
    }
    private static boolean playerHadMoreReboundsThan(final Statistic statline, int rebounds) {
        return Integer.parseInt(statline.getTotReb()) >= rebounds;
    }
    private static boolean playerHadMoreStealsThan(final Statistic statline, int steals) {
        return Integer.parseInt(statline.getSteals()) >= steals;
    }
    private static boolean playerHadMoreBlocksThan(final Statistic statline, int blocks) {
        return Integer.parseInt(statline.getBlocks()) >= blocks;
    }
}
