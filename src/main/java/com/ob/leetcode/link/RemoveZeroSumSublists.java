package com.ob.leetcode.link;

/**
 * RemoveZeroSumSublists
 * 给你一个链表的头节点head，请你编写代码，反复删去链表中由 总和值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 *
 * 删除完毕后，请你返回最终结果链表的头节点。
 *
 *
 * @Description: https://leetcode.cn/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 * @CreateDate: 2022/9/26 20:29
 * @Version: 1.0
 * @Author: oubin
 */
public class RemoveZeroSumSublists {

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

    public static ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) return null;
        int sum = 0;
        //以head作为开头，是否存在一段以head开头的和为0的连续节点，如果存在的话，删去这段节点
        for (ListNode tmp = head; tmp != null; tmp = tmp.next) {
            sum += tmp.val;
            if (sum == 0) { //说明当前从head到tmp的节点之和为0 ，这段节点都需要移除
                return removeZeroSumSublists(tmp.next);
            }
        }
        //能到达这里说明不存在从head开始的一段和为0的连续节点，那么从head next开始
        head.next = removeZeroSumSublists(head.next);
        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-1);
        head.next.next.next = new ListNode(3);
        removeZeroSumSublists(head);

    }
}
