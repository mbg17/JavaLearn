package HongBao;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User {
    public Member() {
    }

    public Member(String name, int money) {
        super(name, money);
    }

    public void recive(ArrayList<Integer> redList) {
        int index = new Random().nextInt(redList.size());
        int money = redList.remove(index);
        super.setMoney(money);
    }
}
