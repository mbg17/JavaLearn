package Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static LambdaLianXi.MethodReferencesLianxi.LianXi6.ArrayConstructorMethodReference.arrayNew;

public class TestArrayNew {
    int len;

    @Before// 准备阶段
    public void init() {
        System.out.println("init...");
        len = 6;
    }

    @After// 结束阶段不管是否报错都会执行
    public void close() {
        System.out.println("close...");
    }

    @Test
    public void testNew() {
        int[] ints = arrayNew(len, int[]::new);
        System.out.println(ints.length);
    }

    @Test
    public void reseverString() {
        // 把空格剔除 组成一个单列集合
        String s = new String("this is    a      book , is very      good    !        ");
        ArrayList<StringBuffer> lis = new ArrayList<>();
        ArrayList<StringBuffer> kongges = new ArrayList<>();
  /*      ArrayList<Integer> kongges = new ArrayList<>();
        int kongge = 0;*/
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        StringBuffer kongge = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (String.valueOf(chars[i]).equals(" ")) {
                kongge.append(" ");
            } else {
                if (kongge.length()>0) {
                    kongges.add(new StringBuffer(kongge.toString()));
                    kongge.delete(0,kongge.length());
                }
            }
            if (!String.valueOf(chars[i]).equals(" ")) {
                sb.append(chars[i]);
                if (i == chars.length - 1) {
                    lis.add(sb);
                }
            } else {
                if (!sb.toString().equals("")) {
                    StringBuffer sb2 = new StringBuffer(sb.toString());
                    lis.add(sb2);
                    sb.delete(0, sb.length());
                }
            }
        }
        StringBuilder sd = new StringBuilder();
        for (int i = lis.size() - 1; i >= 0; i--) {
            if(i>kongges.size()-1){
                sd.append(lis.get(i));
            }else{
                sd.append(kongges.get(i).toString()+lis.get(i).toString());
            }
        }
        System.out.println(sd);
    }
}
