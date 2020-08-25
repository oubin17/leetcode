package com.ob.algorithm.dynamic;

import java.util.Arrays;

/**
 * @Author: oubin
 * @Date: 2020/8/25 22:00
 * @Description: 最长递增子序列: 10,9,2,5,3,7,101,18   4  2,3,7,101
 * https://github.com/labuladong/fucking-algorithm/blob/master/动态规划系列/动态规划设计：最长递增子序列.md
 */
public class MaxLengthAsc {

    public static void main(String[] args) {
        int[] array = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(maxLengthAsc(array));

    }

    public static int maxLengthAsc(int[] array) {
        //dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度，本质上就是找到比当前节点小的之前节点，并且比较最大的值 +1；
        int[] dp = new int[array.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int res = 1;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
