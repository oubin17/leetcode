package com.ob.algorithm.array;

/**
 * @Author: oubin
 * @Date: 2020/8/31 19:38
 * @Description: 移除数组中与给定值相同的元素[LeetCode]
 */
public class Remove {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 4, 6, 7};
        int x = 2;
        remove(array, x);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void remove(int[] nums, int x) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != x) {
                nums[i] = nums[j]; // 关键就是这一步将值放入一个递增的i中
                i++;
            }
        }

    }
}
