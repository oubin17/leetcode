package com.ob.leetcode.link;

import java.util.ArrayList;
import java.util.List;

/**
 * ListPartition
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-list
 *
 * @Description: https://leetcode.cn/problems/partition-list/
 * @CreateDate: 2022/9/24 11:20
 * @Version: 1.0
 * @Author: oubin
 */
public class ListPartition {

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

    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        List<ListNode> lessNodes = new ArrayList<>();
        List<ListNode> greaterEqualNodes = new ArrayList<>();
        while (head != null) {
            if (head.val < x) {
                lessNodes.add(head);
            } else {
                greaterEqualNodes.add(head);
            }
            head = head.next;
        }

        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        while (!lessNodes.isEmpty()) {
            ListNode remove = lessNodes.remove(0);
            remove.next = null;
            cur.next = remove;
            cur = cur.next;
        }
        while (!greaterEqualNodes.isEmpty()) {
            ListNode remove = greaterEqualNodes.remove(0);
            remove.next = null;
            cur.next = remove;
            cur = cur.next;
        }
        return pre.next;
    }

    /**
     * 维护两个链表
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition2(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        node.next = new ListNode(1);
        ListNode partition = partition(node, 2);
        System.out.println("分区后结果：");
        while (partition != null) {
            System.out.print(partition.val + " ");
            partition = partition.next;
        }
    }

}
