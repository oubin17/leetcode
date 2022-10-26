package com.ob.leetcode.array;

/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库的sort函数的情况下解决这个问题。
 *
 * @Description: https://leetcode.cn/problems/sort-colors/
 * @CreateDate: 2022/10/24 23:37
 * @Version: 1.0
 * @Author: oubin
 */
public class SortColor {


    public static void main(String[] args) {
        int[] nums = new int[]{1};
        sortColors(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void sortColors(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;
        while (cur <= right) {
            if (nums[cur] == 0) {
                if (cur == left) {
                    cur++;
                } else {
                    exchange(nums, left, cur);
                }
                left ++;
            } else if (nums[cur] == 2) {
                exchange(nums, right, cur);
                right --;
            } else {
                cur ++;
            }
        }
    }

    public static void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
