package HongBao;

import java.util.ArrayList;
import java.util.Random;

public class Manager extends User {
    public Manager() {
    }

    public Manager(String name, int money) {
        super(name, money);
    }

    public ArrayList<Integer> send(int totalMoney,int count){
        int leftMoney = super.getMoney();
        ArrayList<Integer> redList = new ArrayList<>();
        if(leftMoney<totalMoney){
            System.out.println("余额不足");
            return redList;
        }
        super.setMoney(leftMoney-totalMoney);
        int avg = totalMoney/3;
        int decemal = totalMoney%3;
        for (int i = 0; i < count; i++) {
            if(i == count-1){
                redList.add(avg+decemal);
            }else{
                redList.add(avg);
            }
        }
        return redList;
    }

    public ArrayList<Integer> sendRandom(int totalMoney,int count){
        int leftMoney = super.getMoney();
        ArrayList<Integer> redList = new ArrayList<>();
        if(leftMoney<totalMoney){
            System.out.println("余额不足");
            return redList;
        }
        super.setMoney(leftMoney-totalMoney);
        for (int i = 0; i < count; i++) {
            if(i == count-1){
                redList.add(totalMoney);
            }else{
                int money = new Random().nextInt(totalMoney);
                totalMoney-=money;
                redList.add(money);
            }
        }
        return redList;
    }
}
