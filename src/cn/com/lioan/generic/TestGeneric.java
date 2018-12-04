package cn.com.lioan.generic;

import java.util.Collection;

/**
 * Created by dell on 2018/9/2.
 */
public class TestGeneric {
    public static void main(String[] args) {
        /*Cache<String> cs = new Cache<>();
        cs.setValue("HELLO");
        String s = cs.getValue();
        System.out.println(s);

        Cache<Integer> ci = new Cache<>();
        ci.setValue(123);
        Integer i = ci.getValue();
        System.out.println(i);*/

        Cache<String> cache = new Cache<>();
        cache.setValue("hello");

        System.out.println(cache.cgm(new Integer(123)));

        //泛型通配符？
//        new TestGeneric().opr2(new ArrayList<>());
    }

    //add编译不通过 ？只能操作Collection中没有泛型的方法 size、iterator等等,相当于只有读权限
    /*private void opr(Collection<?> collection){
        collection.add("hello");
        collection.add(Integer.valueOf(123));

        collection.size();
    }*/

    //add编译不通过 ？只能操作Collection中没有泛型的方法 size、iterator等等,相当于只有读权限
    /*private void opr1(Collection<? extends  Base> collection){
        collection.add(new Base());
        collection.add(new Sub());

        collection.iterator().next();
    }*/

    //但是泛型？之super却有add等带一定泛型方法操作的权限
    //
    private void opr2(Collection<? super Base> collection) {
        collection.add(new Base());
        collection.add(new Sub());

        System.out.println(collection.size());
        System.out.println(collection.iterator().next().toString());
    }

    //泛型方法
    private <T> T tm(T t) {
        System.out.println(t.getClass().getName());
        return t;
    }

}

//泛型类
class Cache<T> {
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    //类型方法中的泛型T 与 泛型类中的泛型T 相互独立无关联 即类型完全可以不同
    public <T> T cgm(T t) {
        System.out.println(t.getClass().getName());
        return t;
    }
}
