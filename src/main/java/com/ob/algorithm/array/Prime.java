package com.ob.algorithm.array;

import java.util.Arrays;

/**
 * @Author: oubin
 * @Date: 2020/8/26 10:45
 * @Description: 寻找素数:给出一个正整数n，查找正整数n中的素数个数
 */
public class Prime {

    public static void main(String[] args) {

        System.out.println(primeCount(10));
        System.out.println(primeCount2(10));
    }

    public static int primeCount(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count ++;
            }
        }
        return count;

    }

    private static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 改进版本: 这里的2 * i 可以优化为 i×i
     *
     * @param n
     * @return
     */
    public static int primeCount2(int n) {
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        for (int i = 2; i * i < n; i++) {
            if (prime[i]) {
                for (int j = 2 * i; j < n; j += i) {
                    prime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                count ++;
            }
        }
        return count;
    }
}
