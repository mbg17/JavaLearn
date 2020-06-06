package SetLianXi;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetLianXi {
//    无索引
//    不能添加重复元素
//    哈希表结构，查询速度特别快
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("1");
        System.out.println(set);
//        迭代器遍历
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next());
        }
        System.out.println("++++++++++++++++++++");
//        遍历方式
        for (String s : set) {
            System.out.print(s);
        }
    }
}
