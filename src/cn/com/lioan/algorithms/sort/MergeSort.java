package cn.com.lioan.algorithms.sort;

public class MergeSort {
    /**
     * 归并排序，速度仅次于快速排序，内存少的时候使用，可以进行并行计算
     *
     * @param a
     * @param left
     * @param right
     */
    public static void mergeSort(int[] a, int left, int right) {
        int t = 1;//每组元素的个数
        int size = right - left + 1;
        while (t < size) {
            int s = t;//本次循环每组元素个数
            t = 2 * s;//每次归并排序的元素个数
            int i = left;
            while (i + (t - 1) < size) {
                //每次归并相邻的两组
                //i-单次归并的起始位置，i + (s -1)-归并分组1的结束位置，i + (t -1)-归并分组2的结束位置
                merge(a, i, i + (s - 1), i + (t - 1));
                i += t;
            }
            if (i + (s - 1) < right) {
                merge(a, i, i + (s - 1), right);
            }
        }
    }

    /**
     * 单次归并排序
     *
     * @param data 归并元素集合
     * @param p    此次归并的起始位置
     * @param q    此次归并第一组的结束位置
     * @param r    此次归并的结束位置(即此次归并第二组的结束位置)
     */
    private static void merge(int[] data, int p, int q, int r) {
        int[] B = new int[data.length];
        int s = p;
        int t = q + 1;
        int k = p;
        while (s <= q && t <= r) {
            if (data[s] <= data[t]) {
                B[k] = data[s];
                s++;
            } else {
                B[k] = data[t];
                t++;
            }
            k++;
        }
        do {
            if (s == q + 1) {
                B[k++] = data[t++];
            } else {
                B[k++] = data[s++];
            }
        } while (k <= r);
        for (int i = p; i <= r; i++) {
            data[i] = B[i];
        }
    }

    public static void main(String[] args) {
//		int[] a = {49,24,65,13,45,98,49,13,76,98,100};
        int[] a = {32, 43, 23, 13, 5};
        MergeSort.mergeSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
    }

}
