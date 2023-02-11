package logic;

import clients.RapidAPIClient;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.google.gson.Gson;
import lambdaDataModel.dynamoDb.GameData;
import rapidAPIDataModel.gameDetails.Game;
import rapidAPIDataModel.gameDetails.GameDetailsResponse;
import rapidAPIDataModel.gameDetails.Score;

import java.net.http.HttpResponse;
import java.util.Optional;

public class GetGameDetailsLogic {
    public static void fillGameDataWithGameDetails(GameData gameData, LambdaLogger logger, Gson gson) {
        Optional<HttpResponse<String>> gameDetailsHttpResponse = RapidAPIClient.getGameDetails(gameData.getId(), logger);
        if (gameDetailsHttpResponse.isEmpty()) {
            throw new RuntimeException("Failed to reach gameDetails API!");
        }
        GameDetailsResponse gameDetailsResponse = gson.fromJson(gameDetailsHttpResponse.get().body(), GameDetailsResponse.class);
        Game game = gameDetailsResponse.getApi().getGame().get(0);
        final int marginAfter3 = calculateMarginAfter3(game);
        int vTeamPoints = Integer.parseInt(game.getVTeam().getScore().getPoints());
        int hTeamPoints = Integer.parseInt(game.getHTeam().getScore().getPoints());
        int finalMargin = Math.abs(hTeamPoints - vTeamPoints);

        final boolean isSmallMargin = finalMargin <= 5;
        final boolean isLargeMargin = finalMargin >= 12;
        final boolean isBlowout = isLargeMargin && marginAfter3 >= 10;
        final boolean isBucketFest = hTeamPoints >= 120 && vTeamPoints >= 120;
        final boolean isTightD = hTeamPoints <= 100 && vTeamPoints <= 100;

        gameData.setBlowout(isBlowout);
        gameData.setBucketFest(isBucketFest);
        gameData.setClutch(isSmallMargin);
        gameData.setTightD(isTightD);

    }



    private static int calculateMarginAfter3(final Game game) {
        Score hTeamScore = game.getHTeam().getScore();
        int hTeamScoreAfter3 = gethTeamScoreAfter3(hTeamScore);

        Score vTeamScore = game.getVTeam().getScore();
        int vTeamScoreAfter3 = gethTeamScoreAfter3(vTeamScore);

        return Math.abs(hTeamScoreAfter3-vTeamScoreAfter3);
    }

    private static int gethTeamScoreAfter3(Score score) {
        int totalScore = Integer.parseInt(score.getPoints());
        return totalScore - Integer.parseInt(score.getLinescore().get(score.getLinescore().size()-1));
    }
}
