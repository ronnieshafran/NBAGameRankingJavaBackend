
package rapidAPIDataModel.gameDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Game {

    @Expose
    private String arena;
    @Expose
    private String city;
    @Expose
    private String clock;
    @Expose
    private String country;
    @Expose
    private String currentPeriod;
    @SerializedName("EndOfPeriod")
    private String endOfPeriod;
    @Expose
    private String endTimeUTC;
    @Expose
    private String gameDuration;
    @Expose
    private String gameId;
    @Expose
    private HTeam hTeam;
    @Expose
    private String halftime;
    @Expose
    private String leadChanges;
    @Expose
    private String league;
    @Expose
    private List<Object> officials;
    @Expose
    private String seasonStage;
    @Expose
    private String seasonYear;
    @Expose
    private String startTimeUTC;
    @Expose
    private String statusGame;
    @Expose
    private String statusShortGame;
    @Expose
    private String timesTied;
    @Expose
    private VTeam vTeam;

    public String getArena() {
        return arena;
    }

    public void setArena(String arena) {
        this.arena = arena;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(String currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public String getEndOfPeriod() {
        return endOfPeriod;
    }

    public void setEndOfPeriod(String endOfPeriod) {
        this.endOfPeriod = endOfPeriod;
    }

    public String getEndTimeUTC() {
        return endTimeUTC;
    }

    public void setEndTimeUTC(String endTimeUTC) {
        this.endTimeUTC = endTimeUTC;
    }

    public String getGameDuration() {
        return gameDuration;
    }

    public void setGameDuration(String gameDuration) {
        this.gameDuration = gameDuration;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public HTeam getHTeam() {
        return hTeam;
    }

    public void setHTeam(HTeam hTeam) {
        this.hTeam = hTeam;
    }

    public String getHalftime() {
        return halftime;
    }

    public void setHalftime(String halftime) {
        this.halftime = halftime;
    }

    public String getLeadChanges() {
        return leadChanges;
    }

    public void setLeadChanges(String leadChanges) {
        this.leadChanges = leadChanges;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public List<Object> getOfficials() {
        return officials;
    }

    public void setOfficials(List<Object> officials) {
        this.officials = officials;
    }

    public String getSeasonStage() {
        return seasonStage;
    }

    public void setSeasonStage(String seasonStage) {
        this.seasonStage = seasonStage;
    }

    public String getSeasonYear() {
        return seasonYear;
    }

    public void setSeasonYear(String seasonYear) {
        this.seasonYear = seasonYear;
    }

    public String getStartTimeUTC() {
        return startTimeUTC;
    }

    public void setStartTimeUTC(String startTimeUTC) {
        this.startTimeUTC = startTimeUTC;
    }

    public String getStatusGame() {
        return statusGame;
    }

    public void setStatusGame(String statusGame) {
        this.statusGame = statusGame;
    }

    public String getStatusShortGame() {
        return statusShortGame;
    }

    public void setStatusShortGame(String statusShortGame) {
        this.statusShortGame = statusShortGame;
    }

    public String getTimesTied() {
        return timesTied;
    }

    public void setTimesTied(String timesTied) {
        this.timesTied = timesTied;
    }

    public VTeam getVTeam() {
        return vTeam;
    }

    public void setVTeam(VTeam vTeam) {
        this.vTeam = vTeam;
    }

}
