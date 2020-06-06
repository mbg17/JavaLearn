package DuoTai;

public class Demo1 {
    public static void main(String[] args) {
        Fu fu =new Zi();// 向上转型
        fu.methodFu();
//        fu.methodZi();
        Zi zi =(Zi) fu; // 向下转型，可以调用子类独有的方法
        zi.methodZi();
    }
}
