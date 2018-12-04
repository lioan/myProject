package cn.com.lioan.math;

public class TestMath {


    /**
     * @param args
     */
    public static void main(String[] args) {
		/*double resule = logarithm(10000, 1.18);
		System.out.println(resule);*/
//		double resule = power(2, 16);
//		System.out.println(resule);
        System.out.println(basicTransfer(500, 477));
    }

    //求对数
    public static double logarithm(double value, double base) {
        return Math.log(value) / Math.log(base);
    }

    //求幂级
    public static double power(double basic, double exponent) {
        return Math.pow(basic, exponent);
    }

    //测试基本转型
    public static int basicTransfer(int fenmu, int fenzi) {
        return (int) (fenzi * 100) / fenmu;
    }
}
