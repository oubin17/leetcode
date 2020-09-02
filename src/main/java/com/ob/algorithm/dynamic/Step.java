package com.ob.algorithm.dynamic;

/**
 * @Author: oubin
 * @Date: 2020/8/25 13:49
 * @Description: 爬台阶
 */
public class Step {

    public static void main(String[] args) {
        int n = 10;

        System.out.println(step(n));
        System.out.println(waysToStep(n));
        System.out.println(waysToStep2(n));
        System.out.println(waysToStep3(n));

    }

    public static int step(int n) {
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }

        int[] temp = new int[n + 1];
        temp[1] = 1;
        temp[2] = 2;
        temp[3] = 4;
        for (int i = 4; i <= n; i++) {
            temp[i] = (temp[i -1] + temp[i - 2]) % 1000000007 + temp[i - 3];
            temp[i] %= 1000000007;
        }
        return temp[n];

    }


    public static int waysToStep(int n) {
        if(n <= 2) return n;
        if (n == 3) return 4;
        int[] d = new int[n + 1];

        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 4; i <= n; i++){
            d[i] = (d[i-1] + d[i-2]) % 1000000007 +d[i-3];
            d[i] %= 1000000007;
        }
        return d[n];
    }

    public static int waysToStep2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    public static int waysToStep3(int n) {
        int first = 1;
        int second = 2;
        int third = 4;
        int res = 0;
        for (int i = 4; i <= n; i++) {
            res = first + second + third;
            first = second;
            second = third;
            third = res;
        }
        return res;
    }
}
