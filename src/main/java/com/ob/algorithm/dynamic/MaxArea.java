package com.ob.algorithm.dynamic;

/**
 * @Author: oubin
 * @Date: 2020/8/24 22:53
 * @Description: 乘水最多的容器
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] array = new int[]{4, 6, 7, 9, 1};
        System.out.println(maxArea(array));

    }

    public static int maxArea(int[] array) {
        int i = 0;
        int j = array.length -1;
        int max = 0;
        while (i < j) {
            if (array[i] < array[j]) {
                max = Math.max(Math.min(array[i], array[j]) * (j - i), max);
                i++;
            }  else {
                max = Math.max(Math.min(array[i], array[j]) * (j - i), max);
                j--;
            }
        }
        return max;
    }
}
