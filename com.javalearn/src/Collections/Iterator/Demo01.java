package Collections.Iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo01 {
/*
    hasNext:判断是否还有下一个对象
    next:获取下一个对象
*/
    public static void main(String[] args) {
        // 实例化一个A仍然有List集合
        Collection<String> coll = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            coll.add(i+"");
        }
        // 获取迭代器对象,泛型跟着对象走
        // 获取迭代器对象期间不能操作集合
        Iterator<String> iterator = coll.iterator();
        // while循环遍历
        while(iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);
        }
        // foreach 增强for循环写法
        /*格式：
        for (泛型类型 变量名:数组or集合
             ) {
        }*/
        for (String s:coll) {
            System.out.println(s);
        }
    }
}
