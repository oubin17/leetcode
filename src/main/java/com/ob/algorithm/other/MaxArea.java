package com.ob.algorithm.other;

/**
 * @author: oubin
 * @date: 2019/3/27 09:50
 * @Description: 盛水最多的容器
 */
public class MaxArea {

    public static void main(String[] args) {

        int[] a = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea2(a));
    }

    public static int maxArea(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxarea;
    }

    public static int maxArea2(int[] height) {
        int maxarea = 0;
        int i = 0;
        int j = height.length -1;
        while (i < j) {
            maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i ++;
            }else {
                j --;
            }
        }
        return maxarea;
    }
}
