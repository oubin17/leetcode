package com.ob.leetcode.tree;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * @Description: https://leetcode.cn/problems/minimum-absolute-difference-in-bst/
 * @CreateDate: 2022/12/10 15:51
 * @Version: 1.0
 * @Author: oubin
 */
public class GetMinimumDifference {

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
    private int min = Integer.MAX_VALUE;
    private int pre = -1;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMinimumDifference(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            min = Math.min(min, root.val - pre);
            pre = root.val;
        }


        getMinimumDifference(root.right);
        return min;

    }

    
}
