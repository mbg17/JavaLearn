package LiveTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HLDJ {
    public static void main(String[] args) throws ParseException  {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入你的生日");
        String birthday = sc.next();
        System.out.println(sumTime(birthday));
    }
    public static String sumTime(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date birthday = sdf.parse(time);
        Date now = new Date();
//        System.out.println(now.getTime());
//        System.out.println(birthday.getTime());
        long sum = now.getTime()-birthday.getTime();
        String life = sdf.format(sum);
        return "活了"+sdf.parse(life).getTime()/1000/60/60/24+"天";
    }
}
