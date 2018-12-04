package cn.com.lioan.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

public class BaseNumberSort {

    /**
     * 描述：
     * 用于大量数、很长的数进行排序时使用
     * 1、将所有的数的个位数取出，按照个位数进行排序，构成一个序列
     * 2、将新构成的所有的数的十位数取出，按照十位数进行排序，构成一个序列
     * 3、以此类推
     *
     * @param a 待排序元素集合
     */
    public static void sort(int[] a) {
        //首先确定排序的趟数
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        int times = 0;
        //判断位数
        while (max > 0) {
            max /= 10;
            times++;
        }
        //建立10个队列
        List<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> queue1 = new ArrayList<Integer>();
            queue.add(queue1);
        }
        //进行times次分配和收集
        for (int i = 0; i < times; i++) {
            //分配数组元素
            for (int j = 0; j < a.length; j++) {
                int t = a[j];
                //得到数字的第times+1位数
                int x = a[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList<Integer> queue2 = queue.get(x);
                queue2.add(a[j]);
                queue.set(x, queue2);
            }
            int count = 0;//元素计数器
            //收集队列元素
            for (int k = 0; k < 10; k++) {
                while (queue.get(k).size() > 0) {
                    ArrayList<Integer> queue3 = queue.get(k);
                    a[count] = queue3.get(0);
                    queue3.remove(0);
                    count++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {49, 24, 65, 13, 45, 98, 49, 13, 76, 98, 100};
//		int[] a = {32,43,23,13,5};
        BaseNumberSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
    }

}
