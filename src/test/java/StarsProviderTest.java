import lambdaDataModel.stars.StarsProvider;
import lambdaDataModel.stars.model.Star;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StarsProviderTest {

    @Test
    public void starsProvider__sanityTest(){
        Star STEPH_CURRY = Star.builder()
                .id("124")
                .name("Steph")
                .build();
        String WARRIORS_ID = "11";
        assertTrue(StarsProvider.TEAM_TO_STARS.get(WARRIORS_ID).contains(STEPH_CURRY));
    }
}
