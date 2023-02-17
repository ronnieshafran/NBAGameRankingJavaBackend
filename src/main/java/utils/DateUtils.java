package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DateUtils {

    public static final DateTimeFormatter YYYY_MM_DD_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String getTodayDate() {
        LocalDate today = LocalDate.now();
        return today.format(YYYY_MM_DD_FORMATTER);
    }

    public static String getYesterdaysDate() {
        LocalDate yesterday = LocalDate.now()
                                       .minusDays(1);
        return yesterday.format(YYYY_MM_DD_FORMATTER);
    }

    public static String getDayBefore(String dateString) {
        LocalDate date = LocalDate.parse(dateString, YYYY_MM_DD_FORMATTER);
        LocalDate dayBefore = date.minusDays(1);
        return dayBefore.format(YYYY_MM_DD_FORMATTER);
    }

    public static int extractHour(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime date = LocalDateTime.parse(dateString, formatter);
        return date.getHour();
    }

    public static List<String> getDatesFromBeginningOf2023() {
        final List<String> dates = new ArrayList<>();
        final LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate currentDate = LocalDate.now();
        while (!currentDate.isBefore(startDate)) {
            dates.add(currentDate.format(YYYY_MM_DD_FORMATTER));
            currentDate = currentDate.minusDays(1);
        }
        return dates;
    }
}
