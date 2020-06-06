package Genericity;

public class Impl1InterfaceGenericity implements InterfaceGenericity<String> {
    private String name;

    @Override
    public void set(String s) {
        this.name = s;
    }

    @Override
    public String get() {
        return name;
    }
}
