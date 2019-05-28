package com.ob.algorithm;

/**
 * @Author: oubin
 * @Date: 2019/5/28 16:55
 * @Description: 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class MaxProduct {

    public static void main(String[] args) {
        int[] nums = {-2,3,-4};
        System.out.println(maxProduct(nums));

    }

    public static int maxProduct(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            max = nums[i] > max ? nums[i] : max;
        }
        for (int i = 0; i < nums.length - 1; i ++) {
            int temp = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                temp = temp * nums[j];
                if (temp > max) {
                    max = temp;
                }
            }

        }
        return max;

    }
}
