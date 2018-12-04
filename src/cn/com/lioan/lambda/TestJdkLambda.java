package cn.com.lioan.lambda;

import java.util.function.Consumer;
import java.util.function.Predicate;

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

    //断言型接口 参数T 返回值boolean
    public static boolean isAdult(int age, Predicate<Integer> predicate){
        return predicate.test(age);
        //调用默认方法
//        return predicate.negate().test(age);
//        Predicate<Integer> other = x -> x <= 28;
//        return predicate.and(x -> x <= 28).test(age);
//        return predicate.or(x -> x <= 28).test(age);
    }
    public static void main(String[] args){
        //消费性接口测试
        donation(2000, (money) -> System.out.println("捐赠了" + money + "元。"));

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