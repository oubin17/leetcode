package com.ob.algorithm.sort;

/**
 * @Author: oubin
 * @Date: 2020/8/24 21:23
 * @Description: 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] sort = new int[]{3, 7, 9, 53, 2};
        selectionSort(sort);
        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i]);
        }
    }

    public static void selectionSort(int[] sort) {
        if (null == sort || sort.length == 1) {
            return;
        }
        for (int i = 0; i < sort.length; i++) {
            int min = i;
            for (int j = i + 1; j < sort.length; j++) {
                if (sort[i] > sort[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = sort[i];
                sort[i] = sort[min];
                sort[min] = temp;
            }
        }
    }
}
