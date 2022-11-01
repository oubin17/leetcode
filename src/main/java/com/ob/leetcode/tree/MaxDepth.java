package com.ob.leetcode.tree;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * @Description: https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 * @CreateDate: 2022/10/30 16:19
 * @Version: 1.0
 * @Author: oubin
 */
public class MaxDepth {

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

    public static int maxDepth (TreeNode root) {
        return depth(root);

    }

    public static int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        return Math.max(left, right)  + 1;

    }
}
