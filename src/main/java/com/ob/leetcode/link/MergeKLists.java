package com.ob.leetcode.link;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * MergeKLists
 * k链表合并问题
 * 使用最小堆优先队列
 *
 * @Description: https://leetcode.cn/problems/merge-k-sorted-lists/comments/
 * @CreateDate: 2022/9/20 23:34
 * @Version: 1.0
 * @Author: oubin
 */
public class MergeKLists {

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

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.add(listNode);
            }
        }
        ListNode cur = new ListNode(-1);
        ListNode head = cur;
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            cur.next = poll;
            cur = cur.next;
            if (poll.next != null) {
                queue.add(poll.next);
            }

        }
        return head.next;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(0);
        l2.next = new ListNode(2);
        ListNode listNode = mergeKLists(new ListNode[]{l1, l2});
        System.out.println("合并后结果：");
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
