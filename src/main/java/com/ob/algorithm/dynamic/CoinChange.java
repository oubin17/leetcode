package com.ob.algorithm.dynamic;

/**
 * @Author: oubin
 * @Date: 2020/8/25 15:22
 * @Description: 最少硬币问题
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(coinChange(coins, 11));

    }

    public static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1]; //dp[0]=0
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j - coins[i] >= 0 && dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            //没被修改过，说明凑不了
            return -1;
        } else {
            return dp[amount];
        }
    }
}
