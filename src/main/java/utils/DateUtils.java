package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static final DateTimeFormatter YYYY_MM_DD_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String getTodayDate() {
        LocalDate today = LocalDate.now();
        return today.format(YYYY_MM_DD_FORMATTER);
    }

    public static String getYesterdaysDate() {
        LocalDate yesterday = LocalDate.now()
                                       .minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return yesterday.format(formatter);
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
}
