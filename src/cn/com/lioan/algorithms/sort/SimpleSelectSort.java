package cn.com.lioan.algorithms.sort;

/**
 * 简单选择排序：常用于取序列中最大或最小的几个数字
 * 如果每次比较完都需要交换，那就是交换排序；否则如果每次比较完一个循环再交换，那就是简单选择排序
 * 步骤：
 * 1、遍历整个序列，将最小的数放在最前面；
 * 2、遍历剩下的序列，将最小的数放在最前面；
 * 3、重复1、2，直到只剩下一个数
 *
 * @author dell
 */
public class SimpleSelectSort {

    public static void selectSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < a.length; i++) {//循环次数
            int position = i;
            int key = a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < key) {
                    key = a[j];
                    position = j;
                }
            }
            //交换位置
            a[position] = a[i];
            a[i] = key;
        }
    }

    public static void main(String[] args) {
        int[] a = {49, 24, 65, 13, 45, 98, 49, 13, 76, 98, 100};
//		int[] a = {32,43,23,13,5};
        SimpleSelectSort.selectSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
    }

}
