package rapidAPIDataModel.gameDetails;

import com.google.gson.annotations.Expose;

import java.util.List;


public class Score {

    @Expose
    private List<String> linescore;
    @Expose
    private Object loss;
    @Expose
    private String points;
    @Expose
    private Object seriesLoss;
    @Expose
    private Object seriesWin;
    @Expose
    private Object win;

    public List<String> getLinescore() {
        return linescore;
    }

    public void setLinescore(List<String> linescore) {
        this.linescore = linescore;
    }

    public Object getLoss() {
        return loss;
    }

    public void setLoss(Object loss) {
        this.loss = loss;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public Object getSeriesLoss() {
        return seriesLoss;
    }

    public void setSeriesLoss(Object seriesLoss) {
        this.seriesLoss = seriesLoss;
    }

    public Object getSeriesWin() {
        return seriesWin;
    }

    public void setSeriesWin(Object seriesWin) {
        this.seriesWin = seriesWin;
    }

    public Object getWin() {
        return win;
    }

    public void setWin(Object win) {
        this.win = win;
    }

}
