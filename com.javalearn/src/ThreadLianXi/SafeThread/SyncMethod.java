package ThreadLianXi.SafeThread;
// 使用同步方法保证线程的安全
public class SyncMethod implements Runnable{

    private int tickets=100;
    private Object obj =new Object();
    @Override
    public void run() {
        while(true){
            syncMth();
        }
    }
    // 锁对象为当前的class属性
    public synchronized void syncMth(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(tickets>0){
            System.out.println(Thread.currentThread().getName()+"正在出售第"+tickets+"票");
        }
        tickets--;
    }

    // 静态同步代码块
/*
    public static synchronized void syncMth(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(tickets>0){
            System.out.println(Thread.currentThread().getName()+"正在出售第"+tickets+"票");
        }
        tickets--;
    }
*/
}
