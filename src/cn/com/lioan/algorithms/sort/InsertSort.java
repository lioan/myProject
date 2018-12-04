package cn.com.lioan.algorithms.sort;

public class InsertSort {

    //简单直接插入排序
    public static void insertSort(int[] a) {
        int length = a.length;
        int insertTemp;
        for (int i = 1; i < a.length; i++) {
            insertTemp = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > insertTemp) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = insertTemp;
        }
    }

    //直接插入排序：将第一个元素作为一个初始的有序队列
    public static void directInsertSort(int[] a) {
        int temp, k = -1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {//如果将要插入的元素<有序队列的最后一个 则进行迭代比较插入
                temp = a[i];
                a[i] = a[i - 1];//有序队列最后一个元素向后移动一位
                if (i >= 2) {
                    k = i - 1;// 表示没有进入内循环 即新加入的元素只比有序队列的最后一个小 且位于新的有序队列的倒数第二位置
                    for (int j = i - 2; j >= 0 && temp < a[j]; j--) {
                        a[j + 1] = a[j];
                        k = j;
                    }
                    if (k != -1) {
                        //将新加入元素插入合适的位置
                        a[k] = temp;
                    }
                } else {
                    a[0] = temp;
                }
            }
        }
    }

    //折半插入排序
    public static void binaryInsertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int low = 0;
            int high = i - 1;
            int m;
            while (low <= high) {
                m = (low + high) / 2;
                if (temp < a[m]) {
                    high = m - 1;//插入点在低半区
                } else {
                    low = m + 1;//插入点在高半区
                }
            }
            for (int j = i - 1; j >= high + 1; j--) {
                a[j + 1] = a[j];//所有插入的位置记录后移
            }
            a[high + 1] = temp;//插入
        }
    }

    //2-路插入排序
    public static void twoRoadInsertSort(int[] a) {
        int len = a.length;
        int[] d = new int[len];
		/*for (int i : d) {
			System.out.println(i);
		}*/
        int first = len;
        int finall = 0;
        d[0] = a[0];
        for (int i = 1; i < len; i++) {
            if (a[i] < d[0]) {//小于关键字 则插入d前
                while (a[i] > a[first]) {

                }
                first++;
            } else {//不小于关键字 则插入d后
                while (finall > 0 && a[i] < d[finall]) {

                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {49, 24, 65, 13, 45, 98, 49, 13, 76, 98, 100};
        insertSort(a);
//		directInsertSort(a);
//		binaryInsertSort(a);
//		twoRoadInsertSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
    }
}
