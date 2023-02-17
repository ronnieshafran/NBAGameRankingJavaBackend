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

    public Item toDdbItem() {
        return new Item().withPrimaryKey("Date", date)
                         .withString("GameId", id)
                         .withMap("AwayTeam", awayTeam)
                         .withMap("HomeTeam", homeTeam)
                         .withStringSet("InjuredPlayers", injuredPlayers.isEmpty() ? Set.of("") : injuredPlayers)
                         .withBoolean("IsBlowout", isBlowout)
                         .withBoolean("IsBucketFest", isBucketFest)
                         .withBoolean("IsClutch", isClutch)
                         .withBoolean("IsDuel", isDuel)
                         .withBoolean("IsHotGame", isHotGame)
                         .withBoolean("IsSpecialPerformance", isSpecialPerformance)
                         .withBoolean("IsTightD", isTightD);
    }

}
