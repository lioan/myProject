package cn.com.lioan.reflect;

public class TestClassReflect {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String line = "cn.com.lioan.reflect.Line";
        String point = "cn.com.lioan.reflect.Point";

        testForName(line, point);
        System.out.println("======================================");
        testClassLoader(line, point);
    }

    private static void testForName(String line, String point) {
        try {
            Class lc = Class.forName(line);
            Class pc = Class.forName(point);
            System.out.println("line : " + lc.getName());
            System.out.println("point : " + pc.getName());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private static void testClassLoader(String line, String point) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> lc;
        Class<?> pc;
        try {
            lc = classLoader.loadClass(line);
            pc = classLoader.loadClass(point);
            System.out.println("line : " + lc.getName());
            System.out.println("point : " + pc.getName());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

class Line {
    static {
        System.out.println("静态代码块执行：Line loading");
    }
}

class Point {
    static {
        System.out.println("静态代码块执行：Point loading");
    }
}
