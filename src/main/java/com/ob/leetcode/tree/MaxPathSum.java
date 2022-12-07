package com.ob.leetcode.tree;

/**
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * @Description: https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/
 * @CreateDate: 2022/12/7 21:54
 * @Version: 1.0
 * @Author: oubin
 */
public class MaxPathSum {


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

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;

    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMax = Math.max(maxGain(node.left), 0);
        int rightMax = Math.max(maxGain(node.right), 0);
        maxSum = Math.max(maxSum, node.val + leftMax + rightMax);
        return Math.max(leftMax, rightMax) + node.val;
    }
}
