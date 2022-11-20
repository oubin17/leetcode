package com.ob.leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Codec2
 *
 * @Description:
 * @CreateDate: 2022/11/20 23:48
 * @Version: 1.0
 * @Author: oubin
 */
public class Codec2 {

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
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();

        return traversal(root);


    }

    public String traversal(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return root.val + "," + traversal(root.left) + "," + traversal(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        List<String> queue = new ArrayList<>(Arrays.asList(data.split(",")));

        return deTraversal(queue);

    }

    public TreeNode deTraversal(List<String> queue) {
        String element = queue.remove(0);
        if ("null".equals(element)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(element));
        node.left = deTraversal(queue);
        node.right = deTraversal(queue);

        return node;
    }
}
