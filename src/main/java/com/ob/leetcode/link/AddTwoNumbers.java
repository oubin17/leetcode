package com.ob.leetcode.link;

/**
 * AddTwoNumbers:https://leetcode.cn/problems/add-two-numbers/
 *
 * @Description: 两数相加
 *
 * @CreateDate: 2022/9/18 15:56
 * @Version: 1.0
 * @Author: oubin
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;
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

    /**
     * 1.先找到长链表
     * 2.分情况：
     *  1.短链表为空，长链表不为空；
     *  2.长链表为空；
     *  3.进位不为空；
     *
     *  要保证每个循环都是等价的，可以给个默认值，这里的进位信息在第一次循环时是0，无进位
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int length1 = length(l1);
        int length2 = length(l2);
        ListNode l = length1 >= length2 ? l1 : l2;
        ListNode s = l == l1 ? l2 : l1;

        ListNode curL = l;
        ListNode curS = s;

        ListNode current = curL;

        int carry = 0;
        int currentNum;
        while (curS != null) {
            currentNum = curS.val + curL.val + carry;
            carry = currentNum / 10;
            curL.val = currentNum % 10;
            current = curL;
            curL = curL.next;
            curS = curS.next;
        }
        while (curL != null) {
            currentNum = curL.val + carry;
            carry = currentNum / 10;
            curL.val = currentNum % 10;
            current = curL;
            curL = curL.next;
        }
        if (carry != 0) {
            current.next = new ListNode(1);
        }
        return l;
    }

    public static int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length ++;
            head = head.next;
        }
        return length;
    }

    /**
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     * @param args
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l1 = addTwoNumbers(l1, l2);
        System.out.println("链表相加结果：");
        while (l1 != null) {
            System.out.print(l1.val + " ");
            l1 = l1.next;
        }

    }
}
