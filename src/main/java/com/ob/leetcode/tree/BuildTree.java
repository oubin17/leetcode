package com.ob.leetcode.tree;

import java.util.HashMap;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * @Description: https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solutions/255811/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9/
 * @CreateDate: 2022/11/5 16:37
 * @Version: 1.0
 * @Author: oubin
 */
public class BuildTree {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int preLength = preorder.length;
        int inLength = inorder.length;
        if (preLength != inLength) {
            return null;
        }
        HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inLength; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preLength - 1, inorderIndexMap, 0, inLength - 1);

    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, HashMap<Integer, Integer> inorderIndexMap, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        root.left = buildTree(preorder, preLeft + 1, inorderIndexMap.get(preorder[preLeft])  - inLeft + preLeft, inorderIndexMap, inLeft, inorderIndexMap.get(preorder[preLeft]) - 1);
        root.right = buildTree(preorder, inorderIndexMap.get(preorder[preLeft])  - inLeft + preLeft + 1, preRight, inorderIndexMap, inorderIndexMap.get(preorder[preLeft]) + 1, inRight);

        return root;

    }

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        int[] preOrder = new int[]{3,9,20,15,7};
        int[] inOrder = new int[]{9,3,15,20,7};
        TreeNode treeNode = buildTree.buildTree(preOrder, inOrder);
        System.out.println(treeNode);
    }

}
