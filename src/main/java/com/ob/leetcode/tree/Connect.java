package com.ob.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针
 *
 * @Description: https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/description/
 * @CreateDate: 2022/11/9 23:42
 * @Version: 1.0
 * @Author: oubin
 */
public class Connect {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            val = val;
            left = left;
            right = right;
            next = next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(cur);
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (i != size - 1) {
                    cur.next = queue.peek();
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return root;
    }

    /**
     * 常数空间解法
     *
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if(root==null) return null;
        connection(root);
        return root;
    }
    public void connection(Node root){
        if(root.left == null) return;
        root.left.next=root.right;
        if(root.next != null){
            root.right.next=root.next.left;
        }
        connection(root.left);
        connection(root.right);
    }



    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right = new Node(3);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        Connect connect = new Connect();
        connect.connect(node);

    }

}

