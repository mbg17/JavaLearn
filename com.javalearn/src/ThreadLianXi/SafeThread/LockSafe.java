package ThreadLianXi.SafeThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 使用锁对象保证线程的安全
// 加在会出现安全问题的代码块前后
public class LockSafe implements Runnable{
    private int tickets=100;
    private final Lock l = new ReentrantLock();
    @Override
    public void run() {
        while(true){
            l.lock();// 获取锁
            try {
                Thread.sleep(100);
                if(tickets>0){
                    System.out.println(Thread.currentThread().getName()+"正在出售第"+tickets+"票");
                }
                tickets--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                l.unlock();// 释放锁
            }

        }

    }
}
