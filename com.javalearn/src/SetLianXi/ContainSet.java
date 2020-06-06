package SetLianXi;

import java.util.HashSet;

public class ContainSet {
    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();
        Person p1 = new Person("老美女",99);
        Person p2 = new Person("老美女",99);
        Person p3 = new Person("老美女",98);
/*
        存储自定义元素先调用hashCode方法比较hashzhi不存在则添加，存在调用equals方法比较值，
        相同则不添加，不相同则添加
        所以在添加自定义元素的时候要重写equals方法和hashcode方法
*/
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println(set);
    }
}
