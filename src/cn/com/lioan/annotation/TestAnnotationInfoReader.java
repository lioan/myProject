package cn.com.lioan.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestAnnotationInfoReader {

    public static void main(String[] args) {
        try {
            //利用反射编程机制实现对注解这些元数据的访问
            //得到目标类的类对象
            Class c = Class.forName("cn.com.lioan.annotation.BasicAnnotation");
            //获取该类所有声明的方法
            Method[] methods = c.getDeclaredMethods();
            //获取改类所有声明的字段
            Field[] fields = c.getDeclaredFields();

            //声明注解集合
            Annotation[] ans;

            //遍历所有方法 得到方法上面注解信息
            for (Method method : methods) {
                //获取每个方法上面所声明的所有注解的信息
                ans = method.getDeclaredAnnotations();
                //遍历所有注解 打印其基本信息
                System.out.println("method :" + method.getName());
                for (Annotation an : ans) {
                    System.out.println("方法名为：" + method.getName() + ",其上面的注解为：" + an.annotationType().getSimpleName());
                    //遍历每个注解的所有变量
                    for (Method m : an.annotationType().getDeclaredMethods()) {
                        System.out.println("注解的变量名为：" + m.getName());

                    }
                    if (method.isAnnotationPresent(AnnotationSimple.class)) {
                        System.out.println("value:" + ((AnnotationSimple) an).value());
                        System.out.println("name:" + ((AnnotationSimple) an).name());
                        System.out.println("color:" + ((AnnotationSimple) an).color());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
