package MemberInnerClassLianXI;

public class Demo01 {
    public static void main(String[] args) {
        OuterClass out = new OuterClass();
        out.outerMethod();// 外部类调用成员内部类成员方法
//        实例化成员内部类调用内部成员方法
        // 实例化方法：外部类.内部类 变量名 = new 外部类().new 内部类();
        OuterClass.InnerClass inner = new OuterClass().new InnerClass();
        inner.innerMethod();
        // 用成员方法访问局部内部类
        out.niMingNeiBuLei();
    }
}
