package LambdaLianXi;

import java.util.function.Function;

public class FunctionLianXi {
    public static void main(String[] args) {
        String s = "哈哈,20";
        int i = addString(s,str->Integer.parseInt(str.split(",")[1]));
        System.out.println(i);
    }

    public static int addString(String str, Function<String,Integer> fun){
        return fun.apply(str)+100;
    }
}
