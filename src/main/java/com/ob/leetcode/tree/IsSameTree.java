package com.ob.leetcode.tree;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * @Description: https://leetcode.cn/problems/same-tree/
 * @CreateDate: 2022/11/6 10:02
 * @Version: 1.0
 * @Author: oubin
 */
public class IsSameTree {

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
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return sameTree(p, q);

    }

    public boolean sameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null ^ q == null) {
            return false;
        }
        if ( p.val != q.val) {
            return false;
        }
        boolean left = sameTree(p.left, q.left);
        boolean right = sameTree(p.right, q.right);
        return left & right;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        IsSameTree isSameTree = new IsSameTree();
        System.out.println(isSameTree.isSameTree(p, q));
    }
}
