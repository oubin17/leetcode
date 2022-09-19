package com.ob.leetcode.link;

/**
 * MergeTwoLists
 *
 * @Description:
 * @CreateDate: 2022/9/19 21:34
 * @Version: 1.0
 * @Author: oubin
 */
public class MergeTwoLists {

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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode cur = new ListNode(-1);
        ListNode head = cur;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            } else {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            cur.next = list2;
        } else {
            cur.next = list1;
        }
        return head.next;
    }

    /**
     * 递归写法
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res = l1.val < l2.val ? l1 : l2;
        res.next = mergeTwoListsRecursion(res.next, l1.val >= l2.val ? l1 : l2);
        return res;
    }


    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        ListNode listNode = mergeTwoLists(list1, list2);

        System.out.println("合并结果：");
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println("end");
        while (list1 != null) {
            System.out.println(list1.val + " ");
            list1 = list1.next;
        }
    }
}
