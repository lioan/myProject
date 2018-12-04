package cn.com.lioan.proxy.staticProxy;

public class SubjectProxy implements Subject {

    private Subject realSub;

    public SubjectProxy(Subject subject) {
        this.realSub = subject;
    }

    @Override
    public void request() {
        //委托方法执行之前
        pre();
        //执行委托
        realSub.request();
        //委托方法行之后
        post();
    }

    public void pre() {
        System.out.println("pre do thing.");
    }

    public void post() {
        System.out.println("post do thing.");
    }
}
