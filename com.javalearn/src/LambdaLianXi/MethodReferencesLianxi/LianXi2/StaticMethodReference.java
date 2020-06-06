package LambdaLianXi.MethodReferencesLianxi.LianXi2;

/*
* 通过类名::静态方法来引用
* */
public class StaticMethodReference {
    public static void main(String[] args) {
        int i = returnAbs(-100, Math::abs);
        System.out.println(i);
    }

    public static int returnAbs(int i ,UseInt u){
        return u.use(i);
    }
}
