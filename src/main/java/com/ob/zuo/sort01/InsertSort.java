package com.ob.zuo.sort01;

/**
 * InsertSort
 *
 * @Description:
 * @CreateDate: 2022/8/13 23:57
 * @Version: 1.0
 * @Author: oubin
 */
public class InsertSort {

    public static void main(String[] args) {

    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j -1]; j--) {
                swap(arr, j, j -1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
