package ThreadLianXi;

public class Demo01 {
    public static void main(String[] args) {
        // 创建实现类对象
        ThreadImpl tl = new ThreadImpl();
        // 实现类对象传入线程对象开启线程
        Thread t =new Thread(tl);
        t.start();

        // 创建Thread子类对象开启线程
        ThreadExtends te = new ThreadExtends();
        te.start();

        // 匿名对象开启线程
        new Thread(){

            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("匿名对象开启线程"+i);
                }
            }
        }.start();

        // 匿名内部类开启线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("匿名内部类开启线程"+i);
                }
            }
        }).start();
    }
}
