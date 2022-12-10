package com.ob.leetcode.tree;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 * @Description: https://leetcode.cn/problems/diameter-of-binary-tree/
 * @CreateDate: 2022/12/10 15:39
 * @Version: 1.0
 * @Author: oubin
 */
public class DiameterOfBinaryTree {
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

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return diameter;

    }
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        int currentDiameter = left + right;
        diameter = Math.max(diameter, currentDiameter);

        return Math.max(left, right) + 1;
    }
}
