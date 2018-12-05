package cn.com.lioan.basic;

public class TestCodeOrder {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Child();
    }

}

class Parent {
    static {
        System.out.println("父类：静态代码块");
    }

    {
        System.out.println("父类：构造代码块");
    }

    private static String spv = spv();
    private String pv = pv();

    public Parent() {
        System.out.println("父类：构造方法");
    }

    private static String spv() {
        System.out.println("父类：静态方法，给静态成员变量赋值调用");
        return "";
    }

    private String pv() {
        System.out.println("父类：普通成员方法，给普通成员变量赋值调用");
        return "";
    }
}

class Child extends Parent {
    private String pv = pv();
    private static String spv = spv();

    static {
        System.out.println("子类：静态代码块");
    }

    public Child() {
        System.out.println("子类：构造方法");
    }

    {
        System.out.println("子类：构造代码块");
    }

    private static String spv() {
        System.out.println("子类：静态方法，给静态成员变量赋值调用");
        return "";
    }

    private String pv() {
        System.out.println("子类：普通成员方法，给普通成员变量赋值调用");
        return "";
    }
}
