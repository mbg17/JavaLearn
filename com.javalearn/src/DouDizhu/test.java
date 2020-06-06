package DouDizhu;

import java.util.ArrayList;
import java.util.Collections;

public class test {
    public static void main(String[] args) {
        // 发牌
        ArrayList<String> puke = deal();
//        System.out.println(puke);
        // 洗牌
        Collections.shuffle(puke);
        System.out.println(puke.size());
        // 发牌
        ArrayList<String> user1 = new ArrayList<>();
        ArrayList<String> user2 = new ArrayList<>();
        ArrayList<String> user3 = new ArrayList<>();
        ArrayList<String> user4 = new ArrayList<>();
        ArrayList<ArrayList<String>> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        flyPai(users,puke);
        get(user1);
        get(user2);
        get(user3);
        get(user4);
    }

    public static ArrayList<String> deal(){
        ArrayList<String> puke = new ArrayList<>();
        String[] color = {"♥","♢","♣","♤"};
        String[] num = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        for (int i = 0; i < color.length; i++) {
            for (int i1 = 0; i1 < num.length; i1++) {
                puke.add(color[i]+num[i1]);
            }
        }
        puke.add("大王");
        puke.add("小王");
        return puke;
    }

    public static void flyPai(ArrayList<ArrayList<String>> users,ArrayList<String> puke){
        for (int i = 0; i < puke.size(); i++) {
            // 索引从0开始 拍的长度为54 所以第51张牌为54-4 / 0-50
            if (i<=puke.size()-4){
                users.get(i%3).add(puke.get(i));
            }else{
                users.get(users.size()-1).add(puke.get(i));
            }
        }
    }
    // 使用泛型占位符打印排
    public static void get(ArrayList<?> puke){
        for (int i = 0; i < puke.size(); i++) {
            System.out.print(puke.get(i)+" ");
        }
        System.out.println();
    }
}
