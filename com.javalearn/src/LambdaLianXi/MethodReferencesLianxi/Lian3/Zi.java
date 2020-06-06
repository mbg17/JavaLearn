package LambdaLianXi.MethodReferencesLianxi.Lian3;

public class Zi extends Fu{
    public static void sayHallo(Greet g){
        g.greet();
    }

    @Override
    public void greet() {
        sayHallo(super::greet);
    }
}
