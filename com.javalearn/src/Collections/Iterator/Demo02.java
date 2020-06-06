package Collections.Iterator;

import java.util.ArrayList;
import java.util.Collection;

public class Demo02 {
/*
    Collection:
        boolean add();// 添加元素
        void clear();// 清空集合
        boolean remove();// 移除元素
        boolean contains();// 判断是否包含元素
        boolean isEmpty();// 判断是否为空
        int size();// 获取集合长度
        Object[] toArray();// 将集合转换成Object数组
*/
    public static void main(String[] args) {
        // 创建集合对象
        Collection<Integer> coll = new ArrayList<>();// 多态
        coll.add(1);
        coll.add(2);
        boolean t1 = coll.remove(3);
        boolean t2 = coll.remove(2);
        System.out.println(t1);
        System.out.println(t2);
        boolean t3 = coll.isEmpty();
        System.out.println(t3);
        boolean t4 = coll.contains(1);
        System.out.println(t4);
        int size = coll.size();
        System.out.println(size);
        Object[] array = coll.toArray();
        bianLi(array);
        coll.clear();
        boolean t5 = coll.isEmpty();
        System.out.println(t5);

    }
    public static void bianLi(Object[] array){
        for (Object i:array
             ) {
            System.out.println(i);
        }
    }
}
