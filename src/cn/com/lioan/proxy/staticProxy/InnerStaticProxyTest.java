package cn.com.lioan.proxy.staticProxy;

public class InnerStaticProxyTest {

    interface Subject {
        void doThing();
    }

    class RealSubject implements Subject {

        @Override
        public void doThing() {
            System.out.println("do some thing.");
        }

    }

    class SubjectProxy implements Subject {
        Subject sub = new RealSubject();

        @Override
        public void doThing() {
            sub.doThing();
        }

        public void doOtherThing() {
            System.out.println("do other thing.");
        }

    }

    private void test() {
        Subject sub = new RealSubject();
        sub.doThing();
    }

    public static void main(String[] args) {
        System.out.println("heheh");
        InnerStaticProxyTest test = new InnerStaticProxyTest();
        test.test();
        Subject subject = test.new RealSubject();
        subject.doThing();
        SubjectProxy subProxy = test.new SubjectProxy();
        subProxy.doThing();
        subProxy.doOtherThing();
    }

}
