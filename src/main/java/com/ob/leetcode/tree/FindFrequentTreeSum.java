package com.ob.leetcode.tree;

import java.util.*;

/**
 * 给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 * 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 *
 * @Description: https://leetcode.cn/problems/most-frequent-subtree-sum/
 * @CreateDate: 2022/12/4 19:23
 * @Version: 1.0
 * @Author: oubin
 */
public class FindFrequentTreeSum {

    public static class TreeNode {
        private int val;

        private TreeNode left;

        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private HashMap<Integer, Integer> sumMap = new HashMap<>();
    private int maxFrequentTime = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        traversal(root);
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entries : sumMap.entrySet()) {
            if (entries.getValue() == maxFrequentTime) {
                list.add(entries.getKey());
            }
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    private int traversal(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sum = node.val + traversal(node.left) + traversal(node.right);
        sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        maxFrequentTime = Math.max(maxFrequentTime, sumMap.get(sum));
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);
        FindFrequentTreeSum findFrequentTreeSum = new FindFrequentTreeSum();
        findFrequentTreeSum.findFrequentTreeSum(root);

    }
    
    
}
