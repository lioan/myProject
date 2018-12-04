package cn.com.lioan.proxy.dynamicProxy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import sun.misc.ProxyGenerator;

public class TestDynamicProxy {

    public static void main(String[] args) {
        MyInvocationHandler handler = new MyInvocationHandler();
        //绑定委托类RealSubject实现的所有接口
        //测试简单创建代理接口
        //Subject subject = (Subject) handler.bindSimple(new RealSubject());
        //测试复杂代理接口
        Subject subject = (Subject) handler.bindComplex(new RealSubject());

//		subject.request();
        subject.request(15);

        System.out.println("Proxy name :" + subject.getClass().getName());
        System.out.println("Proxy simple name :" + subject.getClass().getSimpleName());

        //代理类写入本地
//		createProxyClassFile();
    }

    //将生成的代理类写到本地文件中
    private static void createProxyClassFile() {
        String name = "SubjectProxy";
        byte[] proxyClassData = ProxyGenerator.generateProxyClass(name, new Class[]{Subject.class});
        try {
            OutputStream write = new FileOutputStream(name + ".class");
            write.write(proxyClassData);
            write.flush();
            write.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
