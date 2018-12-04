package cn.com.lioan.proxy.dynamicProxy;

public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("do some things.");
    }

    @Override
    public void request(int i) {
        System.out.println("do some things : args = " + i);
    }

}
