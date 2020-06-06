package LambdaLianXi.MethodReferencesLianxi.LianXi6;
/*
 * 通过数组命名格式::new来引用
 * */
public class ArrayConstructorMethodReference {
    public static void main(String[] args) {
        int[] ints = arrayNew(6, int[]::new);
        System.out.println(ints.length);
    }

    public static int[] arrayNew(int len ,CreateArray c){
        return c.returnArray(len);
    }
}
