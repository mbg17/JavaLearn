package ExceptionLianxi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入用户名");
        try {
            register(sc.next());
        } catch (RegisterExcepiton registerExcepiton) {
            registerExcepiton.printStackTrace();
        }
    }
    public static void register(String s) throws RegisterExcepiton {
        ArrayList<String> users = new ArrayList<>();
        Collections.addAll(users,"luyuan","haha","xixi");
        for (String user : users) {
            if(user.equals(s)){
                throw new RegisterExcepiton("用户名已被注册");
            }
        }
        System.out.println("注册成功");
    }
}
