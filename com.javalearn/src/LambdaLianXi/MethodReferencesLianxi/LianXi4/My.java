package LambdaLianXi.MethodReferencesLianxi.LianXi4;

public class My {
    public void buy(){
        System.out.println("我特么有钱，房子随便买");
    }

    public void marry(Richable r){
        r.rich();
    }

    public void happy(){
        marry(this::buy);
    }
}
