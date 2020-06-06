package LambdaLianXi.MethodReferencesLianxi.LianXi1;

public class Demo01 {
    /*
    * 通过对象::方法来引用
    * */
    public static void main(String[] args) {
        TestObj testObj = new TestObj();
        String s = upper("xxxxx", testObj::change);
        System.out.println(s);
    }

    public static String upper(String s,UseString u){
        return u.use(s);
    }
}
