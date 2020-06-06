package AnnotationDemo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface test2 {
    String className() default "";
    String methodName() default "";
}
