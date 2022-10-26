package com.ob.zuo.sort01;

/**
 * SelectionSort
 *
 * @Description:
 * @CreateDate: 2022/8/13 23:22
 * @Version: 1.0
 * @Author: oubin
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1,4,8,4};
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    /**
     * 0-n
     * 1-n
     * 2-n
     * 选出最小的一个数，与i交换
     *
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
