package rapidAPIDataModel.gamesFromDate;

import com.google.gson.annotations.Expose;


public class Score {

    @Expose
    private String points;

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

}
