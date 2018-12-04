package cn.com.lioan.proxy.staticProxy;

public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("do some thing.");
    }

}
