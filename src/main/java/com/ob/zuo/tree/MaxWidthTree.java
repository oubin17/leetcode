package com.ob.zuo.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * MaxWidthTree
 *
 * @Description:
 * @CreateDate: 2022/9/14 23:09
 * @Version: 1.0
 * @Author: oubin
 */
public class MaxWidthTree {

    public static class Node {
        int val;

        private Node left;

        private Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * 宽度遍历
     *
     * @param head
     */
    public static void widthTraversal(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.val + " ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

}
