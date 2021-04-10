package com.test.database.translate.soluation;

import com.test.database.translate.std.In;
import lombok.Data;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.List;

@Data
public class CloneTest implements Cloneable {
    private String name;
    private Integer id;
    private List<Integer> list;

    public CloneTest() {
    }

    public CloneTest(String name, Integer id, List<Integer> list) {
        this.name = name;
        this.id = id;
        this.list = list;
    }

    @SneakyThrows
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Class<? extends CloneTest> aClass = this.getClass();
        CloneTest cloneTest = new CloneTest();
        System.out.println(cloneTest.hashCode());
        System.out.println(this.hashCode());
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Object o = declaredField.get(this);
            declaredField.set(cloneTest, o);
        }
        return cloneTest;
    }

    @SneakyThrows
    public Object deepOrSimpleClone(boolean flag) {
        if (flag) {
            return this.clone();
        }
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTest haha = new CloneTest("haha", 100, List.of(1, 2, 3, 4, 5));
        CloneTest deep = (CloneTest) haha.deepOrSimpleClone(true);
        CloneTest simple = (CloneTest) haha.deepOrSimpleClone(false);
        System.out.println(deep == haha);
        System.out.println(simple == haha);
    }
}
