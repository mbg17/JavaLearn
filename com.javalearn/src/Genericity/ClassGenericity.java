package Genericity;
// 泛型类
public class ClassGenericity<E> {
    private E name;

    public ClassGenericity(E name) {
        this.name = name;
    }

    public ClassGenericity() {
    }

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}
