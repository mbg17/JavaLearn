package com.test.database.translate.Date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Locale;

public class Formatting {
    public static void main(String[] args) {
        ZonedDateTime apollolllaunch = ZonedDateTime.of(1969, 7, 16, 9, 32, 0, 0, ZoneId.of("America/New_York"));
        String formatted = DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(apollolllaunch);
        System.out.println(formatted);

        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        formatted = formatter.format(apollolllaunch);
        System.out.println(formatted);

        formatted = formatter.withLocale(Locale.FRANCE).format(apollolllaunch);
        System.out.println(formatted);

        formatter = DateTimeFormatter.ofPattern("E yyyy-MM-dd HH:mm");
        formatted = formatter.format(apollolllaunch);
        System.out.println(formatted);

        LocalDate churchBirthday = LocalDate.parse("1903-06-14");
        System.out.println(churchBirthday);

        apollolllaunch = ZonedDateTime.parse("1969-07-16 03:31:00-0400", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssxx"));
        System.out.println(apollolllaunch);
        Arrays.stream(DayOfWeek.values()).forEach(w -> System.out.println(w.getDisplayName(TextStyle.SHORT, Locale.ENGLISH) + " "));
    }
}
