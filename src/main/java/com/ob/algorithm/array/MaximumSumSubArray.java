package com.ob.algorithm.array;

import java.util.Arrays;

/**
 * @Author: oubin
 * @Date: 2020/9/2 10:11
 * @Description: 最大子序列和:dp[i]表示第0个到第i个序列的和， dp[i] - dp[j]表示i到j-1的和，也就是子序列和。
 */
public class MaximumSumSubArray {

    public static void main(String[] args) {
        int[] array = new int[]{10, -2, -3, -4, 5, 9};
        System.out.println(maximumSumSubArray(array));
    }

    public static int maximumSumSubArray(int[] array) {
        int[] dp = new int[array.length + 1];
        Arrays.fill(dp, 0);
        int max = dp[0];
        for (int i = 0; i < array.length; i++) {
            dp[i + 1] = dp[i] + array[i];
            for (int j = 0; j <= i; j++) {
                max = Math.max(dp[i + 1] - dp[j], max);
            }
        }
        return max;
    }
}
