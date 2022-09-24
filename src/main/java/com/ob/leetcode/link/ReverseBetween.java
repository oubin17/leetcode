package com.ob.leetcode.link;

import java.util.Stack;

/**
 * ReverseBetween
 *
 * @Description:
 * @CreateDate: 2022/9/24 12:36
 * @Version: 1.0
 * @Author: oubin
 */
public class ReverseBetween {

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

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = pre;
        Stack<ListNode> stack = new Stack<>();
        ListNode startNode = pre;

        int index = 0;
        while (cur != null && index <= right) {
            if (index >= left) {
                stack.push(cur);
            } else {
                startNode = cur;
            }
            cur = cur.next;
            index ++;
        }
        while (!stack.isEmpty()) {
            startNode.next = stack.pop();
            startNode = startNode.next;
        }
        startNode.next = cur;
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        ListNode listNode = reverseBetween(head, 1, 1);
        System.out.println("旋转后：");
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }


    }
}
