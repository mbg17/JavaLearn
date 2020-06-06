package Reflect;

import MapLianXI.Person;

import java.lang.reflect.Field;
/*
* 获取成员变量
* */
public class ReflectDemoLianXi2 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        // 获取全类名
        System.out.println(personClass.getName());
        // 获取Class对象下所有public修饰的成员变量
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        // 获取指定变量名public修饰的成员变量
        Field a = personClass.getField("a");
        System.out.println(a);
        // 获取所有成员变量
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        // 获取指定变量名的成员变量
        Field age = personClass.getDeclaredField("age");
        System.out.println(age);
        // 给对象赋值 需要生成对象
        Person person = new Person();
        // 私有属性的变量获取值或者赋值必须忽略安全检查，暴力破解
        age.setAccessible(true);
        // 获取值
        Object o = a.get(person);
        System.out.println(o);
        // 设置值
        age.set(person,20);
        System.out.println(person);
    }
}
