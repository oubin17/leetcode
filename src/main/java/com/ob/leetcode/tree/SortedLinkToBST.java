package com.ob.leetcode.tree;

import java.util.HashMap;

/**
 * 给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。
 *
 * @Description: https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/
 * @CreateDate: 2022/11/6 11:42
 * @Version: 1.0
 * @Author: oubin
 */
public class SortedLinkToBST {

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

    public static class TreeNode {
        private int val;

        private TreeNode left;

        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 用一个数组存储链表和链表下表
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int listLength = 0;
        HashMap<Integer, Integer> indexValueMap = new HashMap<>();
        while (head != null) {
            indexValueMap.put(listLength++, head.val);
            head = head.next;
        }
        return sortedListToBST(indexValueMap, 0, listLength - 1);
    }

    private TreeNode sortedListToBST(HashMap<Integer, Integer> indexValueMap, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(indexValueMap.get(mid));
        root.left = sortedListToBST(indexValueMap, left, mid - 1);
        root.right = sortedListToBST(indexValueMap, mid + 1, right);
        return root;
    }

    /**
     * 快慢指针法，不需要额外空间
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST2(ListNode head) {
        if(head == null){
            return null;
        }
        return helper(head,null);
    }
    private TreeNode helper(ListNode head,ListNode tail){
        if(head == tail){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head,slow);
        root.right = helper(slow.next,tail);
        return root;
    }


    public static void main(String[] args) {
        SortedLinkToBST sortedLinkToBST = new SortedLinkToBST();
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        TreeNode treeNode = sortedLinkToBST.sortedListToBST(head);
        System.out.println(treeNode.val);

    }
}
