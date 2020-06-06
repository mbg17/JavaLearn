package MapLianXI;

import java.util.Objects;

public class Person {
    private String name;
    private Integer age;
    public String a;
    public String b;
    public String c;
    public String d;
    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    // HashSet 和Hashmap 确定唯一值得时候必须重写equals和hashCode犯法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
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
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }

    public void eat(){
        System.out.println("eat");
    }

    public void eat(String food){
        System.out.println("eat"+food);
    }
}
