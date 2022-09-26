package com.ob.leetcode.link;

/**
 * DeleteNode
 * 链表中删除该节点
 *
 * @Description: https://leetcode.cn/problems/delete-node-in-a-linked-list/
 * @CreateDate: 2022/9/25 23:38
 * @Version: 1.0
 * @Author: oubin
 */
public class DeleteNode {

    public static class ListNode{
        private int val;

        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;

    }
}
