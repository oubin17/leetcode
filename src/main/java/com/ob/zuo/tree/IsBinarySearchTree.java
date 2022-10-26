package com.ob.zuo.tree;

/**
 * IsBinarySearchTree
 *
 * @Description: 判断一棵树是否是平衡二叉树
 * 1.中序遍历，升序
 * 2.当前做法：获取每一颗子树的最大值，最小值和是否是二叉树的标识，再递归
 *
 * @CreateDate: 2022/9/11 10:38
 * @Version: 1.0
 * @Author: oubin
 */
public class IsBinarySearchTree {

    public static class TreeNode{
        private int val;

        private TreeNode left;

        private TreeNode right;
    }

    private static class Info{
        private boolean isBst;

        private int max;

        private int min;

        public Info(boolean isBst, int max, int min) {
            this.isBst = isBst;
            this.max = max;
            this.min = min;
        }
    }

    public static boolean isBinarySearchTree(TreeNode treeNode) {
        return false;
    }

    public static Info process(TreeNode node) {
        if (node == null) {
            return null;
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        int max = node.val;
        int min = node.val;
        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
        }
        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
        }

        boolean isBst = true;

        if (leftInfo != null && !leftInfo.isBst) {
            isBst = false;
        }
        if (rightInfo != null && !rightInfo.isBst) {
            isBst = false;
        }

        boolean leftMaxLessX = leftInfo == null ? true : (leftInfo.max < node.val);
        boolean rightMinMoreX = rightInfo == null ? true : (rightInfo.min > node.val);
        if (!leftMaxLessX || ! rightMinMoreX) {
            isBst = false;
        }
        return new Info(isBst, max, min);

    }

}
