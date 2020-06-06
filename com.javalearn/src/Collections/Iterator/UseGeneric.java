package Collections.Iterator;

public class UseGeneric {
    public static void main(String[] args) {
        Generic<String> g = new Generic<>();
        g.setName("hehe");
        String name = g.getName();
        System.out.println(name);
    }
}
