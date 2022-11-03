package com.ob.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
 *
 * @Description: https://leetcode.cn/problems/recover-binary-search-tree/
 * @CreateDate: 2022/11/2 23:48
 * @Version: 1.0
 * @Author: oubin
 */
public class RecoverTree {

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

    public static void recover(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        inorderTraversal(root, nodes);
        TreeNode exNode1 = null;
        TreeNode exNode2 = null;

        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).val > nodes.get(i + 1).val) {
                exNode1 = nodes.get(i);
                break;
            }
        }

        for (int i = nodes.size() - 1; i > 0; i--) {
            if (nodes.get(i).val < nodes.get(i - 1).val) {
                exNode2 = nodes.get(i);
                break;
            }
        }
        int temp = exNode1.val;
        exNode1.val = exNode2.val;
        exNode2.val = temp;

    }

    public static void inorderTraversal(TreeNode node, List<TreeNode> nodeList) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, nodeList);
        nodeList.add(node);
        inorderTraversal(node.right, nodeList);
    }
}
