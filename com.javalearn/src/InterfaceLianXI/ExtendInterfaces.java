package InterfaceLianXI;

// 接口可以多继承
public class ExtendInterfaces extends Fu implements InterfaceA,InterfaceB {

    @Override
    public void show() {
        System.out.println("子类实现接口B的show方法");
    }

    @Override
    public void method() {
        // 接口拥有相同的抽象类，有歧义必须要复写
        // 重复抽象方法不需要都重写
        System.out.println("实现类重写接口类中存在歧义的抽象方法");
    }
}
