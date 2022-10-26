package com.ob.zuo.tree;

/**
 * SameTree
 *
 * @Description: 判断两棵二叉树是否完全相等
 *
 * @CreateDate: 2022/9/6 23:01
 * @Version: 1.0
 * @Author: oubin
 */
public class SameTree {

    public static class TreeNode {
        private int value;

        private TreeNode left;

        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 异或：相同为0，不同为1
     * 异或成立条件：如果一个为空，一个不为空，结果是true，两棵树不相等
     *
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        //如果一个为空，一个不为空，直接返回false，两棵树不相等
        if (p == null ^ q == null) {
            return false;
        }

        //如果 p == null成立，说明q也是null，结果是true，返回true
        if (p == null) {
            return true;
        }
        //都不为空
        return p.value == q.value && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 判断一棵树是否是镜面树
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode p1, TreeNode p2) {
        if (p1 == null ^ p2 == null) {
            return false;
        }
        if (p1 == null) {
            return true;
        }
        return p1.value == p2.value && isMirror(p1.left, p2.right) && isMirror(p1.right, p2.left);
    }

    /**
     * 求一棵树的树高
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
