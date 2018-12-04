package cn.com.lioan.math;

import java.util.Random;

public class TestRandom {

    private static int testRandom(int max) {
        return new Random().nextInt(max);
    }

    private static void testRandom1(int max) {
        Random r = new Random();
        for (int i = 1; i < 200; i++) {
            System.out.println(r.nextInt(max));
        }
    }

    private static void testRandom2(int max) {
        for (int i = 1; i < 200; i++) {
            System.out.println(new Random().nextInt(max));
        }
    }

    private static int getRandomInRange(int max) {
        int result = 0;
        Random r = new Random();
        result = r.nextInt(max);
        return result;
    }

    private static int getRandomInteger() {
        int result = 2500;
        Random r = new Random();
        int ri = r.nextInt(500);
        result = ((int) ((ri + 2500) / 100)) * 100;
        return result;
    }

    public static void main(String[] args) {
		/*System.out.println("==================test testRandom(max)=====================");
		for (int i = 0; i < 200; i++) {
			System.out.println(TestRandom.testRandom(3000));
		}*/
		/*System.out.println("==================test testRandom1(max)=====================");
		TestRandom.testRandom1(3000);
		System.out.println("==================test testRandom2(max)=====================");
		TestRandom.testRandom2(3000);*/
		/*System.out.println("==================test getRandomInRange(max,min)=====================");
		for (int i = 0; i < 200; i++) {
			System.out.println(TestRandom.testRandom(3000));
		}*/
		/*for (int k = 0; k < 200; k++) {
			int result = getRandomInRange(500);
			System.out.println("result ========== " + result);
			int i = ((result + 2500)/100)*100;
			System.out.println("i ============== " + i);
		}*/

        for (int k = 0; k < 2000; k++) {
            int result = getRandomInteger();
            System.out.println("result ========== " + result);
        }
    }

}
