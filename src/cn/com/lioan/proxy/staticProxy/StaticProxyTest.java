package cn.com.lioan.proxy.staticProxy;

public class StaticProxyTest {

    public static void main(String[] args) {
        System.out.println("=====开始测试静态代理============");
        SubjectProxy sp = new SubjectProxy(new RealSubject());
        sp.request();
    }

}
