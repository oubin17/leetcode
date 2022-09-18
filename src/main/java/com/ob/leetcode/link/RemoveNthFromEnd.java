package com.ob.leetcode.link;


/**
 * RemoveNthFromEnd : https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * 删除链表倒数第n个节点
 *
 * @Description:
 * @CreateDate: 2022/9/18 18:44
 * @Version: 1.0
 * @Author: oubin
 */
public class RemoveNthFromEnd {

    public static class ListNode {

        private int val;

        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        ListNode current = slow;
        while (fast != null) {
            fast = fast.next;
            current = slow;
            slow = slow.next;
        }
        current.next = slow.next;
        if (current == head && slow == head) {
           head = current.next;
        }

        return head;
    }

    /**
     * leetcode解法
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        while(n != 0) {
            start = start.next;
            n--;
        }
        while(start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = removeNthFromEnd(head, 2);
        System.out.println("遍历链表");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();

    }

}
