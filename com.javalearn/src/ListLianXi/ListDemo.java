package ListLianXi;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    /*
    1.有序列表
    2.有索引
    3.可以存储重复元素
    */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println(list);
        // 指定位置添加元素
        list.add(2,"5");
        System.out.println(list);
        // 删除指定索引的元素并返回
        String removeE = list.remove(2);
        System.out.println(removeE);
        // 设置指定索引位置的元素并返回被替换的元素
        String setE = list.set(2, "6");
        System.out.println(list);
        System.out.println(setE);
        // 获取指定索引的元素
        String s = list.get(0);
        System.out.println(s);
    }
}
