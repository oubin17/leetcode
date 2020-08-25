package com.ob.algorithm.sort;

/**
 * @Author: oubin
 * @Date: 2020/8/24 21:15
 * @Description: 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] sort = new int[]{3, 7, 9, 53, 2};
        bubbleSort(sort);
        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i]);
        }
    }

    public static void bubbleSort(int[] sort) {

        if (sort == null || sort.length == 1) {
            return;
        }

        for (int i = 0; i < sort.length; i++) {
            boolean flag = true;
            for (int j = 0; j < sort.length - i - 1; j++) {
                if (sort[j] > sort[j + 1]) {
                    int temp = sort[j];
                    sort[j] = sort[j + 1];
                    sort[j + 1] = temp;

                    flag = false;
                }
            }
            if (flag) {
                break;
            }

        }

    }
}
