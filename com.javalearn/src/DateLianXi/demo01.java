package DateLianXi;

import java.util.Date;

public class demo01 {
    public static void main(String[] args) {
        Date data = new Date();//获取当前时间
        long time = data.getTime();// 获取经过了多少毫秒（相对于1970-01-01-00：00：00）
        String dateTime = data.toString();// 时间对象转换成字符串
        System.out.println(data);
        System.out.println(time);
        System.out.println(dateTime);
    }
}
