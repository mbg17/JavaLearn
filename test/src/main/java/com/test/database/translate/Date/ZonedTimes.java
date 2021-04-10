package com.test.database.translate.Date;

import java.time.*;

public class ZonedTimes {
    public static void main(String[] args) {
        /**
         * LocalDateTime总是表示本地日期和时间，要表示一个带时区的日期和时间，我们就需要ZonedDateTime。
         *
         * 可以简单地把ZonedDateTime理解成LocalDateTime加ZoneId。ZoneId是java.time引入的新的时区类，注意和旧的java.util.TimeZone区别。
         */
        ZonedDateTime apollolllaunch =
                ZonedDateTime.of(1969, 7, 16, 9, 32, 0, 0,
                        ZoneId.of("America/New_York"));
        System.out.println("apollolllaunch: " + apollolllaunch);

        Instant instant = apollolllaunch.toInstant();
        System.out.println("instant: " + instant);

        ZonedDateTime utc = instant.atZone(ZoneId.of("UTC"));
        System.out.println("UTC: " + utc);

        ZonedDateTime skipped = ZonedDateTime.of(
                LocalDate.of(2013, 3, 31),
                LocalTime.of(2, 30),
                ZoneId.of("Europe/Berlin"));
        System.out.println("skipped: " + skipped);

        ZonedDateTime ambiguous = ZonedDateTime.of(
                LocalDate.of(2013, 10, 27),
                LocalTime.of(2, 30),
                ZoneId.of("Europe/Berlin")
        );
        ZonedDateTime anHourLater = ambiguous.plusHours(1);
        System.out.println("ambiguous: " + ambiguous);
        System.out.println("anHourLater: " + anHourLater);

        ZonedDateTime meeting = ZonedDateTime.of(LocalDate.of(2013, 10, 31),
                LocalTime.of(14, 30),
                ZoneId.of("America/Los_Angeles"));
        // 调整跨越夏令时边界的日期不要使用Duration
        ZonedDateTime nextMeeting = meeting.plus(Duration.ofDays(7));
        System.out.println("nextMeeting: " + nextMeeting);
        nextMeeting = meeting.plus(Period.ofDays(7));
        System.out.println("nextMeeting: " + nextMeeting);
    }
}
