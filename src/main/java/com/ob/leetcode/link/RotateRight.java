package com.ob.leetcode.link;

/**
 * RotateRight
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * @Description: https://leetcode.cn/problems/rotate-list/
 * @CreateDate: 2022/9/21 22:31
 * @Version: 1.0
 * @Author: oubin
 */
public class RotateRight {

    public static class ListNode {
        private int val;
        private ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = length(head);
        int rotate = k % length;
        if (rotate == 0) {
            return head;
        }
        ListNode nthLastNode = nthLastNode(head, rotate, length);
        ListNode newHead = nthLastNode.next;
        ListNode cur = newHead;
        nthLastNode.next = null;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;

        return newHead;

    }

    public static ListNode nthLastNode(ListNode head, int n, int length) {
        ListNode cur = head;
        if (n == length - 1) {
            return head;
        }
        int i = 0;
        while (i < length - n - 1) {
            cur = cur.next;
            i++;
        }

        return cur;
    }

    public static int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length ++;
            head = head.next;
        }
        return length;
    }

    public static ListNode rotateRight2(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        ListNode newListNode = rotateRight2(listNode, 4);
        System.out.println("旋转k个：");
        while (newListNode != null) {
            System.out.print(newListNode.val + " ");
            newListNode = newListNode.next;
        }
    }

}
