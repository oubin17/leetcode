package com.ob.leetcode.link;

/**
 * DeleteDuplicates
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表
 *
 * @Description: https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 * @CreateDate: 2022/9/24 09:42
 * @Version: 1.0
 * @Author: oubin
 */
public class DeleteDuplicates {

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

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        boolean flag = pre.val == head.val;

        pre.next = head;
       while (head != null) {
           if (head.val == pre.val) {
               pre.next = head.next;
           } else {
               pre = head;
           }
           head = head.next;
       }
        return flag ? cur : cur.next;

    }

    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            if(cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
//        head.next.next.next = new ListNode(3);
//        head.next.next.next.next = new ListNode(3);
        ListNode listNode = deleteDuplicates(head);
        System.out.println("删除重复元素后：");
        while (listNode != null) {
            System.out.println(listNode.val + " ");
            listNode = listNode.next;
        }
    }

}
