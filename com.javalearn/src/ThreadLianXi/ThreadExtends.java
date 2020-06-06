package ThreadLianXi;

public class ThreadExtends extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("继承的方式开启线程"+i);
        }
    }
}
