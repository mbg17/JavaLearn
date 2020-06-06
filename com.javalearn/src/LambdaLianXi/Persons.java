package LambdaLianXi;

public class Persons {
    private String name;

    public Persons(String name) {
        this.name = name;
    }

    public Persons() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "name='" + name + '\'' +
                '}';
    }
}
