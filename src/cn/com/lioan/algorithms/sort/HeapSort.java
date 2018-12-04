package cn.com.lioan.algorithms.sort;

import java.util.Arrays;

/**
 * 堆排序：对简单选择排序的优化
 * <p>
 * 步骤：
 * 1、将序列构建成大顶堆；
 * 2、将根节点与最后一个节点交换，然后断开最后一个节点；
 * 3、重复第1、2步，直到所有节点都断开。
 *
 * @author dell
 */
public class HeapSort {

    public static void heapSort(int[] a) {
        System.out.println("开始排序");
        int len = a.length;
        //循环建堆
        for (int i = 0; i < len - 1; i++) {
            //键堆
            buildMaxHead(a, len - 1 - i);
            //交换堆顶和最后一个元素
            swap(a, 0, len - 1 - i);
            System.out.println(Arrays.toString(a));
        }
    }

    //交换d[i],d[j]
    private static void swap(int[] d, int i, int j) {
		/*d[i] = d[i] + d[j];
		d[j] = d[i] - d[j];
		d[i] = d[i] - d[j];*/
        int temp = d[i];
        d[i] = d[j];
        d[j] = temp;
    }

    //对d数组从0到lastIndex键大顶堆
    private static void buildMaxHead(int[] d, int lastIndex) {
        //从lastIndex处节点(最后一个节点)的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            //k保存正在判断的节点
            int k = i;
            //如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                //k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                //如果biggerIndex小于lastIndex,即biggerIndex + 1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    //如果右子节点的值较大
                    if (d[biggerIndex] < d[biggerIndex + 1]) {
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                //如果k节点的值小于其较大子节点的值
                if (d[k] < d[biggerIndex]) {
                    //交换他们
                    swap(d, k, biggerIndex);
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {49, 24, 65, 13, 45, 98, 49, 13, 76, 98, 100, 5};
//		int[] a = {32,43,23,13,5};
        HeapSort.heapSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
    }

}














