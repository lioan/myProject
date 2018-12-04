package cn.com.lioan.proxy.dynamicProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    //绑定委托对象，并返回代理类
    //简单
    public Object bindSimple(Object target) {
        this.target = target;
        //绑定委拖类实现的所有接口并返回代理实例
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);

        //return target;
    }

    //绑定委托对象，并返回代理类
    //复杂
    public Object bindComplex(Object target) {
        Object proxy = null;
        this.target = target;
        try {
            //绑定委拖类实现的所有接口并返回代理实例
            Class proxyClass = Proxy.getProxyClass(target.getClass().getClassLoader(), target.getClass().getInterfaces());
            Constructor proxyConstructor = proxyClass.getConstructor(new Class[]{InvocationHandler.class});
            proxy = proxyConstructor.newInstance(new Object[]{this});
        } catch (InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();

        }
        return proxy;

//		return target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("Proxy name :" + proxy.getClass().getName());
        System.out.println("Proxy simple name :" + proxy.getClass().getSimpleName());
        System.out.println("Mehtod name :" + method.getName());
        System.out.println("Method modify int :" + method.getModifiers());
        System.out.println("Mehtod modify :" + Modifier.toString(method.getModifiers()));
        System.out.println("args[0] name:" + args[0].getClass().getName());
        Object result = null;
        //这里可以进行相关处理 事务 AOP等等
        System.out.println("do before things.");
        //执行方法
        result = method.invoke(target, args);
        //这里可以进行后处理
        System.out.println("do after things.");
        //返回结果
        return result;
    }

}
