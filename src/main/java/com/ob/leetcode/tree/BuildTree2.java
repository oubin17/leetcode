package com.ob.leetcode.tree;

import java.util.HashMap;

/**
 * 从中序与后序遍历序列构造二叉树
 *
 * @Description: https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 * @CreateDate: 2022/11/5 17:30
 * @Version: 1.0
 * @Author: oubin
 */
public class BuildTree2 {

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLength = inorder.length;
        int postLength = postorder.length;
        if (inLength != postLength) {
            return null;
        }
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);

        }

        return buildTree(postorder, 0, postLength - 1, inorderMap, 0, inLength - 1);

    }

    public TreeNode buildTree(int[] postorder, int postLeft, int postRight, HashMap<Integer, Integer> inorderMap, int inorderLeft, int inorderRight) {

        if (postLeft > postRight || inorderLeft > inorderRight) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postRight]);
        int inIndex = inorderMap.get(postorder[postRight]);
        root.left = buildTree(postorder, postLeft, inIndex - inorderLeft + postLeft - 1, inorderMap, inorderLeft, inIndex - 1);
        root.right = buildTree(postorder, inIndex - inorderLeft + postLeft, postRight - 1, inorderMap, inIndex + 1, inorderRight);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = new int[] {9,3,15,20,7};

        int[] postorder = new int[]{9,15,7,20,3};
        BuildTree2 buildTree2 = new BuildTree2();
        buildTree2.buildTree(inorder, postorder);
    }
}
