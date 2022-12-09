package com.ob.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）
 *
 * @Description: https://leetcode.cn/problems/path-sum-iii/
 * @CreateDate: 2022/12/7 22:48
 * @Version: 1.0
 * @Author: oubin
 */
public class PathSumNum {
    
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

    private int num = 0;

    public int pathSum(TreeNode root, int targetSum) {
        traversal(root, targetSum);
        return num;

    }

    private List<Long> traversal(TreeNode node, int targetSum) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<Long> left = traversal(node.left, targetSum);
        List<Long> right = traversal(node.right, targetSum);
        List<Long> temp = new ArrayList<>();
        temp.add((long) node.val);
        if (node.val == targetSum) {
            num++;
        }
        for(Long i : left) {
            if (node.val + i == targetSum) {
                num++;
            }
            temp.add(i + node.val);
        }
        for (Long i : right) {
            if (node.val + i == targetSum) {
                num++;
            }
            temp.add(i + node.val);
        }
        return temp;
    }


    public int pathNum2(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = rootSum(root, targetSum);
        ret += pathNum2(root.left, targetSum);
        ret += pathNum2(root.right, targetSum);
        return ret;

    }
    public int rootSum(TreeNode node, long targetSum) {
        if (node == null) {
            return 0;
        }
        int ret = 0;
        if (node.val == targetSum) {
            ret ++;
        }
        ret += rootSum(node.left, targetSum - node.val);
        ret += rootSum(node.right, targetSum - node.val);
        return ret;
    }

    public static void main(String[] args) {
        int a = 1000000000;
        int b = 294967296;
        System.out.println(a * 2 + b);
    }


}
