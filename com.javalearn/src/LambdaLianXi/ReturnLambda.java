package LambdaLianXi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ReturnLambda {
    public static void main(String[] args) {
        ArrayList<String> aa = new ArrayList<>();
        aa.add("1");
        aa.add("466");
        aa.add("38");
        aa.add("2000");
        Collections.sort(aa,getCompartor());
        for (String s : aa) {
            System.out.println(s);
        }
    }
    public static Comparator<String> getCompartor(){
        return (o1,o2)->o1.length()-o2.length();
    }
}
