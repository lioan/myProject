package cn.com.lioan.annotation;

import cn.com.lioan.testEnum.Color;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface AnnotationSimple {
    String value();

    String name() default "LIXX";

    Color color() default Color.RED;
}
