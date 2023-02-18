package lambdaDataModel.dynamoDb;

import com.amazonaws.services.dynamodbv2.document.Item;
import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
@Builder
public class GameData {
    String date;
    String id;
    String homeTeamId;
    int homeTeamScore;
    String awayTeamId;
    int awayTeamScore;
    Map<String, String> homeTeam;
    Map<String, String> awayTeam;
    Set<String> injuredPlayers;
    boolean isBlowout;
    boolean isBucketFest;
    boolean isClutch;
    boolean isDuel;
    boolean isHotGame;
    boolean isSpecialPerformance;
    boolean isTightD;
    int totalScore;
    int margin;

    public Item toDdbItem() {
        return new Item().withPrimaryKey("date", date)
                         .withString("gameId", id)
                         .withMap("awayTeam", awayTeam)
                         .withMap("homeTeam", homeTeam)
                         .withStringSet("injuredPlayers", injuredPlayers.isEmpty() ? Set.of("") : injuredPlayers)
                         .withBoolean("isBlowout", isBlowout)
                         .withBoolean("isBucketFest", isBucketFest)
                         .withBoolean("isClutch", isClutch)
                         .withBoolean("isDuel", isDuel)
                         .withBoolean("isHotGame", isHotGame)
                         .withBoolean("isSpecialPerformance", isSpecialPerformance)
                         .withBoolean("isTightD", isTightD)
                         .withInt("totalScore", totalScore)
                         .withInt("margin", margin);
    }

}
