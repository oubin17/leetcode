package com.ob.leetcode.tree;

/**
 *  将有序数组转换为二叉搜索树
 *
 * @Description: https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
 * @CreateDate: 2022/11/6 10:54
 * @Version: 1.0
 * @Author: oubin
 */
public class SortedArrayToBST {

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

    public TreeNode sortedArrayToBST(int[] nums) {
        return generateTree(nums, 0, nums.length - 1);
    }

    public TreeNode generateTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = generateTree(nums, start, mid - 1);
        root.right = generateTree(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        TreeNode treeNode = sortedArrayToBST.sortedArrayToBST(nums);
        System.out.println(treeNode.val);
    }

}
