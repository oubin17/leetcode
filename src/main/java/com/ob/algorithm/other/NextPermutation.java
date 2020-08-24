package com.ob.algorithm.other;

/**
 * @Author: oubin
 * @Date: 2019/4/11 09:01
 * @Description: 算法需要将给定数字序列重新排列成字典序中下一个更大的排列
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] x = new int[]{1,3,2};
        nextPermutation(x);
    }

    public static void nextPermutation(int[] nums) {
        int index;
        int min = nums.length - 1;
        for (index = nums.length - 1; index > 0 ; index--) {
            if (nums[index] > 0 && nums[index - 1] < nums[min]) {
                min = index - 1;
            }
            if (nums[index-1] < nums[index]) {
                int temp = nums[min];
                nums[min] = nums[index-1];
                nums[index-1] = temp;
                for (int j = 0; j < nums.length; j++) {
                    System.out.println(nums[j]);
                }
                break;
            }
        }
        if (index == 0) {
            for (int j = nums.length - 1; j >= 0; j--) {
                System.out.println(nums[j]);
            }
        }
    }
}
