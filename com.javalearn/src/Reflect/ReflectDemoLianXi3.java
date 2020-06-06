package Reflect;

import MapLianXI.Person;

import java.lang.reflect.Constructor;

public class ReflectDemoLianXi3 {
    /*
     * 获取构造方法
     * */
    public static void main(String[] args) throws Exception {
        Class<Person> personClass = Person.class;
        // 获取无参数构造方法
        Person person = personClass.newInstance();
        System.out.println(person);
        // 获取有参构造方法 传递参数的Class对象
        Constructor<Person> constructor = personClass.getConstructor(String.class, Integer.class);
        // 创建对象 传递真实的变量
        Person luyuan = constructor.newInstance("陆远", 22);
        System.out.println(luyuan);
    }
}
