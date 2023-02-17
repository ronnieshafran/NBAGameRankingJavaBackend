package lambdaDataModel.stars;

import lambdaDataModel.stars.model.Star;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StarsProvider {


    private static final Star TRAE_YOUNG = Star.builder()
                                               .id("1046")
                                               .name("Young")
                                               .build();
    private static final Star DEJOUNTAE_MURRAY = Star.builder()
                                                     .id("382")
                                                     .name("Murray")
                                                     .build();
    private static final Star JAYSON_TATUM = Star.builder()
                                                 .id("882")
                                                 .name("Tatum")
                                                 .build();
    private static final Star JAYLEN_BROWN = Star.builder()
                                                 .id("75")
                                                 .name("Brown")
                                                 .build();
    private static final Star LAMELO_BALL = Star.builder()
                                                .id("2566")
                                                .name("Ball")
                                                .build();
    private static final Star DEMAR_DEROZAN = Star.builder()
                                                  .id("136")
                                                  .name("DeRozan")
                                                  .build();
    private static final Star ZACH_LAVINE = Star.builder()
                                                .id("308")
                                                .name("Lavine")
                                                .build();
    private static final Star DONOVAN_MITCHELL = Star.builder()
                                                     .id("840")
                                                     .name("Mitchell")
                                                     .build();
    private static final Star DARIUS_GARLAND = Star.builder()
                                                   .id("1860")
                                                   .name("Garland")
                                                   .build();
    private static final Star LUKA_DONCIC = Star.builder()
                                                .id("963")
                                                .name("Luka")
                                                .build();
    private static final Star KYRIE_IRVING = Star.builder()
                                                 .id("261")
                                                 .name("Kyrie")
                                                 .build();
    private static final Star NIKOLA_JOKIC = Star.builder()
                                                 .id("279")
                                                 .name("Jokic")
                                                 .build();
    private static final Star JAMAL_MURRAY = Star.builder()
                                                 .id("383")
                                                 .name("Murray")
                                                 .build();
    private static final Star CADE_CUNNINGHAM = Star.builder()
                                                    .id("2801")
                                                    .name("Cunningham")
                                                    .build();
    private static final Star KLAY_THOMPSON = Star.builder()
                                                  .id("514")
                                                  .name("Klay")
                                                  .build();
    private static final Star STEPH_CURRY = Star.builder()
                                                .id("124")
                                                .name("Steph")
                                                .build();
    private static final Star DRAYMOND_GREEN = Star.builder()
                                                   .id("204")
                                                   .name("Green")
                                                   .build();
    private static final Star JALEN_GREEN = Star.builder()
                                                .id("2810")
                                                .name("Green")
                                                .build();
    private static final Star TYRESE_HALIBURTON = Star.builder()
                                                      .id("2595")
                                                      .name("Haliburton")
                                                      .build();
    private static final Star KAWHI_LEONARD = Star.builder()
                                                  .id("314")
                                                  .name("Kawhi")
                                                  .build();
    private static final Star PAUL_GEORGE = Star.builder()
                                                .id("189")
                                                .name("PG")
                                                .build();
    private static final Star LEBRON_JAMES = Star.builder()
                                                 .id("265")
                                                 .name("LeBron")
                                                 .build();
    private static final Star ANTHONY_DAVIS = Star.builder()
                                                  .id("126")
                                                  .name("AD")
                                                  .build();
    private static final Star JARREN_JACKSON_JR = Star.builder()
                                                      .id("982")
                                                      .name("Jackson Jr.")
                                                      .build();
    private static final Star JA_MORANT = Star.builder()
                                              .id("1881")
                                              .name("Ja")
                                              .build();
    private static final Star JIMMY_BUTLER = Star.builder()
                                                 .id("86")
                                                 .name("Butler")
                                                 .build();
    private static final Star BAM_ADEBAYO = Star.builder()
                                                .id("724")
                                                .name("Bam")
                                                .build();
    private static final Star GIANNIS = Star.builder()
                                            .id("20")
                                            .name("Giannis")
                                            .build();
    private static final Star KHRIS_MIDDLETON = Star.builder()
                                                    .id("361")
                                                    .name("Middleton")
                                                    .build();
    private static final Star JRUE_HOLIDAY = Star.builder()
                                                 .id("242")
                                                 .name("Holiday")
                                                 .build();
    private static final Star KARL_ANTHONY_TOWNS = Star.builder()
                                                       .id("519")
                                                       .name("KAT")
                                                       .build();
    private static final Star ANTHONY_EDWARDS = Star.builder()
                                                    .id("2584")
                                                    .name("Ant")
                                                    .build();
    private static final Star BRANDON_INGRAM = Star.builder()
                                                   .id("260")
                                                   .name("Ingarm")
                                                   .build();
    private static final Star ZION_WILLIAMSON = Star.builder()
                                                    .id("1902")
                                                    .name("Zion")
                                                    .build();
    private static final Star CJ_MCCOLLUM = Star.builder()
                                                .id("347")
                                                .name("CJ")
                                                .build();
    private static final Star JULIUS_RANDLE = Star.builder()
                                                  .id("441")
                                                  .name("Randle")
                                                  .build();
    private static final Star JALEN_BRUNSON = Star.builder()
                                                  .id("946")
                                                  .name("Brunson")
                                                  .build();
    private static final Star SHAY_GILGOUS_ALEXANDER = Star.builder()
                                                           .id("972")
                                                           .name("SGA")
                                                           .build();
    private static final Star PAOLO_BANCHERO = Star.builder()
                                                   .id("3414")
                                                   .name("Banchero")
                                                   .build();
    private static final Star JOEL_EMBIID = Star.builder()
                                                .id("159")
                                                .name("Embiid")
                                                .build();
    private static final Star JAMES_HARDEN = Star.builder()
                                                 .id("216")
                                                 .name("Harden")
                                                 .build();
    private static final Star DEVIN_BOOKER = Star.builder()
                                                 .id("64")
                                                 .name("Booker")
                                                 .build();
    private static final Star KEVIN_DURANT = Star.builder()
                                                 .id("153")
                                                 .name("KD")
                                                 .build();
    private static final Star CHRIS_PAUL = Star.builder()
                                               .id("415")
                                               .name("CP3")
                                               .build();
    private static final Star DAMIAN_LILLARD = Star.builder()
                                                   .id("319")
                                                   .name("Dame")
                                                   .build();
    private static final Star DEAARON_FOX = Star.builder()
                                                .id("776")
                                                .name("Fox")
                                                .build();
    private static final Star DOMANTIS_SABONIS = Star.builder()
                                                     .id("463")
                                                     .name("Sabonis")
                                                     .build();
    private static final Star PASCAL_SIAKAM = Star.builder()
                                                  .id("479")
                                                  .name("Siakam")
                                                  .build();
    private static final Star FRED_VANVLEET = Star.builder()
                                                  .id("527")
                                                  .name("Vanvleet")
                                                  .build();
    private static final Star LAURI_MARKKANEN = Star.builder()
                                                    .id("830")
                                                    .name("Markkanen")
                                                    .build();
    private static final Star DENI_AVDIJA = Star.builder()
                                                .id("2564")
                                                .name("Deni")
                                                .build();
    private static final Star BRADLEY_BEAL = Star.builder()
                                                 .id("45")
                                                 .name("Beal")
                                                 .build();
    private static final Star KRISTAPS_PORZINGIS = Star.builder()
                                                       .id("432")
                                                       .name("Porzingis")
                                                       .build();


    public static final Map<String, List<Star>> TEAM_TO_STARS = new HashMap<>();

    static {
        TEAM_TO_STARS.put("1", List.of(TRAE_YOUNG, DEJOUNTAE_MURRAY)); //Hawks
        TEAM_TO_STARS.put("2", List.of(JAYSON_TATUM, JAYLEN_BROWN)); //Celtics
        TEAM_TO_STARS.put("4", List.of()); //Nets
        TEAM_TO_STARS.put("5", List.of(LAMELO_BALL)); //Nets
        TEAM_TO_STARS.put("6", List.of(DEMAR_DEROZAN, ZACH_LAVINE)); //Bulls
        TEAM_TO_STARS.put("7", List.of(DONOVAN_MITCHELL, DARIUS_GARLAND)); //Cavs
        TEAM_TO_STARS.put("8", List.of(LUKA_DONCIC, KYRIE_IRVING)); //Mavs
        TEAM_TO_STARS.put("9", List.of(NIKOLA_JOKIC, JAMAL_MURRAY)); //Nuggets
        TEAM_TO_STARS.put("10", List.of(CADE_CUNNINGHAM)); //Pistons
        TEAM_TO_STARS.put("11", List.of(STEPH_CURRY, KLAY_THOMPSON, DRAYMOND_GREEN)); //GSW
        TEAM_TO_STARS.put("14", List.of(JALEN_GREEN)); //Rockets
        TEAM_TO_STARS.put("15", List.of(TYRESE_HALIBURTON)); //Pacers
        TEAM_TO_STARS.put("16", List.of(KAWHI_LEONARD, PAUL_GEORGE)); //Clippers
        TEAM_TO_STARS.put("17", List.of(LEBRON_JAMES, ANTHONY_DAVIS)); //Lakers
        TEAM_TO_STARS.put("19", List.of(JA_MORANT, JARREN_JACKSON_JR)); //Grizzlies
        TEAM_TO_STARS.put("20", List.of(JIMMY_BUTLER, BAM_ADEBAYO)); //Heat
        TEAM_TO_STARS.put("21", List.of(GIANNIS, KHRIS_MIDDLETON, JRUE_HOLIDAY)); //Bucks
        TEAM_TO_STARS.put("22", List.of(KARL_ANTHONY_TOWNS, ANTHONY_EDWARDS)); //Timberwolves
        TEAM_TO_STARS.put("23", List.of(CJ_MCCOLLUM, ZION_WILLIAMSON, BRANDON_INGRAM)); //Pelicans
        TEAM_TO_STARS.put("24", List.of(JULIUS_RANDLE, JALEN_BRUNSON)); //Knicks
        TEAM_TO_STARS.put("25", List.of(SHAY_GILGOUS_ALEXANDER)); //Thunder
        TEAM_TO_STARS.put("26", List.of(PAOLO_BANCHERO)); //Magic
        TEAM_TO_STARS.put("27", List.of(JAMES_HARDEN, JOEL_EMBIID)); //76ers
        TEAM_TO_STARS.put("28", List.of(KEVIN_DURANT, DEVIN_BOOKER, CHRIS_PAUL)); //Suns
        TEAM_TO_STARS.put("29", List.of(DAMIAN_LILLARD)); //Blazers
        TEAM_TO_STARS.put("30", List.of(DEAARON_FOX, DOMANTIS_SABONIS)); //Kings
        TEAM_TO_STARS.put("31", List.of()); //Spurs
        TEAM_TO_STARS.put("38", List.of(PASCAL_SIAKAM, FRED_VANVLEET)); //Raptors
        TEAM_TO_STARS.put("40", List.of(LAURI_MARKKANEN)); //Jazz
        TEAM_TO_STARS.put("41", List.of(DENI_AVDIJA, BRADLEY_BEAL, KRISTAPS_PORZINGIS)); //Wizards
    }

    public static List<Star> getStarsForTeams(final String homeTeamId, final String awayTeamId) {
        return Stream.concat(TEAM_TO_STARS.get(homeTeamId)
                                          .stream(),
                             TEAM_TO_STARS.get(awayTeamId)
                                          .stream())
                     .collect(Collectors.toList());
    }
}
