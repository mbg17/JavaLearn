package MemberInnerClassLianXI;

import org.w3c.dom.ls.LSOutput;

public class OuterClass {
    private String name ="陆远";

    public class InnerClass{
        String name ="牛逼";
        public void  innerMethod(){
            String name ="嘻嘻";
            System.out.println("访问成员内部类局部变量"+name);// 访问成员内部类局部变量
            System.out.println("访问成员内部类成员变量"+this.name);// 访问成员内部类成员变量
            System.out.println("访问外部类成员变量"+OuterClass.this.name);// 访问外部类成员变量
        }
    }

    public void outerMethod(){
        System.out.println("外部类成员方法运行");
        new InnerClass().innerMethod();// 通过外部类调用成员内部类的方法
        System.out.println("外部类成员方法结束");
    }

    public void niMingNeiBuLei(){
        // 不可变，否则局部内部类无法访问
        int num =0;
        // 在堆中声明周期比局部变量长
        class Innner{
            public void innerMethod(){
                System.out.println(num);
            }
        }
        Innner inner = new Innner();
        inner.innerMethod();
    }
}
