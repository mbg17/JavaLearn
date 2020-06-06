package Genericity;

public class Impl2InterfaceGenericity<E> implements InterfaceGenericity<E> {
    private E name;

    @Override
    public void set(E s) {
        this.name = s;
    }

    @Override
    public E get() {
        return name;
    }
}
