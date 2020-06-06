package ThreadLianXi.BaoZi;

import java.util.ArrayList;

public class Producer implements Runnable{
    BaoZI bz;
    ArrayList<String> kind;
    int index =0;
    public Producer() {
    }

    public Producer(BaoZI bz, ArrayList<String> kind) {
        this.bz = bz;
        this.kind=kind;
    }

    @Override
    public void run() {
        synchronized (this.bz){
            while(true){
                synchronized (this.bz) {
                    try{
                        if (!bz.isFlag()) {
                            System.out.println("老板：开始做包子了");
                            Thread.sleep(2000);
                            bz.setFlag(true);
                            System.out.println("老板：这种"+bz.kind.get(index%2)+"包子做完了，该吃了");
                            index++;
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
}
