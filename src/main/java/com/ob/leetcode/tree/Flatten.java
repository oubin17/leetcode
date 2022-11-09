package com.ob.leetcode.tree;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * @Description: https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 * @CreateDate: 2022/11/9 00:17
 * @Version: 1.0
 * @Author: oubin
 */
public class Flatten {

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

    public void flatten(TreeNode root) {
        treeToList(root);
    }

    public TreeNode treeToList(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode leftNode = treeToList(node.left);
        TreeNode rightNode = treeToList(node.right);

        if (leftNode != null) {
            node.right = leftNode;
            node.left = null;

            //左子树的最右子树
            while (leftNode.right != null) {
                leftNode = leftNode.right;
            }
            leftNode.right = rightNode;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        Flatten flatten = new Flatten();
        flatten.flatten(root);

    }
}
