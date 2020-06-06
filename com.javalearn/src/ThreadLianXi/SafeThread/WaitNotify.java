package ThreadLianXi.SafeThread;

public class WaitNotify {
    public static void main(String[] args) {
        Object obj = new Object();
        new Thread(){
            @Override
            public void run() {
                synchronized (obj){
                    System.out.println("我要卖包子了，多做点！！！");
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("嗯，真香");
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                synchronized (obj){
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("来啦，我马上做!");
                    System.out.println("做好了，您快吃吧！！");
                    obj.notify();
                }
            }
        }.start();
    }
}
