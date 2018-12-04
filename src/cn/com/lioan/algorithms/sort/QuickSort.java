package cn.com.lioan.algorithms.sort;

/**
 * @author lixx
 * @description 快速排序类
 * @title QuickSort
 */
public class QuickSort {

    //简单快速排序
    public static void simpleQuickSort(int[] a, int start, int end) {
        if (start < end) {
            int base = a[start];
            int temp;
            int i = start, j = end;
            do {
                while (a[i] < base && i < end)
                    i++;
                while (a[j] > base && j > start)
                    j--;
                if (i <= j) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j) {
                simpleQuickSort(a, start, j);
            }
            if (end > i) {
                simpleQuickSort(a, i, end);
            }
        }
    }

    //一次划分
    public static int partition(int[] a, int low, int high) {
        int pivot = a[low];
        while (low < high) {
            while (low < high && a[high] >= pivot) --high;
            a[low] = a[high];
            while (low < high && a[low] <= pivot) ++low;
            a[high] = a[low];
        }
        a[low] = pivot;
        return low;
    }

    //快速排序 递归调用本身进行划分
    public static void sort(int[] a, int low, int high) {
        int pivotLoc;
        if (low < high) {
            pivotLoc = partition(a, low, high);
            sort(a, low, pivotLoc - 1);
            sort(a, pivotLoc + 1, high);
        }
    }

    //快速排序入口
    public static void quickSort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        int[] a = {49, 24, 65, 13, 45, 98, 76, 49, 56, 100};
        simpleQuickSort(a, 0, a.length - 1);
//		quickSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
    }

}
