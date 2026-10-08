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
    private static final Star COOPER_FLAGG = Star.builder()
            .id("4320")
            .name("Flagg")
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
    private static final Star STEPH_CURRY = Star.builder()
                                                .id("124")
                                                .name("Steph")
                                                .build();
    private static final Star DRAYMOND_GREEN = Star.builder()
                                                   .id("204")
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
    private static final Star LAURI_MARKKANEN = Star.builder()
                                                    .id("830")
                                                    .name("Markkanen")
                                                    .build();
    private static final Star DENI_AVDIJA = Star.builder()
                                                .id("2564")
                                                .name("Deni")
                                                .build();
    private static final Star VICTOR_WEMBENYAMA = Star.builder()
            .id("4026")
            .name("Wemby")
            .build();
    private static final Star FRANZ_WAGNER = Star.builder()
            .id("2858")
            .name("Wagner")
            .build();
    private static final Star TYRESE_MAXEY = Star.builder()
            .id("2619")
            .name("Maxey")
            .build();
    private static final Star DESMOND_BANE = Star.builder()
            .id("2568")
            .name("Bane")
            .build();
    private static final Star ALPERN_SENGUN = Star.builder()
            .id("2847")
            .name("Sengun")
            .build();

    private static final Star AMEN_THOMPHSON = Star.builder()
            .id("3977")
            .name("Amen")
            .build();

    private static final Star JALEN_JOHNSON = Star.builder()
            .id("2819")
            .name("Johnson")
            .build();

    private static final Star BRANDON_MILLER = Star.builder()
            .id("3950")
            .name("Miller")
            .build();

    private static final Star CHET_HOLMGREN = Star.builder()
            .id("3448")
            .name("Holmgren")
            .build();

    private static final Star JALEN_WILLIAMS = Star.builder()
            .id("3504")
            .name("Williams")
            .build();

    private static final Star SCOTTIE_BARNES = Star.builder()
            .id("2789")
            .name("Barnes")
            .build();

    public static final Map<String, List<Star>> TEAM_TO_STARS = new HashMap<>();

    static {
        TEAM_TO_STARS.put(Teams.HAWKS_ID, List.of(JALEN_JOHNSON)); //Hawks
        TEAM_TO_STARS.put(Teams.CELTICES_ID, List.of(JAYSON_TATUM, PAUL_GEORGE)); //Celtics
        TEAM_TO_STARS.put(Teams.NETS_ID, List.of(JULIUS_RANDLE)); //Nets
        TEAM_TO_STARS.put(Teams.HORNETS_ID, List.of(BRANDON_MILLER)); //Hornets
        TEAM_TO_STARS.put(Teams.BULLS_ID, List.of()); //Bulls
        TEAM_TO_STARS.put(Teams.CAVS_ID, List.of(DONOVAN_MITCHELL, JAMES_HARDEN)); //Cavs
        TEAM_TO_STARS.put(Teams.MAVS_ID, List.of(COOPER_FLAGG, KYRIE_IRVING)); //Mavs
        TEAM_TO_STARS.put(Teams.NUGGETS_ID, List.of(NIKOLA_JOKIC, JAMAL_MURRAY)); //Nuggets
        TEAM_TO_STARS.put(Teams.PISTONS_ID, List.of(CADE_CUNNINGHAM)); //Pistons
        TEAM_TO_STARS.put(Teams.WARRIORS_ID, List.of(STEPH_CURRY, DRAYMOND_GREEN, JIMMY_BUTLER)); //GSW
        TEAM_TO_STARS.put(Teams.ROCKETS_ID, List.of(KEVIN_DURANT, ALPERN_SENGUN, AMEN_THOMPHSON)); //Rockets
        TEAM_TO_STARS.put(Teams.PACERS_ID, List.of(TYRESE_HALIBURTON, PASCAL_SIAKAM)); //Pacers
        TEAM_TO_STARS.put(Teams.CLIPPERS_ID, List.of(DARIUS_GARLAND, BRANDON_INGRAM)); //Clippers
        TEAM_TO_STARS.put(Teams.LAKERS_ID, List.of(LUKA_DONCIC)); //Lakers
        TEAM_TO_STARS.put(Teams.GRIZZLIES_ID, List.of()); //Grizzlies
        TEAM_TO_STARS.put(Teams.HEAT_ID, List.of(GIANNIS, BAM_ADEBAYO)); //Heat
        TEAM_TO_STARS.put(Teams.BUCKS_ID, List.of()); //Bucks
        TEAM_TO_STARS.put(Teams.WOLVES_ID, List.of(ANTHONY_EDWARDS, LAMELO_BALL)); //Timberwolves
        TEAM_TO_STARS.put(Teams.PELICANS_ID, List.of(ZION_WILLIAMSON, DEJOUNTAE_MURRAY)); //Pelicans
        TEAM_TO_STARS.put(Teams.KNICKS_ID, List.of(JALEN_BRUNSON, KARL_ANTHONY_TOWNS)); //Knicks
        TEAM_TO_STARS.put(Teams.THUNDER_ID, List.of(SHAY_GILGOUS_ALEXANDER, JALEN_WILLIAMS, CHET_HOLMGREN)); //Thunder
        TEAM_TO_STARS.put(Teams.MAGIC_ID, List.of(PAOLO_BANCHERO, FRANZ_WAGNER, DESMOND_BANE)); //Magic
        TEAM_TO_STARS.put(Teams.SIXERS_ID, List.of(JOEL_EMBIID, JAYLEN_BROWN, TYRESE_MAXEY, LEBRON_JAMES)); //76ers
        TEAM_TO_STARS.put(Teams.SUNS_ID, List.of(DEVIN_BOOKER)); //Suns
        TEAM_TO_STARS.put(Teams.BLAZERS_ID, List.of(DENI_AVDIJA, JA_MORANT)); //Blazers
        TEAM_TO_STARS.put(Teams.KINGS_ID, List.of(DOMANTIS_SABONIS)); //Kings
        TEAM_TO_STARS.put(Teams.SPURS_ID, List.of(DEAARON_FOX, VICTOR_WEMBENYAMA)); //Spurs
        TEAM_TO_STARS.put(Teams.RAPTORS_ID, List.of(KAWHI_LEONARD, SCOTTIE_BARNES)); //Raptors
        TEAM_TO_STARS.put(Teams.JAZZ_ID, List.of(LAURI_MARKKANEN, JARREN_JACKSON_JR)); //Jazz
        TEAM_TO_STARS.put(Teams.WIZARDS_ID, List.of(TRAE_YOUNG, ANTHONY_DAVIS)); //Wizards
    }

    public static List<Star> getStarsForTeams(final String homeTeamId, final String awayTeamId) {
        return Stream.concat(TEAM_TO_STARS.get(homeTeamId)
                                          .stream(),
                             TEAM_TO_STARS.get(awayTeamId)
                                          .stream())
                     .collect(Collectors.toList());
    }
}
