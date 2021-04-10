package com.test.database.translate.基础;

class Date {
    private final int month;
    private final int day;
    private final int year;

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public int year() {
        return year;
    }

    @Override
    public String toString() {
        return month() +
                "/" + day() +
                "/" + year();
    }

    public Date[] readDates(String s) {
        String[] split = s.split("\\|");
        Date[] dates = new Date[split.length];
        for (int i = 0; i < dates.length; i++) {
            String[] s1 = split[i].split("/");
            dates[i] = new Date(Integer.parseInt(s1[0]), Integer.parseInt(s1[1]), Integer.parseInt(s1[2]));
        }
        return dates;
    }
}
