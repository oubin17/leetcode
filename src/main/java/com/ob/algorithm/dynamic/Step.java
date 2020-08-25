package com.ob.algorithm.dynamic;

/**
 * @Author: oubin
 * @Date: 2020/8/25 13:49
 * @Description: 爬台阶
 */
public class Step {

    public static void main(String[] args) {

        System.out.println(step(4));

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


    public int waysToStep(int n) {
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
}
