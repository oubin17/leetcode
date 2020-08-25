package com.ob.algorithm.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: oubin
 * @Date: 2020/8/25 10:58
 * @Description: 斐波那契数列解法: 1 1 2 3 5 8 13
 */
public class Fibonacci {


    public static void main(String[] args) {
        System.out.println(fibonacci(6));
        System.out.println(fibonacci3(6));

    }

    public static int fibonacci(int n) {
        if (n < 2) {
            return 1;
        }
        return fibonacci(n -1) + fibonacci(n - 2);
    }

    public static int fibonacci2(int n) {
        List<Integer> list = new ArrayList<>(n);
        if (n < 2) {

        }
        return 0;
    }


    public static int fibonacci3(int n) {
        if (n < 2) {
            return 1;
        }

        int first = 1;
        int second = 1;
        int index = 2;
        for (int i = 2; i < n + 1; i++) {
            index = first + second;
            first = second;
            second = index;
        }
        return index;
    }


}
