package Collections.Iterator;

public class Generic<E> {
    private  E name;

    public Generic(E name) {
        this.name = name;
    }

    public Generic() {
    }

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}
