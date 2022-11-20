package com.ob.leetcode.tree;

import java.util.*;

/**
 * 二叉树的序列化与反序列化
 *
 * @Description: https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
 * @CreateDate: 2022/11/20 22:01
 * @Version: 1.0
 * @Author: oubin
 */
public class Codec {

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
        traversal(root, list);

        return String.join(",", list);

    }

    public void traversal(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("null");
            return;
        }
        list.add(String.valueOf(root.val));
        traversal(root.left, list);
        traversal(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));

        return deTraversal(queue);

    }

    public TreeNode deTraversal(Queue<String> queue) {
        String element = queue.poll();
        if ("null".equals(element)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(element));
        node.left = deTraversal(queue);
        node.right = deTraversal(queue);

        return node;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String s = codec.serialize(root);
        System.out.println(s);
        TreeNode deserialize = codec.deserialize(s);
        System.out.println(deserialize.val);


    }
}
