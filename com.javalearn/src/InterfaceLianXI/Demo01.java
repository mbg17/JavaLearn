package InterfaceLianXI;

public class Demo01 {

    public static void main(String[] args) {
        ExtendInterfaces e = new ExtendInterfaces();
        Fu t = new Test();// 多态
        e.show();
        e.methodDefault();
        // e.methodStatic(); 错误写法，静态抽象方法必须要接口类调用
        InterfaceA.methodStatic();// 正确写法
        e.methodFu();// 优先调用父类的方法
        // 接口私有方法不能被实现类对象调用
//        e.privateStatic();
//        e.privateDefault();
        System.out.println(e.NUM);// 调用抽象类中的常量
        System.out.println(e instanceof ExtendInterfaces);// 判断是否是当前类，同一个类所以是true
        System.out.println(t instanceof ExtendInterfaces);// 判断是否是当前类，同一父类但不是相同子类为False
        System.out.println(e instanceof Fu);// 判断是否是当前类，是子类也能当做父类看待所以是true
        InterfaceA A =new InterfaceA() {
            @Override
            public void method() {
                System.out.println("匿名内部类调用方法");
            }
        };
        A.method();
        new InterfaceA(){
            @Override
            public void method() {
                System.out.println("匿名对象+匿名内部类调用方法");
            }
        }.method();
    }
}
