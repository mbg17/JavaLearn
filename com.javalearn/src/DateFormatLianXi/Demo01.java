package DateFormatLianXi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo01 {
    public static void main(String[] args) throws ParseException {
        // DateFormat是抽象类不能直接使用，必须调用他的实现类SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//传入指定的格式
        // 将时间转换成指定格式
        String timeString = sdf.format(new Date());
        System.out.println(timeString);
        // 解析时间字符串为Date对象,有抛出异常需要手动捕获或者继续抛出
        Date timeParse = sdf.parse("1994-09-29");
        System.out.println(timeParse);
    }
}
