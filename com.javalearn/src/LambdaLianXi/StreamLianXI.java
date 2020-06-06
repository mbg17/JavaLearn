package LambdaLianXi;

import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;
/*
* 获取Stream流对象的两个方法
*   Stream.of(),参数为单列集合或者多个同类型的数据
*   Collection.stream(),单列集合的成员方法获取Stream流对象
* 终结方法
*   foreach：参数为Consumer 函数式消费接口，遍历Stream流中的对象
*   count: 返回Stream流中对象的个数
* 延迟方法：
*   filter: 参数为Predicate 函数式判断接口，用来过滤流中的对象，返回Stram流的对象
*   limit： 参数为long类型的数字，只要前几个流中的对象，返回Stram流的对象
*   skip： 参数为long类型的数字，跳过前几个流中的对象，返回Stram流的对象
*   map： 参数为Function对象，转换列表中的数据，返回Stram流的对象
*   concat（Stream的静态方法）： 拼接两个Stram流对象，返回合并后新的Stram流的对象
* */
public class StreamLianXI {
    public static void main(String[] args) {
        ArrayList<String> duiwu1 = new ArrayList<>();
        duiwu1.addAll(Arrays.asList("呵呵", "蔡徐坤", "大司马", "我去", "张张", "孙笑川", "肖战", "唐玛丽", "张三", "张与", "张嘻嘻"));
        ArrayList<String> duiwu2 = new ArrayList<>();
        duiwu2.addAll(Arrays.asList("张一", "阿萨德", "马尔扎哈", "嘻嘻", "张点分", "笑孙川", "张肖战", "唐丽", "张电饭锅三", "张分割与", "张分割嘻嘻"));
        ArrayList<Persons> pers = new ArrayList<>();
        Stream.concat(
                duiwu1.stream().filter(name -> name.length() == 3).limit(3),
                duiwu2.stream().filter(name -> name.startsWith("张")).skip(2)
        ).map(name->new Persons(name)).forEach(System.out::println);

    }
}
