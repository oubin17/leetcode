package com.ob.leetcode.tree;

import java.util.*;

/**
 * 二叉树的锯齿形层序遍历
 *
 * @Description: https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
 * @CreateDate: 2022/11/6 19:09
 * @Version: 1.0
 * @Author: oubin
 */
public class ZigzagLevelOrder {

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

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (null == root) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isPositive = true;
        while (!queue.isEmpty()) {
            LinkedList<Integer> cur = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (isPositive) {
                    cur.offerLast(root.val);
                } else {
                    cur.offerFirst(root.val);
                }
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);

                }
            }
            list.add(cur);
            isPositive = !isPositive;

        }
        return list;

    }

}

