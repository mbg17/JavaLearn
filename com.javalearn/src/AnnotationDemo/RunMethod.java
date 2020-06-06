package AnnotationDemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@test2(className = "MapLianXI.Person",methodName = "eat")
public class RunMethod {
    public static void main(String[] args) throws Exception {
        // 获取字节码对象
        Class<RunMethod> runMethodClass = RunMethod.class;
        // 获取注解对象 参数为字节码对象用注解参数重写注解抽象方法
        test2 annotation = runMethodClass.getAnnotation(test2.class);
        // 通过注解对象获取指定参数
        String className = annotation.className();
        String methodName = annotation.methodName();
        // 通过全类名获取字节码对象
        Class aClass1 = Class.forName(className);
        // 生成新的无参对象
        Object o = aClass1.newInstance();
        // 获取指定方法
        Method method = aClass1.getMethod(methodName);
        // 执行方法
        method.invoke(o);
    }
}
