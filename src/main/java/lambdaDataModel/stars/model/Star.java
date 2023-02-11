package lambdaDataModel.stars.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Star {
    private String id;
    private String name;
}
