package cn.com.lioan.reflect;

import java.lang.annotation.*;

/**
 * Created by lioanli on 2017/1/4.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface StuAnno {
    String value() default "";
}
