package InterfaceLianXI;

public interface InterfaceA {
    // 常量一旦定义无法改变,变量名一定要全部大写
    public static final int NUM =10;

    // 抽象方法生省略了public abstract
    void method();

    default void methodDefault(){
        System.out.println("默认方法可被继承复写，用于接口的升级");
        privateDefault();
    }

    static void methodStatic(){
        System.out.println("静态方法只能被类调用");
        privateStatic();
    }

    private static void privateStatic(){
        System.out.println("静态私有方法，只能在接口类中的静态方法中调用");
    }

    private void privateDefault(){
        System.out.println("普通私有方法，只能在接口类中的默认方法中调用");
    }
}
