package com.ob.algorithm;

import java.util.Arrays;

/**
 * @Author: oubin
 * @Date: 2019/6/20 14:56
 * @Description: 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。(自定义compare方法)
 */
public class LargestNumber {

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if (strs[0].equals("0")) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }
}
