package ThreadPoolLianXi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args) {
        // 创建线程池 用接口类接受实现类对象（面向接口编程）
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        // 匿名内部类创建Runable 对象
        executorService.submit(new RunableImpl());
        executorService.submit(new RunableImpl());
        executorService.submit(new RunableImpl());
        executorService.submit(new RunableImpl());
        executorService.submit(new RunableImpl());

        executorService.shutdown();// 销毁线程，不建议使用
    }
}
class RunableImpl implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"启动了一个线程");
    }
}