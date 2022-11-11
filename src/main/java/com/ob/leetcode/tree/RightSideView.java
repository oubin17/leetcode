package com.ob.leetcode.tree;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * @Description: https://leetcode.cn/problems/binary-tree-right-side-view/solutions/
 * @CreateDate: 2022/11/11 22:20
 * @Version: 1.0
 * @Author: oubin
 */
public class RightSideView {

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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightViewList = new ArrayList<>();
        if (root == null) {
            return rightViewList;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                root = deque.poll();
                if (root.right != null) {
                    deque.offer(root.right);
                }
                if (root.left != null) {
                    deque.offer(root.left);
                }
                if (i == 0) {
                    rightViewList.add(root.val);
                }
            }
        }
        return rightViewList;
    }
}
