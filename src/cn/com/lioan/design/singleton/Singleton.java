package cn.com.lioan.design.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

public class Singleton extends Thread {

    public static void main(String[] args) {
        /*DoubleCheckSingleton singleton1 = DoubleCheckSingleton.getSingleton();
        DoubleCheckSingleton singleton2 = DoubleCheckSingleton.getSingleton();
        System.out.println(singleton1 == singleton2);

        LazyInitHolderSingleton singleton21 = LazyInitHolderSingleton.getSingleton();
        LazyInitHolderSingleton singleton22 = LazyInitHolderSingleton.getSingleton();
        System.out.println(singleton21 == singleton22);*/



        //对单例进行并发测试 是否线程安全
        Singleton[] ss = new Singleton[10];
        for (int i=0;i<ss.length;i++){
            ss[i] = new Singleton();
            ss[i].start();
        }
        /*for (int j=0;j<ss.length;j++){
            ss[j].start();
        }*/

        //测试通过反射破坏单例
//        singletonReflect();

        //测试静态内部类实现单例 序列化与反序列化
        /*LazyInitHolderSingleton singleton = LazyInitHolderSingleton.getSingleton();
        staticInternalSingletonSerial("LazyInitHolderSingleton.txt", singleton);
        LazyInitHolderSingletonSerial singletonSerial = LazyInitHolderSingletonSerial.getSingleton();
        staticInternalSingletonSerial("LazyInitHolderSingletonSerial.txt", singletonSerial);*/
    }

    public void run(){
        //对单例进行并发测试 是否线程安全
        //饿汉式
        //System.out.println(HungrySingleton.getSingleton().hashCode());
        //懒汉式
        //System.out.println(IdleSingleton.getSingleton().hashCode());
        //双检锁
        //System.out.println(DoubleCheckSingleton.getSingleton().hashCode());
        //枚举1
        //System.out.println(ClassSingletonFactory.EnumSingletonFactory.enumSingletonFactory.hashCode());
        //System.out.println(EnumSingletonFactory.enumSingletonFactory.getSingleton().hashCode());
        //枚举2
        //System.out.println(ClassSingletonFactory.getSingleton().hashCode());
        //TheadLocal 这样用多线程跑就会保证每个线程都是不同的实例
        //System.out.println(ThreadLocalSingleton.getInstance().hashCode());
        //CAS
        System.out.println(CasSingleton.getInstance().hashCode());

    }

    //从结果看创建了两个单例对象：将构造方式的private的检查通过constructor.setAccessible(true);进行了屏蔽
    //解决：将构造方法设置一个标志，标明调用超过一次就抛出异常
    public static void singletonReflect(){
        try {
            HungrySingleton s1 = HungrySingleton.getSingleton();
            Constructor<HungrySingleton> constructor = HungrySingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            HungrySingleton s2 = constructor.newInstance();
            System.out.println(s1.hashCode());
            System.out.println(s2.hashCode());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void staticInternalSingletonSerial(String fileName, Object obj){
        File file = new File(fileName);
        try {
            //序列化
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            fos.close();
            oos.close();
            System.out.println("serial obj hashcode:" + obj.hashCode());

            //反序列化
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object iobj = ois.readObject();
            System.out.println("deserial obj hashcode:" + iobj.hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

//饿汉式(final?)
class HungrySingleton {
    private static int count = 0;
    private static HungrySingleton singleton = new HungrySingleton();
    //    private static int count = 0;
    private HungrySingleton(){
        System.out.println("count=="+count);
        if (count > 0) {
            throw new RuntimeException("实例已经存在!");
        }
        count++;

        /*synchronized (HungrySingleton.class){
            if (count > 0) {
                throw new RuntimeException("create more then one!");
            }
            count++;
        }*/

    }
    public static HungrySingleton getSingleton(){
        return singleton;
    }
}

//懒汉式(synchronized 保证线程安全 效率低)
class IdleSingleton {
    private static IdleSingleton singleton;
    private IdleSingleton(){}
    public static IdleSingleton getSingleton() {
        try {
            if (singleton == null) {
                Thread.sleep(100);
                singleton = new IdleSingleton();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return singleton;
    }
}

//双检锁式 volatile可以保证线程安全 不被重复实例化(可以通过内存屏障保证指令不重排，即在写完成之前禁止读操作)
class DoubleCheckSingleton {
    private DoubleCheckSingleton(){}
    //如果不使用jdk1.5之后的volatile可能会出现线程B获取了线程A还未完全初始化的单例对象
    //volatile可以避免编译器调整代码执行顺序，保证读取变量的值是从主内存中读取，而不是使用线程本地缓存
    private volatile static DoubleCheckSingleton singleton;
    public static DoubleCheckSingleton getSingleton(){
        try {
            if (singleton == null){
                synchronized (DoubleCheckSingleton.class){
                    if (singleton == null){
                        Thread.sleep(100);
                        singleton = new DoubleCheckSingleton();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return singleton;
    }
}

//Lazy Initialization holder class 满足所有的双检锁条件，并且没有显示的同步操作
//由JVM的类初始化操作保证安全性
class LazyInitHolderSingleton implements Serializable {
    private LazyInitHolderSingleton(){}
    private static class SingletonHolder{
        private final static LazyInitHolderSingleton SINGLETON = new LazyInitHolderSingleton();
    }
    public static LazyInitHolderSingleton getSingleton(){
        return SingletonHolder.SINGLETON;
    }
}

//Lazy Initialization holder class 满足所有的双检锁条件，并且没有显示的同步操作
//由JVM的类初始化操作保证安全性
//如果静态内部类是可序列化的 那么默认的实现方式在反序列化的时候会重新实例化单例 导致不一致：解决方法就是使用readResolve()方法
class LazyInitHolderSingletonSerial implements Serializable {
    private static final long serialVersionUID = 1L;
    private LazyInitHolderSingletonSerial(){}
    private static class SerialSingletonHolder{
        private final static LazyInitHolderSingletonSerial SINGLETON = new LazyInitHolderSingletonSerial();
    }
    public static LazyInitHolderSingletonSerial getSingleton(){
        return SerialSingletonHolder.SINGLETON;
    }

    //该方法在反序列化时会被调用，不是接口中的方法，有点约定俗成的意思
    protected Object readResolve() {
        System.out.println("调用了readResolve方法！");
        return SerialSingletonHolder.SINGLETON;
    }
}

//使用枚举实现单例(推荐方式，线程安全效率高)和使用俄汉式或者静态代码块类似，在使用枚举时，构造方法会被自动调用，利用这一特性实现单例
//但是这样写枚举类被完全暴露了，违反了"职责单一原则"
enum EnumSingletonFactory {
    enumSingletonFactory;
    private MySingleton singleton;
    EnumSingletonFactory(){//枚举类的构造方法在类加载时被实例化
        singleton = new MySingleton();
    }
    public MySingleton getSingleton(){
        return singleton;
    }
}
//使用一个封装类包装enum，使之对外隐藏
class ClassSingletonFactory {
    enum EnumSingletonFactory {
        enumSingletonFactory;
        private MySingleton singleton;
        EnumSingletonFactory(){//枚举类的构造方法在类加载时被实例化
            singleton = new MySingleton();
        }
        private MySingleton getSingleton(){
            return singleton;
        }
    }

    public static MySingleton getSingleton() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return EnumSingletonFactory.enumSingletonFactory.getSingleton();
    }
}
class MySingleton {//需要实现单例的类，比如数据库连接池等资源管理类
    public MySingleton(){}
}

//使用TrheadLocal实现单例模式 线程不安全，每个线程都是独立不同的实例
class ThreadLocalSingleton{
    private static final ThreadLocal<ThreadLocalSingleton> TLSINGLETON =
//            ThreadLocal.withInitial()
            new ThreadLocal<ThreadLocalSingleton>(){
            protected ThreadLocalSingleton initialValue(){
                return new ThreadLocalSingleton();
            }
    };
    private ThreadLocalSingleton(){}
    public static ThreadLocalSingleton getInstance(){
        return TLSINGLETON.get();
    }
}

//使用CAS锁实现单例 线程安全
class CasSingleton{
    //利用AtomicReference
    private static final AtomicReference<CasSingleton> INSTANCE = new AtomicReference<>();
    private CasSingleton(){}
    //使用CAS保证线程安全
    public static final CasSingleton getInstance(){
        for (;;){
            CasSingleton current = INSTANCE.get();
            if (current != null){
                return current;
            }
            current = new CasSingleton();
            if (INSTANCE.compareAndSet(null, current)){
                return current;
            }
        }
    }
}