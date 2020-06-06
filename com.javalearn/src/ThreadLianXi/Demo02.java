package ThreadLianXi;

public class Demo02 {
    public static void main(String[] args) {
        SellTickets st = new SellTickets();
        new Thread(st).start();
        new Thread(st).start();
        new Thread(st).start();
    }
}
