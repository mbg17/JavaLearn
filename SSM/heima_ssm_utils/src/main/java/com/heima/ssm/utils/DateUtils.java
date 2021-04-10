package com.heima.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class DateUtils {

    public static String dateToString(Date date, String patt){
        SimpleDateFormat simpleFormatter = new SimpleDateFormat(patt);
        String format = simpleFormatter.format(date);
        return format;
    }

    public static Date string2Date(String str, String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date parse = sdf.parse(str);
        return parse;
    }
}
