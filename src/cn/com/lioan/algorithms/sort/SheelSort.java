package cn.com.lioan.algorithms.sort;

/**
 * 对于直接插入排序数据量巨大时使用，
 * 其思想与简单插入相同，只是进行了分组而已，即简单插入分组数为1，且下标相差也是1。
 * <p>
 * 步骤：
 * 1、将数的个数设为n，取k=n/2，将下标差值为k的数分为一组，构成有序序列；
 * 2、再取k=k/2，将下标差值为k的数分为一组，构成有序序列；
 * 3、重复第二步，直到k=1时，执行简单插入排序。
 *
 * @author dell
 */
public class SheelSort {

    public static void sheelSort(int[] a) {
        int d = a.length;
        while (d != 0) {
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < a.length; i += d) {
                    int j = i - d;
                    int temp = a[i];
                    while (j >= 0 && a[j] > temp) {
                        a[j + d] = a[j];
                        j -= d;
                    }
                    a[j + d] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {49, 24, 65, 13, 45, 98, 49, 13, 76, 98, 100, 5};
//		int[] a = {32,43,23,13,5};
        SheelSort.sheelSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
    }

}











