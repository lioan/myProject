package cn.com.lioan.algorithms.sort;

import java.util.Arrays;

/**
 * Created by lixiaoxiong896 on 2018/5/31.
 * 堆排序demo
 */
public class HeapSort2 {
    public static void heapSort_weixin(int[] arr) {
        //1.构建大顶堆
        for (int i = arr.length/2-1; i >= 0; i--) {
            //从第一个非叶子节点从下至上，从右至左调整结构
            adjustHeap_weixin(arr, i, arr.length);
            System.out.println(Arrays.toString(arr));
        }

        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
            adjustHeap_weixin(arr, 0, j);//重新对堆进行调整
        }
    }

    private static void adjustHeap_weixin(int[] arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for (int k = i*2 + 1; k < length; k = k*2 + 1) {//从i结点的左子结点开始，也就是2i+1处开始
            if (k + 1 < length && arr[k] < arr[k+1]) {//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if (arr[k] > temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    private static void swap(int[] arr,int i,int j){
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    public static void main(String[] args){
//    int[] arr = {4,6,8,5,9};
        int[] arr = {9,6,7,3,8,1,5,2,4};
        System.out.println(Arrays.toString(arr));
        heapSort_weixin(arr);
        System.out.println(Arrays.toString(arr));
    }
}
