package com.ob.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *
 * @Description: https://leetcode.cn/problems/delete-node-in-a-bst/
 * @CreateDate: 2022/12/4 10:52
 * @Version: 1.0
 * @Author: oubin
 */
public class DeleteNode {

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

    private TreeNode curNode = null;

    private Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        traversal(root, key);
        if (curNode != null) {
            if (curNode.left != null) {
                TreeNode leftNode = mostLeftNode(curNode.right);
                if (leftNode != null) {
                    leftNode.left = curNode.left;
                } else {
                    curNode.right = curNode.left;
                }
            }
            //如果是头节点，直接返回
            if (curNode.val == root.val) {
                return curNode.right;
            }
            //如果不是头节点，判断插入的节点位置
            if (parentMap.get(curNode).val > curNode.val) {
                parentMap.get(curNode).left = curNode.right;
            } else {
                parentMap.get(curNode).right = curNode.right;
            }
        }
        return root;
    }

    private void traversal(TreeNode root, int key) {
        if (root == null || curNode != null) {
            return;
        }
        if (root.left != null) {
            parentMap.put(root.left, root);
        }
        if (root.right != null) {
            parentMap.put(root.right, root);
        }
        if (root.val == key) {
            curNode = root;
        }
        traversal(root.left, key);
        traversal(root.right, key);
    }

    private TreeNode mostLeftNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        DeleteNode deleteNode = new DeleteNode();
        deleteNode.deleteNode(root, 3);
    }


}
