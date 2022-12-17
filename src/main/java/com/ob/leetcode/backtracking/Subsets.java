package com.ob.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * @Description: https://leetcode.cn/problems/subsets/
 * @CreateDate: 2022/12/15 08:28
 * @Version: 1.0
 * @Author: oubin
 */
public class Subsets {

    private List<List<Integer>> subList = new ArrayList<>();

    private LinkedList<Integer> current = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums, 0);
        return subList;

    }

    /**
     * 这里是i + 1还是level + 1
     *
     * @param nums
     * @param start
     */
    private void backTrack(int[] nums, int start) {

        subList.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.addLast(nums[i]);
            backTrack(nums, i + 1);
            current.removeLast();

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Subsets subsets = new Subsets();
        subsets.subsets(nums);
    }
}
