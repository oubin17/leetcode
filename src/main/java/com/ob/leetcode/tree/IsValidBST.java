package com.ob.leetcode.tree;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * @Description: https://leetcode.cn/problems/validate-binary-search-tree/
 * @CreateDate: 2022/11/3 22:47
 * @Version: 1.0
 * @Author: oubin
 */
public class IsValidBST {

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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        return checkBSTTree(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    public static boolean checkBSTTree(TreeNode node, long lower, long upper) {
        if (null == node) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return checkBSTTree(node.left, lower, node.val) && checkBSTTree(node.right, node.val, upper);
    }

    /**
     * 错误写法
     *
     * @param node
     * @param res
     * @return
     */
    public static boolean checkBSTTree(TreeNode node, boolean res) {
        if (!res) {
            return false;
        }
        if (node == null) {
            return true;
        }
        if (node.left != null && node.right != null) {
            res =  node.val > node.left.val && node.val < node.right.val;
        } else if (node.left != null) {
            res = node.val > node.left.val;
        } else if (node.right != null){
            res = node.val < node.right.val;
        }
        if (!res) {
            return false;
        }
        res = checkBSTTree(node.left, true) && checkBSTTree(node.right, true);

        return res;
    }

}
