package AnnotationDemo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCase {
    public static void main(String[] args) throws Exception {
        Calculator c = new Calculator();
        // 获取字节码对象
        Class aClass = c.getClass();
        // 定义统计bug的变量
        int bugNum =0;
        // 定义输出bug信息的IO流
        BufferedWriter bw = new BufferedWriter( new FileWriter("D:\\JAVA\\com.javalearn\\src\\AnnotationDemo\\bug.txt"));
        // 通过字节码对象获取所有方法的数组
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            // 判断方法是否添加了注解
            if(method.isAnnotationPresent(Check.class)){
                try{
                    // 执行函数
                    method.invoke(c);
                }catch(Exception e){
                    // 写入异常
                    bugNum++;
                    bw.write("异常的方法名："+method.getName());
                    bw.newLine();
                    // 所有这些方法都调用getCause方法来确定可抛出的原因。 getSimpleName()返回源代码中给出的基础类的简单名称。
                    bw.write("异常的错误类型："+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    // 获取错误信息
                    bw.write("异常的原因："+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("------------------------");
                    bw.newLine();
                }
            }
        }
        bw.write("本次发现"+bugNum+"个异常");
        bw.close();
    }
}
