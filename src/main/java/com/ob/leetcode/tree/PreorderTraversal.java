package com.ob.leetcode.tree;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

/**
 * PreorderTraversal
 *
 * @Description:
 * @CreateDate: 2022/11/11 21:39
 * @Version: 1.0
 * @Author: oubin
 */
public class PreorderTraversal {

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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    public void traversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        traversal(node.left, list);
        traversal(node.right, list);
        list.add(node.val);

    }

}
