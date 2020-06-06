package Genericity;

public class Demo01 {
    public static void main(String[] args) {
        // 创建泛型类对象
        ClassGenericity<String> g1 = new ClassGenericity<>();
        g1.setName("哈哈");
        System.out.println(g1.getName());
        // 泛型接口类实现方法1
        Impl1InterfaceGenericity im1 = new Impl1InterfaceGenericity();
        im1.set("heihei");
        System.out.println(im1.get());
        // 泛型接口类实现方法2
        Impl2InterfaceGenericity<String> im2 = new Impl2InterfaceGenericity();
        im2.set("heihei2");
        System.out.println(im2.get());
    }
}
