package com.ob.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * @Description: https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/
 * @CreateDate: 2022/11/5 21:01
 * @Version: 1.0
 * @Author: oubin
 */
public class LevelOrderBottom {

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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<List<Integer>> linkedList = new LinkedList<>();
        Deque<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        while (nodeList.size() > 0) {
            int size = nodeList.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                root = nodeList.pop();
                list.add(root.val);
                if (root.left != null) {
                    nodeList.add(root.left);
                }
                if (root.right != null) {
                    nodeList.add(root.right);
                }
            }
            linkedList.addFirst(list);

        }
        return linkedList;

    }

    public static void main(String[] args) {
        LevelOrderBottom levelOrderBottom = new LevelOrderBottom();
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        levelOrderBottom.levelOrderBottom(treeNode);
    }
}
