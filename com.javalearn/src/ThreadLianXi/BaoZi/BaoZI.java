package ThreadLianXi.BaoZi;

import java.util.ArrayList;

public class BaoZI {
    ArrayList kind;
    private boolean flag = false;

    public BaoZI(ArrayList kind) {
        this.kind = kind;
    }

    public BaoZI() {
    }


    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
