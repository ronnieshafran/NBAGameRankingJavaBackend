
package rapidAPIDataModel.gameDetails;

import com.google.gson.annotations.Expose;

import java.util.List;


public class VTeam {

    @Expose
    private String allStar;
    @Expose
    private String fullName;
    @Expose
    private List<Object> leaders;
    @Expose
    private String logo;
    @Expose
    private String nbaFranchise;
    @Expose
    private String nickname;
    @Expose
    private Score score;
    @Expose
    private String shortName;
    @Expose
    private String teamId;
    @Expose
    private String url;

    public String getAllStar() {
        return allStar;
    }

    public void setAllStar(String allStar) {
        this.allStar = allStar;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Object> getLeaders() {
        return leaders;
    }

    public void setLeaders(List<Object> leaders) {
        this.leaders = leaders;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNbaFranchise() {
        return nbaFranchise;
    }

    public void setNbaFranchise(String nbaFranchise) {
        this.nbaFranchise = nbaFranchise;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
