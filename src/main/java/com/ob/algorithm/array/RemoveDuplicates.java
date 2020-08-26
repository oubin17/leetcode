package com.ob.algorithm.array;

/**
 * @Author: oubin
 * @Date: 2020/8/26 14:16
 * @Description: 去除有序数组中的重复元素
 */
public class RemoveDuplicates {

    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 2, 3, 4, 4, 6, 7, 7};
        System.out.println(removeDuplicates(array));

    }

    public static int removeDuplicates(int[] array) {

        int left = 0;
        int right = 1;
        while (right < array.length) {
            if (array[left] != array[right]) {
                left ++;
                array[left] = array[right];
            }
            right ++;
        }
        return left + 1;

    }
}
