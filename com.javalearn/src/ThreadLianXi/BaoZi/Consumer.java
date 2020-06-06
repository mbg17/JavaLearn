package ThreadLianXi.BaoZi;

public class Consumer implements Runnable{
    BaoZI bz;
    public Consumer(BaoZI bz) {
        this.bz = bz;
    }

    public Consumer() {
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this.bz) {
                try{
                    if (bz.isFlag()) {
                        System.out.println("顾客：开始吃包子了");
                        Thread.sleep(2000);
                        bz.setFlag(false);
                        System.out.println("顾客：没包子了该做包子了");
                        bz.notify();
                    }else{
                        bz.wait();
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        }
    }
}
