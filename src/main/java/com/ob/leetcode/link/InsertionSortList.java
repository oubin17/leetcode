package com.ob.leetcode.link;

/**
 * InsertionSortList
 * 给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
 *
 * @Description:https://leetcode.cn/problems/insertion-sort-list/comments/
 * @CreateDate: 2022/9/27 22:45
 * @Version: 1.0
 * @Author: oubin
 */
public class InsertionSortList {

    public static class ListNode {
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

    public static ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1, head);
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {

            if (pre.val <= cur.val) {
                pre = cur;
                cur = cur.next;
                continue;
            }
            ListNode beforePre = pre;
            pre = cur;
            cur = cur.next;
            ListNode subNode = dummyNode;
            for (ListNode node = dummyNode.next; node != pre; node = node.next) {
                if (node.val < pre.val) {
                    subNode = node;
                } else {
                    beforePre.next = cur;
                    subNode.next = pre;
                    pre.next = node;
                    pre = beforePre;
                    break;
                }
            }
        }
        return dummyNode.next;

    }

    /**
     * 想要排序块，就要尽可能少的做比较
     * 需要一个指针指向当前已排序的最后一个位置，这里用的是head指针
     * 需要另外一个指针pre,每次从表头循环，这里用的是dummy表头指针。
     * 每次拿出未排序的节点，先和前驱比较，如果大于或者等于前驱，就不用排序了，直接进入下一次循环
     * 如果前驱小，则进入内层循环，依次和pre指针比较，插入对应位置即可。
     * @param head
     * @return
     */
    public static ListNode insertionSortList2(ListNode head) {
        ListNode dummy = new ListNode(0), pre;
        dummy.next = head;

        while(head != null && head.next != null) {
            if(head.val <= head.next.val) {
                head = head.next;
                continue;
            }
            pre = dummy;

            while (pre.next.val < head.next.val) pre = pre.next;

            ListNode curr = head.next;
            head.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        ListNode listNode = insertionSortList(head);
        System.out.println("排序后：");
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
