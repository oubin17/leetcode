package com.ob.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树迭代器
 *
 * @Description: https://leetcode.cn/problems/binary-search-tree-iterator/
 * @CreateDate: 2022/11/11 21:52
 * @Version: 1.0
 * @Author: oubin
 */
public class BSTIterator {

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

    private List<Integer> nodeValue;

    private int index;


    public BSTIterator(TreeNode root) {
        nodeValue = new ArrayList<>();
        inorderTraversal(root, nodeValue);
        if (nodeValue.size() > 0) {
            nodeValue.add(0, nodeValue.get(0) - 1);
            index = 0;
        } else {
            index = -1;
        }

    }

    public int next() {
        if (index != -1) {
            return nodeValue.get(++index);
        }
        return -1;

    }

    public boolean hasNext() {
        if (index != -1) {
            return index != nodeValue.size() - 1;
        }
        return false;

    }

    private void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BSTIterator bstIterator = new BSTIterator(root);
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());

    }


}
