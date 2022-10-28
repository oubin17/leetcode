package com.ob.leetcode.tree;


import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中序遍历
 *
 * @Description: https://leetcode.cn/problems/binary-tree-inorder-traversal/
 * @CreateDate: 2022/10/26 22:32
 * @Version: 1.0
 * @Author: oubin
 */
public class InorderTraversal {

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

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        order(root, list);
        return list;

    }

    public static void order(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        order(node.left, list);
        list.add(node.val);
        order(node.right, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(3);
        List<Integer> integers = inorderTraversal(root);
        for(Integer i : integers) {
            System.out.println(i);
        }
    }


}
