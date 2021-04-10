package com.test.database;

import com.test.database.translate.Singleton;
import lombok.SneakyThrows;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.Arrays;

public class Aes<T> {
    @SneakyThrows
    public T getObject(Class tClass) {
        Object o = tClass.getDeclaredConstructor().newInstance();
        return ((T) o.toString());
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Singleton> singletonClass = Singleton.class;
        Method getInstanse = getMethod(singletonClass, "getInstanse");
        Singleton invoke = (Singleton) getInstanse.invoke(new Singleton());
        System.out.println(invoke);
        Aes<String> stringAes = new Aes<>();
        String object = stringAes.getObject(Socket.class);
        System.out.println(object);
    }

    public static Method getMethod(Class clazz, String methodName, Class... types) throws NoSuchMethodException {
        Method[] methods = clazz.getMethods();
        long count = Arrays.stream(methods).filter(method -> method.getName().equals(methodName)).count();
        if (count == 1) {
            return clazz.getMethod(methodName, clazz.getMethod(methodName).getParameterTypes());
        } else {
            return clazz.getMethod(methodName, types);
        }
    }
}
