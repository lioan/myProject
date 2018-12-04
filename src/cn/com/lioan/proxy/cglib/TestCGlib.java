package cn.com.lioan.proxy.cglib;

/**
 * Created by lioanli on 2017/1/6.
 */
public class TestCGlib {

    public static void main(String[] args) {
        RealObj subject = new RealObj();
        CGlibProxy cGlibProxy = new CGlibProxy();
        RealObj subProxy = (RealObj) cGlibProxy.bind(subject);
        System.out.println(subProxy.sayhi());
    }
}
