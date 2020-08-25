package com.ob.algorithm.array;

/**
 * @Author: oubin
 * @Date: 2020/8/24 23:44
 * @Description: 第一个未出现的正数
 */
public class FirstMissingNum {

    public static void main(String[] args) {
        int[] array = new int[]{4, 6, 2, 1, 7, 3};
        System.out.println(firstMissingNum(array));

    }

    public static int firstMissingNum(int[] array) {
        if (null == array || array.length == 0) {
            return 1;
        }
        int[] order = new int[array.length];
        for (int value : array) {
            if (value > 0 && value < array.length) {
                order[value - 1] = value;
            }
        }
        for (int i = 0; i < order.length; i++) {
            if (order[i] != i + 1) {
                return i + 1;
            }
        }
        return order.length;
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length;) {
            if (nums[i] <= 0 || nums[i] > nums.length || nums[nums[i] - 1] == nums[i]) {
                i++;
                continue;
            }

            // swap
            int tmp = nums[nums[i] - 1];
            nums[nums[i] - 1] = nums[i];
            nums[i] = tmp;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}
