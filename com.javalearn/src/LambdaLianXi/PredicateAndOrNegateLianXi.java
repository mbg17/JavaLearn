package LambdaLianXi;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateAndOrNegateLianXi {
    public static void main(String[] args) {
        // 返回满足两个条件的布尔值
        String s ="123456";
        boolean b = predicateAnd(s, s1 -> s1.length() > 5, s2 -> s2.contains("1"));
        System.out.println(b);
        boolean b1 = predicateOr(s, s1 -> s1.length() > 7, s2 -> s2.contains("1"));
        System.out.println(b1);
        boolean b2 = predicateNegrate(s, s1 -> s1.length() > 7);
        System.out.println(b2);

        String[] names = {"陆远,男","张是的三,女","张第三方的三,女"};
        // 文字要用equals比较
        ArrayList<String> arr = checkNameSex(names, name -> name.split(",")[0].length() == 4, sex -> sex.split(",")[1].equals("女"));
        for (String s1 : arr) {
            System.out.println(s1);
        }
    }

    // 与
    public static boolean predicateAnd(String s, Predicate<String> pre1,Predicate<String> pre2){
        return pre1.and(pre2).test(s);
    }

    // 或
    public static boolean predicateOr(String s, Predicate<String> pre1,Predicate<String> pre2){
        return pre1.or(pre2).test(s);
    }

    // 取反
    public static boolean predicateNegrate(String s, Predicate<String> pre1){
        return pre1.negate().test(s);
    }

    public static ArrayList<String> checkNameSex(String[] s, Predicate<String> pre1, Predicate<String> pre2){
        ArrayList<String> arr = new ArrayList<>();
        for (String s1 : s) {
            if( pre1.and(pre2).test(s1)){
                arr.add(s1);
            };
        }
        return arr;
    }
}
