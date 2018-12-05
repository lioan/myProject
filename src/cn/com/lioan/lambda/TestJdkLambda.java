package cn.com.lioan.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * JAVA8 JDK设计者们为我们实现了基本的lambda函数
 * 主要分为四大类lambda函数式接口类型：
 *  Consumer,Supplier,Function,Predicate
 */
public class TestJdkLambda {

    //消费型接口 参数T 返回值void 实例：输出一个值
    public static void donation(Integer money, Consumer<Integer> consumer){
        consumer.accept(money);
    }

    //供给型接口 参数NONE 返回值T 实例：工厂方法
    public static List<Integer> supply(Integer num, Supplier<Integer> supplier) {
        List<Integer> resultList = new ArrayList<>();
        for (int x = 0; x < num; x++)
            resultList.add(supplier.get());
        return resultList;
    }
    //函数型接口 参数T 返回值R 实例：获得artist的名字
    public static Integer convert(String str, Function<String, Integer> function) {
        //调用静态方法
        System.out.println(Function.identity().apply(str) + ":" +Function.identity().apply(str).getClass());
        return function.apply(str);
    }

    //断言型接口 参数T 返回值boolean 实例：这些唱片已经发行了吗？
    public static boolean isAdult(int age, Predicate<Integer> predicate){
        return predicate.test(age);
        //调用默认方法
//        return predicate.negate().test(age);
//        Predicate<Integer> other = x -> x <= 28;
//        return predicate.and(x -> x <= 28).test(age);
//        return predicate.or(x -> x <= 28).test(age);
    }
    public static void main(String[] args){
        //消费型接口测试
//        System.out.println("--------consumer-------");
//        donation(2000, (money) -> System.out.println("捐赠了" + money + "元。"));

        //供给型接口测试
        System.out.println("--------supply-------");
        List<Integer> list = supply(10, () -> (int)(Math.random()*100));
        list.forEach(System.out::println);

        //函数型接口测试
//        System.out.println("-----------function-----------");
//        Integer value = convert("32", x -> Integer.parseInt(x));
//        System.out.println(value + ":" + value.getClass());

        //断言型接口测试
        //int age = 29;
        //一种调用方式
        /*System.out.println(isAdult(age, (x) ->
        {
            if (x >= 0) {
                return x >= 14;
            }else {
                return false;
            }
        }));*/
        //另一种方式
        /*Predicate<Integer> predicate = (x) ->
        {
            if (x >= 0) {
                return x >= 14;
            }else {
                return false;
            }
        };
        System.out.println(isAdult(age, predicate));*/

    }
}