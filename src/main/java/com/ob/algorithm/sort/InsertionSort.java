package com.ob.algorithm.sort;

/**
 * @Author: oubin
 * @Date: 2020/8/24 21:37
 * @Description: 插入排序
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] sort = new int[]{3, 7, 9, 53, 2};
        insertionSort(sort);
        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i]);
        }
    }

    public static void insertionSort(int[] sort) {

        for (int i = 1; i < sort.length; i++) {
            int j = i;
            int temp = sort[i];
            while (j > 0 && temp < sort[j - 1]) {
                sort[j] = sort[j - 1];
                j--;
            }
            if (i != j) {
                sort[j] = temp;
            }
        }
    }
}
