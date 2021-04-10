package com.test.database.translate.soluation;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyTest implements Proxy {
    private int i = 1;

    @Override
    public void add() {
        i += 1;
    }

    @Override
    public int sum() {
        return this.i;
    }

    public static void main(String[] args) {
        Proxy o = (Proxy) java.lang.reflect.Proxy.newProxyInstance(
                ProxyTest.class.getClassLoader(),
                ProxyTest.class.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        ProxyTest proxyTest = new ProxyTest();
                        System.out.println("开始动态代理");
                        return method.invoke(proxyTest, args);
                    }
                });
        o.add();
        System.out.println(o.sum());
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibTest.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                return methodProxy.invokeSuper(o, objects);
            }
        });
        CglibTest sample = (CglibTest) enhancer.create();
        sample.print();
    }
}

class CglibTest {
    public void print() {
        System.out.println("cglib");
    }
}

interface Proxy {
    void add();

    int sum();
}

class MyInvokeHandeler implements InvocationHandler {

    private Object object;

    public MyInvokeHandeler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始动态代理");
        return method.invoke(object, args);
    }
}
