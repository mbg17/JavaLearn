package ThreadLianXi.SafeThread;
// 使用同步代码块保证线程的安全
// 对象只能使用同一个才行
public class SyncArea implements Runnable{
    private int tickets=100;
    private Object obj =new Object();
    @Override
    public void run() {
        while(true){
            synchronized (obj){
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
        }

    }
}
