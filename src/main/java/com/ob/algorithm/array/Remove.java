package com.ob.algorithm.array;

/**
 * @Author: oubin
 * @Date: 2020/8/31 19:38
 * @Description: 移除数组中与给定值相同的元素保持原有的元素顺序，并且末尾补0
 */
public class Remove {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 4, 6, 7};
        int x = 4;
//        remove(array, x);
        remove2(array, x);

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

    /**
     * 快慢指针的解法，快指针发现不等于的时候，和慢指针对换
     * @param nums
     * @param x
     */
    public static void remove2(int[] nums, int x) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != x) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            } else {
                nums[right] = 0;
            }
            right++;
        }
    }
}
