package MapLianXI;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StorageMap {
    public static void main(String[] args) {
        HashMap<Person,String> map = new HashMap<>();
        map.put(new Person("haha",20),"1");
        map.put(new Person("xixi",20),"2");
        map.put(new Person("lala",20),"3");
        map.put(new Person("haha",18),"4");
        System.out.println(map);
        // 遍历Map集合的两种方法
        // 1.keySet()
        Set<Person> people = map.keySet();
        Iterator<Person> iterator = people.iterator();
        System.out.println("{");
        while(iterator.hasNext()){
            Person p = iterator.next();
            System.out.println("    "+ p.getName()+":"+map.get(p));
        }
        System.out.println("}");
        // entrySet
        Set<Map.Entry<Person, String>> entries = map.entrySet();
        for (Map.Entry<Person, String> entry : entries) {
            System.out.println(entry.getKey().getName()+":"+entry.getValue());
        }
    }
}
