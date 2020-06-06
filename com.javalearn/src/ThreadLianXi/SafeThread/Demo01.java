package ThreadLianXi.SafeThread;

public class Demo01 {
    public static void main(String[] args) {
        LockSafe ls = new LockSafe();
        SyncArea sa = new SyncArea();
        SyncMethod sm = new SyncMethod();

//        new Thread(ls).start();
//        new Thread(ls).start();
//        new Thread(ls).start();
//
//        new Thread(sa).start();
//        new Thread(sa).start();
//        new Thread(sa).start();

        new Thread(sm).start();
        new Thread(sm).start();
        new Thread(sm).start();
    }
}
