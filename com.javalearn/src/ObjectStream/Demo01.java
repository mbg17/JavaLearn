package ObjectStream;

import java.io.*;
import java.util.ArrayList;

public class Demo01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("陆远",20));
        list.add(new Student("蔡徐坤",40));
        list.add(new Student("孙笑川",500));
        // 使用序列化流写入文件
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\JAVA\\com.javalearn\\src\\ObjectStream\\list.txt"));
        objectOutputStream.writeObject(list);
        objectOutputStream.close();

        // 使用反序列化读取对象
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\JAVA\\com.javalearn\\src\\ObjectStream\\list.txt"));
        Object o = objectInputStream.readObject();
        ArrayList<Student> list2 = (ArrayList<Student>)o;// 向下转型
        for (Student student : list2) {
            System.out.println(student);
        }
        objectInputStream.close();
    }
}

class Student implements Serializable{// 标记接口，代表可以序列化该对象
    private String name;
    private Integer age;
    private final static long serialVersionUID = 42L;// 设置固定的序列化UID

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
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
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}