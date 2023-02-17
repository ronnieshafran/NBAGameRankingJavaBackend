package rapidAPIDataModel.gamesFromDate;

import lambdaDataModel.dynamoDb.GameData;
import utils.DateUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GameUtils {
    public static boolean isGameFinished(final Game game) {
        return Objects.equals(game.getStatusGame(), "Finished");
    }

    public static boolean gameStartedBeforeFive(final Game game) {
        return DateUtils.extractHour(game.getStartTimeUTC()) < 5;
    }

    public static boolean gameStartedAfterThree(final Game game) {
        return DateUtils.extractHour(game.getStartTimeUTC()) > 3;
    }

    public static GameData toGameData(final Game game) {
        final Map<String, String> homeTeamRelevantData = getRelevantData(game.getHTeam());
        final Map<String, String> awayTeamRelevantData = getRelevantData(game.getVTeam());
        return GameData.builder()
                       .homeTeam(homeTeamRelevantData)
                       .awayTeam(awayTeamRelevantData)
                       .id(game.getGameId())
                       .homeTeamId(game.getHTeam()
                                       .getTeamId())
                       .awayTeamId(game.getVTeam()
                                       .getTeamId())
                       .homeTeamScore(Integer.parseInt(game.getHTeam()
                                                           .getScore()
                                                           .getPoints()))
                       .awayTeamScore(Integer.parseInt(game.getVTeam()
                                                           .getScore()
                                                           .getPoints()))
                       .build();
    }

    private static Map<String, String> getRelevantData(HTeam hTeam) {
        Map<String, String> data = new HashMap<>();
        data.put("logo", hTeam.getLogo());
        data.put("fullName", hTeam.getFullName());
        data.put("shortName", hTeam.getShortName());
        return data;
    }

    private static Map<String, String> getRelevantData(VTeam vTeam) {
        Map<String, String> data = new HashMap<>();
        data.put("logo", vTeam.getLogo());
        data.put("fullName", vTeam.getFullName());
        data.put("shortName", vTeam.getShortName());
        return data;
    }

}
