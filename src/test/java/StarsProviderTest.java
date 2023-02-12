import lambdaDataModel.stars.StarsProvider;
import lambdaDataModel.stars.model.Star;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StarsProviderTest {

    @Test
    public void starsProvider__sanityTest(){
        final Star TRAE_YOUNG = Star.builder().id("1046").name("Young").build();
        final String HAWKS_ID = "1";
        assertTrue(StarsProvider.TEAM_TO_STARS.get("1").contains(TRAE_YOUNG));
    }
}
