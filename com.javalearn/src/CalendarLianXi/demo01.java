package CalendarLianXi;

import java.util.Calendar;
import java.util.Date;

public class demo01 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();// 实例化日历对象
        // 获取指定的值
        // 年
        int year = c.get(Calendar.YEAR);
        // 月
        int month = c.get(Calendar.MONTH);
        // 日
        int day = c.get(Calendar.DATE);
        System.out.println(year + "年" + (month+1) + "月" + day + "日");

        // 设置值
        // 年
        c.set(Calendar.YEAR, 2020);
        // 月
        c.set(Calendar.MONTH, 4);
        // 日
        c.set(Calendar.DATE, 20);
        // 设置多个值
        c.set(2020,9,9);
        // 将日历对象转换成Date对象
        Date date = c.getTime();
        System.out.println(date);
    }
}
