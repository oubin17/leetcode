package com.ob.zuo.sort01;

/**
 * MergeSort
 *
 * @Description: 归并排序
 * 1.先保证L 到 R上有序，再合并
 * @CreateDate: 2022/9/12 15:02
 * @Version: 1.0
 * @Author: oubin
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 4,2, -1, 6, 9};
        mergeSort(arr);
        for (int j : arr) {
            System.out.println(j);

        }
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);

    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);

    }

    /**
     * 传入M
     *
     * @param arr
     * @param L
     * @param M
     * @param R
     */
    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }

    }

    /**
     * 不传中间标志M
     *
     * @param arr
     * @param L
     * @param R
     */
    public static void merge(int[] arr, int L, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int M = L + ((R - L) >> 1);
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }

    }
}
