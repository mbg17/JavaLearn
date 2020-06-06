package ThreadLianXi;
// 使用实现类方式创建多线程对象
public class ThreadImpl implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("实现接口的方式开启线程"+" "+i);
        }
    }
}
