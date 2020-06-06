package CollectionsLianXi;

// 实现 Comparable 的compareTo方法
public class Student implements  Comparable<Student>{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
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

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }
    // 排序调用该方法
    @Override
    public int compareTo(Student s) {
        // 自己-参数升序
        // 参数-自己降序
        // 配合Collectiongs.sort使用
        return this.getAge()-s.getAge();
    }
}
