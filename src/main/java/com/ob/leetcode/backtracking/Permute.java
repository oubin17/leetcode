package com.ob.leetcode.backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * @Description: https://leetcode.cn/problems/permutations/
 * @CreateDate: 2022/12/12 22:42
 * @Version: 1.0
 * @Author: oubin
 */
public class Permute {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }

        List<Integer> currents = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        backTracking(nums, currents, flag);

        return result;

    }

    private void backTracking(int[] nums, List<Integer> currents, boolean[] flag) {
        if (currents.size() == nums.length) {
            result.add(new ArrayList<>(currents));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) {
                continue;
            }
            currents.add(nums[i]);
            flag[i] = !flag[i];
            backTracking(nums, currents, flag);
            currents.remove(currents.size() - 1);
            flag[i] = !flag[i];
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[3];
        nums[0] = 7;
        nums[1] = 8;
        nums[2] = 9;
        Permute permute = new Permute();
        permute.permute(nums);
        System.out.println(permute.result.size());

    }

}
