package cn.com.lioan.string;

import java.lang.reflect.Field;

/**
 * 一般来说String对象是不可变的：对象在创建之后不能改变其状态和类型，即无法改变其内部成员的值 但是很难控制其引用类型变量指向的对象也不可变
 * 只能做到外部通过正常方式无法访问而已
 * 1、内部是private final char[]
 * 2、类本身也是final修饰
 * 3、JVM在内部为其维护了一个字符串常量池，常量池应该是在方法区 永久代
 * 4、+操作其实就是首先以最左边的字符串为参数创建StringBuilder对象，然后依次对右边进行append操作，最后将StringBuilder对象通过toString()方法转换成String对象
 * 5、String类重写了Object的equals方法和hashCode方法，使得比较字符串内容是否相等可以直接使用equals方法
 *
 * 但是可以通过反射改变一个String对象状态
 */
public class TestStrFinal {

    public static void main(String[] args) throws Exception {
        String s1 = "abc";
        String s2 = new String(s1);
        String s3 = "abc";
        System.out.println("s1 address:" + System.identityHashCode(s1));
        System.out.println("s2 address:" + System.identityHashCode(s2));
        System.out.println("s3 address:" + System.identityHashCode(s3));

        System.out.println("-----------string add------------------");
        strAdd();

        System.out.println("-----------string reflect------------------");
        strReflectChg();

    }

    public static void strAdd() {
        String s = "abc";
        s += "d"; //+操作其实就是首先以最左边的字符串为参数创建StringBuilder对象，然后依次对右边进行append操作，最后将StringBuilder对象通过toString()方法转换成String对象
        System.out.println(s);
        s = new StringBuilder("abc").append("d").toString();
        System.out.println(s);
    }

    public static void strReflectChg() throws Exception {
        String str = "Hello World";
        System.out.println("修改前的str:" + str);
        System.out.println("修改前str地址:" + System.identityHashCode(str));
        //利用反射修改str状态
        //获取String类中的value字段
        Field valueField = String.class.getDeclaredField("value");
        //改变value属性的访问权限
        valueField.setAccessible(true);
        //获取str对象上的value属性的值
        char[] value = (char[]) valueField.get(str);
        //改变value所引用的数组中的字符
        value[5] = '_';
        System.out.println("修改后的str:" + str);
        System.out.println("修改后str地址:" + System.identityHashCode(str));
    }
}
