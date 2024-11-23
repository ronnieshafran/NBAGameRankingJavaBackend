package rapidAPIDataModel.gamesFromDate;

import lambdaDataModel.dynamoDb.GameData;
import utils.DateUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GameUtils {
    private static final Map<String, String> TEAMS_WITH_BROKEN_LOGOS_TO_LOGOS = Map.of(
            "21", "https://cdn.iconscout.com/icon/free/png-512/free-milwaukee-bucks-logo-icon-download-in-svg-png-gif-file-formats--nba-basketball-game-ball-sport-pack-logos-icons-1593219.png?f=webp&w=256",
            "27", "https://cdn.iconscout.com/icon/free/png-512/free-philidephia-ers-logo-icon-download-in-svg-png-gif-file-formats--nba-basketball-game-ball-pack-logos-icons-1593213.png?f=webp&w=256",
            "25", "https://upload.wikimedia.org/wikipedia/en/5/5d/Oklahoma_City_Thunder.svg",
            "20", "https://cdn.iconscout.com/icon/free/png-512/free-miami-heat-logo-icon-download-in-svg-png-gif-file-formats--nba-basketball-game-pack-logos-icons-1593199.png?f=webp&w=256"
    );
    public static boolean isGameFinished(final Game game) {
        return Objects.equals(game.getStatusGame(), "Finished");
    }

    public static String logTimeString(final Game game) {
        return String.format("%s /// %s vs %s --- start time: %s", game.getStartTimeUTC(),
                             game.getHTeam().getShortName(),
                             game.getVTeam().getShortName(), DateUtils.extractHour(game.getStartTimeUTC()));
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
        data.put("logo", getWorkingLogo(hTeam.getTeamId(), hTeam.getLogo()));
        data.put("fullName", hTeam.getFullName());
        data.put("shortName", hTeam.getShortName());
        return data;
    }

    private static Map<String, String> getRelevantData(VTeam vTeam) {
        Map<String, String> data = new HashMap<>();
        data.put("logo", getWorkingLogo(vTeam.getTeamId(), vTeam.getLogo()));
        data.put("fullName", vTeam.getFullName());
        data.put("shortName", vTeam.getShortName());
        return data;
    }

    private static String getWorkingLogo(final String teamId, final String logoUrl) {
        if (TEAMS_WITH_BROKEN_LOGOS_TO_LOGOS.containsKey(teamId)) {
            return TEAMS_WITH_BROKEN_LOGOS_TO_LOGOS.get(teamId);
        }
        return logoUrl;
    }

}
