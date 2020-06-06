package MapLianXI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CountChar {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("输入你要统计的字符串");
        String s = sc.next();
        sum(s);
    }
    public static void sum(String s){
        // 将字符串转成字符数组
        char[] array = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for (char c : array) {
            // 判断是否存在键
            if(map.containsKey(c)){
                Integer integer = map.get(c);
                map.put(c,integer+=1);
            }else{
                map.put(c,1);
            }
        }
        System.out.println(map);
    }
}
