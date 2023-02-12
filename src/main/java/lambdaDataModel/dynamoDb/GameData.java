package lambdaDataModel.dynamoDb;

import com.amazonaws.services.dynamodbv2.document.Item;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

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
    List<String> injuredPlayers;
    boolean isBlowout;
    boolean isBucketFest;
    boolean isClutch;
    boolean isDuel;
    boolean isHotGame;
    boolean isSpecialPerformance;
    boolean isTightD;

    public Item toDdbItem() {
        return new Item().withPrimaryKey("date", date)
                        .with("GameId", id)
                        .with("AwayTeam", awayTeam)
                        .with("HomeTeam", homeTeam)
                        .with("InjuredPlayers", injuredPlayers)
                        .with("IsBlowout", isBlowout)
                        .with("IsBucketFest", isBucketFest)
                        .with("IsClutch", isClutch)
                        .with("IsDuel", isDuel)
                        .with("IsHotGame", isHotGame)
                        .with("IsSpecialPerformance", isSpecialPerformance)
                        .with("IsTightD", isTightD);
    }

}
