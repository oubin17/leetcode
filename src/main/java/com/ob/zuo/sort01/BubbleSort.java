package com.ob.zuo.sort01;

/**
 * BubbleSort
 *
 * @Description:
 * @CreateDate: 2022/8/13 23:34
 * @Version: 1.0
 * @Author: oubin
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1,4,8,4};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 第一次循环，选出最大的数，放在N-1
     * 第二次，选出第二大的数，放在N-2
     *
     * 0- n
     * 0- n-1
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = arr.length -1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
