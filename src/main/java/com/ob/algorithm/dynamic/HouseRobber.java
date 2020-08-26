package com.ob.algorithm.dynamic;

/**
 * @Author: oubin
 * @Date: 2020/8/26 08:40
 * @Description: 打家劫舍问题，相邻的无法同时打劫
 */
public class HouseRobber {

    public static void main(String[] args) {

        int[] value = new int[]{1, 2, 3, 1};
        System.out.println(houseRobber(value, 0));


    }

    public static int houseRobber(int[] value, int index) {
        if (index >= value.length) {
            return 0;
        }

        int res = Math.max(houseRobber(value, index + 1), value[index] + houseRobber(value, index + 2));

        return res;

    }

    public static int houseRobber(int[] value) {
        int n = value.length;
        int[] dp = new int[n + 2];
        for (int i = n -1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], value[i] + dp[i + 2]);
        }
        return dp[0];
    }

}
