package SetLianXi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class demo01 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(map.get(s));
        }
    }
}
