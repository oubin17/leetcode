package com.ob.leetcode.tree;

/**
 * 二叉树的最近公共祖先
 *
 * @Description: https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/
 * @CreateDate: 2022/11/18 21:34
 * @Version: 1.0
 * @Author: oubin
 */
public class LowestCommonAncestor {


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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode != null && rightNode != null) {
            return root;
        }
        return leftNode == null ? rightNode : leftNode;
    }
}
