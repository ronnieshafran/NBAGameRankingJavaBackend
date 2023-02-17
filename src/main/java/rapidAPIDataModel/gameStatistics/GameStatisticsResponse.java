package rapidAPIDataModel.gameStatistics;

import com.google.gson.annotations.Expose;


public class GameStatisticsResponse {

    @Expose
    private Api api;

    public Api getApi() {
        return api;
    }

    public void setApi(Api api) {
        this.api = api;
    }

}
