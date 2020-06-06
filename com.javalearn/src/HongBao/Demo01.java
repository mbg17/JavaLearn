package HongBao;

import java.util.ArrayList;

public class Demo01 {
    public static void main(String[] args) {
        Manager m = new Manager("陆远",200);
        Member a = new Member("游客1",0);
        Member b = new Member("游客3",0);
        Member c = new Member("游客2",0);
        ArrayList<Integer> redList=m.sendRandom(100,3);
        a.recive(redList);
        b.recive(redList);
        c.recive(redList);
        m.show();
        a.show();
        b.show();
        c.show();
    }
}
