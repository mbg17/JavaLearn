package CollectionsLianXi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo01 {
    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<>();
        Collections.addAll(array,new Student("陆远",18),new Student("是的",20),new Student("陆是",17));
        Collections.sort(array);// 排序调用compareTo 需要实现Comparable的compareTo方法
        System.out.println(array);
        // 方式2 传递排序规则
        Collections.sort(array, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // 自己-参数升序
                // 参数-自己降序
                // 配合Collectiongs.sort使用
                return o2.getAge() -o1.getAge();
            }
        });
        System.out.println(array);
    }
    // 可变参数
    public static int add(int...nums){
        int sum = 0;
        for (int i : nums) {
            sum+=i;
        }
        return sum;
    }
}
