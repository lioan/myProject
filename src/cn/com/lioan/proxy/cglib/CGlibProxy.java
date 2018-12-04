package cn.com.lioan.proxy.cglib;

/*import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;*/

/**
 * Created by lioanli on 2017/1/6.
 */
public class CGlibProxy {
    Object obj;

    public Object bind(final Object target) {
       /* this.obj = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("开始代理");
                Object res = method.invoke(target,objects);
                return res;
            }
        });
        return enhancer.create();*/
        return null;
    }

}
