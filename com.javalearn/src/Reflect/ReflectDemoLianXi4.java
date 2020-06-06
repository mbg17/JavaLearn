package Reflect;

import MapLianXI.Person;

import java.lang.reflect.Method;

/*
* 获取成员方法
* */
public class ReflectDemoLianXi4 {
    public static void main(String[] args) throws Exception {
        Class<Person> personClass = Person.class;
        // 获取无参方法
        Method eat = personClass.getMethod("eat");
        // 获取方法名
        String name = eat.getName();
        System.out.println("方法名为"+name);
        // 指向方法
        eat.invoke(new Person());
        // 获取有参方法 传递参数的字节码对象
        Method eat2 = personClass.getMethod("eat",String.class);
        eat2.invoke(new Person(),"饭");
    }
}
