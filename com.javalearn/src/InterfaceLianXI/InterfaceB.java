package InterfaceLianXI;

public interface InterfaceB {
    // 实现接口类中的抽象方法
    void method();

    // 父类优先级大于接口类，用父类的方法，无需重写
    void methodFu();

    void show();
}
