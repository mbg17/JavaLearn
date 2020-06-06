package LambdaLianXi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Demo01 {
    // 函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
    public static void main(String[] args) {
        // 无参数的lambda函数
        invokeCook((int i) -> {
            System.out.println("饭做好了"+i);
        },1);

        // 有参数的lambda函数
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("陆远", 20));
        list.add(new Person("哈哈", 15));
        list.add(new Person("嗯嗯", 23));
        Collections.sort(list, (Person o1, Person o2) -> {
            return o1.getAge() - o2.getAge();
        });

        // 省略格式
        // Collections.sort(list, (o1, o2) ->o1.getAge() - o2.getAge());

        for (Person person : list) {
            System.out.println(person);
        }

        Person[] plist = {new Person("xixi", 40), new Person("hehe", 12), new Person("huhu", 18)};
//        Arrays.sort(plist,(Person o1, Person o2) -> {
//            return o1.getAge() - o2.getAge();
//        });

        // 省略格式
         Arrays.sort(plist,(o1,o2) -> o1.getAge() - o2.getAge());
        for (Person person : plist) {
            System.out.println(person);
        }
    }


    public static void invokeCook(Cook c,int i) {
        c.makeFood(1);
    }
}

interface Cook {
    void makeFood(int i);
}

class Person {
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}