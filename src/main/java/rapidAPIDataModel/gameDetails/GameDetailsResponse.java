
package rapidAPIDataModel.gameDetails;

import com.google.gson.annotations.Expose;


public class GameDetailsResponse {

    @Expose
    private Api api;

    public Api getApi() {
        return api;
    }

    public void setApi(Api api) {
        this.api = api;
    }

}
