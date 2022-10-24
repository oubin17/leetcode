package com.ob.leetcode.link;

import java.util.HashMap;

/**
 * LRUCache
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 *
 * @Description: https://leetcode.cn/problems/lru-cache/description/
 * @CreateDate: 2022/10/24 21:24
 * @Version: 1.0
 * @Author: oubin
 */
public class LRUCacheDoubleLink {

    private int capacity;

    private int current;

    private ListNode head;

    private ListNode tail;

    private HashMap<Integer, ListNode> hashMap;

    public static class ListNode {
        private int key;
        private int value;
        private ListNode next;
        private ListNode pre;

    }

    public LRUCacheDoubleLink(int capacity) {
        this.capacity = capacity;
        this.current = 0;
        this.hashMap = new HashMap<>();
        this.head = new ListNode();
        this.tail = new ListNode();
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }



    public int get(int key) {
        ListNode listNode = hashMap.get(key);
        if (listNode == null) {
            return -1;
        } else {
            removeNode(listNode);
            addToFirst(listNode);
            return listNode.value;
        }
    }

    public void put(int key, int value) {

        ListNode listNode = hashMap.get(key);
        if (listNode != null) {
            listNode.value = value;
            removeNode(listNode);
            addToFirst(listNode);
        } else if (current < capacity) {
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;
            hashMap.put(key, newNode);
            addToFirst(newNode);
            current++;
            //添加到首位，计数+1
        } else {
            //去除最后一个，添加到首位
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;
            hashMap.put(key, newNode);
            hashMap.remove(tail.pre.key);
            removeNode(tail.pre);
            addToFirst(newNode);
        }

    }
    public void addToFirst(ListNode node) {
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }
    public void removeNode(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public static void main(String[] args) {
        LRUCacheDoubleLink cache = new LRUCacheDoubleLink(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        cache.put(5, 5);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
    }

    public void put2(int key, int value) {

        ListNode listNode = hashMap.get(key);
        if (listNode != null) {
            listNode.value = value;
            removeNode(listNode);
            addToFirst(listNode);
        } else {
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;
            hashMap.put(key, newNode);
            if (current < capacity) {
                addToFirst(newNode);
                current++;
            } else {
                hashMap.remove(tail.pre.key);
                removeNode(tail.pre);
                addToFirst(newNode);
            }
        }

    }
}
