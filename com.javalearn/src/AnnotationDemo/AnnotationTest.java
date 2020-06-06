package AnnotationDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)// 注解的区域
@Retention(RetentionPolicy.RUNTIME)// 保留阶段
public @interface AnnotationTest {
    // 属性（抽象方法）
    int age();
    EnumTest p();
    String name();
    int[] array() default {1,2,3};// 可以不用赋值
    test2 t();
}
