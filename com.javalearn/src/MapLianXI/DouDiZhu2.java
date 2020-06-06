package MapLianXI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Handler;

public class DouDiZhu2 {
    public static void main(String[] args) {
        HashMap<Integer, String> puke = givePuke();
        ArrayList<Integer> xuHao = new ArrayList<>();
        // 创建牌序号
        for (int i = 0; i < 54; i++) {
            xuHao.add(i);
        }
        // 打乱牌序
        Collections.shuffle(xuHao);
        // 添加用户
        ArrayList<Integer> user1 = new ArrayList<>();
        ArrayList<Integer> user2 = new ArrayList<>();
        ArrayList<Integer> user3 = new ArrayList<>();
        ArrayList<Integer> user4 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> allUsers = new ArrayList<>();
        Collections.addAll(allUsers, user1, user2, user3, user4);
        // 给用户加牌
        for (int i = 0; i < xuHao.size(); i++) {
            if (i < 51) {
                allUsers.get(i % 3).add(xuHao.get(i));
            } else {
                allUsers.get(3).add(xuHao.get(i));
            }
        }
        // 给用户整理牌
        Collections.sort(user1);
        Collections.sort(user2);
        Collections.sort(user3);
        Collections.sort(user4);
        // 打印每个用户的牌
        lookPai(puke,allUsers);
    }
    // 组装拍的方法
    public static HashMap<Integer, String> givePuke(){
        List<String> colors = List.of("♣", "♥", "♤", "♢");
        List<String> numbers = List.of("2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        HashMap<Integer, String> puke = new HashMap<>();
        puke.put(0, "大王");
        puke.put(1, "小王");
        Integer num = 2;
        for (String number : numbers) {
            for (String s : colors) {
                puke.put(num, s + number);
                num++;
            }
        }
        return puke;
    }
    public  static void lookPai(HashMap<Integer, String> puke,ArrayList<ArrayList<Integer>> allUsers){
        Integer index = 1;
        for (ArrayList<Integer> allUser : allUsers) {
            System.out.print("用户"+index+"的牌：[");
            for (Integer integer : allUser) {
                System.out.print(puke.get(integer) + "  ");
            }
            System.out.println("]");
            index++;
        }
    }
}
