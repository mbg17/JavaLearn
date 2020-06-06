package Reflect;

import MapLianXI.Person;
/*
* 获取Class对象
* 同一个字节码文件在程序的一次执行中只会加载一次
* */
public class ReflectDemoLianXI {
    public static void main(String[] args) throws Exception {
        // 通过全类名获取class对象 用于配置文件
        Class aClass = Class.forName("MapLianXI.Person");
        System.out.println(aClass);
        // 通过类名属性获取class对象 用于参数的传递
        Class personClass = Person.class;
        System.out.println(personClass);
        // 通过类对象成员方法获取Class对象
        Class aClass1 = new Person().getClass();
        System.out.println(aClass1);
    }
}
