package com.test.database.translate.Date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LocalDates {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println("today: " + now);
        // 获取指定日期对象
        LocalDate alonesBirthday = LocalDate.of(1903, 6, 14);
        alonesBirthday = LocalDate.of(1903, Month.JUNE, 14);
        System.out.println("alonesBirthday: " + alonesBirthday);
        // 获取指定日期指定天数后的日期
        LocalDate programmerDay = LocalDate.of(2018, 1, 1).plusDays(255);
        System.out.println("programmerDay: " + programmerDay);

        // 获取指定日期对象
        LocalDate independenceDay = LocalDate.of(2018, Month.JULY, 4);
        LocalDate christmas = LocalDate.of(2018, Month.DECEMBER, 25);

        // 获取两个日期的间隔天数
        System.out.println("Until christmas: " + independenceDay.until(christmas));
        System.out.println("Until christmas: " + independenceDay.until(christmas, ChronoUnit.DAYS));

        // 获取前一个和后一个月的日期对象
        System.out.println(LocalDate.of(2016, 1, 31).plusMonths(1));
        System.out.println(LocalDate.of(2016, 3, 31).minusMonths(1));

        // 获取星期对象 和指定的值
        DayOfWeek startOfLastMillennium = LocalDate.of(1900, 1, 1).getDayOfWeek();
        System.out.println("startOfLastMillennium: " + startOfLastMillennium);
        System.out.println(startOfLastMillennium.getValue());
        System.out.println(DayOfWeek.SATURDAY.plus(3));

        LocalDate start = LocalDate.of(2000, 1, 1);
        LocalDate endExclusive = LocalDate.now();
        // 获取开始日期到现在日期之间经历的每个月的流对象
        Stream<LocalDate> firstDaysInMonth = start.datesUntil(endExclusive, Period.ofMonths(1));
        System.out.println("firstDaysInMonth: " + firstDaysInMonth.collect(Collectors.toList()));
    }
}
