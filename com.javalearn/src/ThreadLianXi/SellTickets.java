package ThreadLianXi;

public class SellTickets implements Runnable{
    private int tickets=100;
    @Override
    public void run() {
        while(true){
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
