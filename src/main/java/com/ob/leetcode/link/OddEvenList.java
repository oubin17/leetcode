package com.ob.leetcode.link;

/**
 * OddEvenList
 * 奇数位置的凑在一起，偶数位置的凑在一起
 *
 * @Description: https://leetcode.cn/problems/odd-even-linked-list/
 * @CreateDate: 2022/9/24 17:27
 * @Version: 1.0
 * @Author: oubin
 */
public class OddEvenList {

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

    public static ListNode oddEvenList(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        head.next = new ListNode(2);
        ListNode listNode = oddEvenList(head);
        System.out.println("奇偶归类后：");
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }


}
