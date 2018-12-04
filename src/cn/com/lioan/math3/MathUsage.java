package cn.com.lioan.math3;

public class MathUsage {

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 3));
        System.out.println(Math.pow(3, 2));

        System.out.println(Math.log10(100));
        System.out.println(log(8, 2));
    }

    //基本数学运算：对数、指数、幂
    public static double log(double value, double base) {
        return Math.log(value) / Math.log(base);
    }
}
