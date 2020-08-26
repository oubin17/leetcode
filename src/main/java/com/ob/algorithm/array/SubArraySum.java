package com.ob.algorithm.array;

/**
 * @Author: oubin
 * @Date: 2020/8/26 13:45
 * @Description: 给定一个整数数组和一个整数K，找出数组中和为k的连续的子数组的个数。
 */
public class SubArraySum {

    public static void main(String[] args) {

        int[] array = new int[]{3,5,2,-2,5,1};

        System.out.println(subArraySum(array, 8));

    }

    public static int subArraySum(int[] array, int k) {

        int[] sum = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            sum[i + 1] = array[i] + sum[i];

        }

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sum[i] - sum[j] == k) {
                    count++;
                }
            }
        }

        return count;

    }

}
