package rapidAPIDataModel.gamesFromDate;

import com.google.gson.annotations.Expose;

import java.util.List;


public class Api {

    @Expose
    private List<String> filters;
    @Expose
    private List<Game> games;
    @Expose
    private String message;
    @Expose
    private Long results;
    @Expose
    private Long status;

    public List<String> getFilters() {
        return filters;
    }

    public void setFilters(List<String> filters) {
        this.filters = filters;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getResults() {
        return results;
    }

    public void setResults(Long results) {
        this.results = results;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

}
