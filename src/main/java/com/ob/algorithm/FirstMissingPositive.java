package com.ob.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: oubin
 * @Date: 2019/4/9 08:01
 * @Description: 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0};
        System.out.println(firstMissingPositive2(nums));
    }

    public static int firstMissingPositive3(int[] nums) {
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 1 && nums[i] <= nums.length) {
                temp[nums[i] - 1] = nums[i];
            }
        }

        int i;
        for (i = 0; i < nums.length; i++) {
            if (temp[i] != (i + 1)) {
                break;
            }
        }
        return i + 1;
    }

    public static int firstMissingPositive2(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 1;
        }
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 1 && nums[i] <= nums.length) {
                arr[nums[i] - 1] = nums[i];
            }
        }
        int i;
        for (i = 0; i < arr.length; i ++) {
            if (arr[i] != (i + 1)) {
                break;
            }
        }
        return i + 1;
    }

    public static int firstMissingPositive(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 1;
        }
        final List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            list.add(nums[i]);
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        if (min > 1) {
            return 1;
        }
        for (int i = min + 1; i < max; i++) {
            for (int j = 0; j < nums.length; j ++) {
                if (i > 0 && !list.contains(i)) {
                    return i;
                }

            }

        }
        return max > 0 ? max + 1 : 1;

    }


}
