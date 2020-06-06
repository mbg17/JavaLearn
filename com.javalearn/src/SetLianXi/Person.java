package SetLianXi;

import java.util.Objects;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
    // 存储元素时向调用hashCode，在调用equals
    @Override
    public boolean equals(Object o) {
        // 两个对象一直直接返回true
        if (this == o) return true;
         // 通过反射比较是不是当前类
        if (o == null || getClass() != o.getClass()) return false;
        // 对象向下转型
        Person person = (Person) o;
        // 比较对象的年龄和姓名是否一直
        return age == person.age &&
                Objects.equals(name, person.name);
    }
    @Override
    public int hashCode() {
        // 先用当前对象的姓名和年龄计算哈希值
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
