package com.ob.leetcode.array;

/**
 * 称水最多的容器
 *
 * @Description: https://leetcode.cn/problems/container-with-most-water/solutions/
 * @CreateDate: 2022/10/21 23:24
 * @Version: 1.0
 * @Author: oubin
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int sum = 0;
        while (left < right) {
            int current = (right - left) * Math.min(height[left], height[right]);
            if (current > sum) {
                sum = current;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return sum;
    }


}
