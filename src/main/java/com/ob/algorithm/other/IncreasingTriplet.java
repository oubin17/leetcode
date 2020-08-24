package com.ob.algorithm.other;

/**
 * @Author: oubin
 * @Date: 2019/6/10 11:24
 * @Description: 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 数学表达式如下:
 *
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 */
public class IncreasingTriplet {

    public static void main(String[] args) {
        int[] nums = {5,1,5,5,2,5,4};
        System.out.println(increasingTriplet(nums));
    }

    public static boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (a >= nums[i]) {
                a = nums[i];
            } else if (b >= nums[i]) {
                b = nums[i];
            } else {
                return true;
            }
        }
        return false;

    }
}
