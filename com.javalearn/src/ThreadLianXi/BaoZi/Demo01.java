package ThreadLianXi.BaoZi;
import java.util.ArrayList;
import java.util.Collections;

public class Demo01 {
    public static void main(String[] args) {
        ArrayList<String> kind = new ArrayList<>();
        Collections.addAll(kind,"白菜馅","猪肉馅");
        BaoZI b = new BaoZI(kind);
        Consumer c =new Consumer(b);
        Producer p = new Producer(b,kind);
        new Thread(c).start();
        new Thread(p).start();
    }
}
