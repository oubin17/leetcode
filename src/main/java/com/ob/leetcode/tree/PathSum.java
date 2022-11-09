package com.ob.leetcode.tree;


import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * @Description: https://leetcode.cn/problems/path-sum-ii/description/
 * @CreateDate: 2022/11/9 22:38
 * @Version: 1.0
 * @Author: oubin
 */
public class PathSum {

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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> finalPath = new ArrayList<>();
        traversal(root, targetSum, 0, new ArrayList<>(), finalPath);
        return finalPath;

    }

    public void traversal(TreeNode node, int targetSum, int curSum, List<Integer> path, List<List<Integer>> finalPath) {
        if (node == null) {
            return;
        }
        curSum += node.val;
        path.add(node.val);
        if (targetSum == curSum && node.left == null && node.right == null) {
            finalPath.add(new ArrayList<>(path));
        }
        traversal(node.left, targetSum, curSum, path, finalPath);
        traversal(node.right, targetSum, curSum, path, finalPath);
        path.remove(path.size() - 1);

    }

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        pathSum.pathSum(null, 1);
    }

}
