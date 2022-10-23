package com.ob.leetcode.link;

import java.util.HashMap;
import java.util.Objects;
import java.util.TreeSet;

/**
 * LRUCache
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 *
 * @Description: https://leetcode.cn/problems/lru-cache/description/
 * @CreateDate: 2022/10/23 21:24
 * @Version: 1.0
 * @Author: oubin
 */
public class LRUCache {

    private int capacity;

    private int currentSize;

    private int action;

    private HashMap<Integer, ListNode> hashMap;

    private TreeSet<ListNode> treeSet;

    public static class ListNode implements Comparable<ListNode> {
        int key;
        int value;
        int action;

        public ListNode() {

        }
        public ListNode(int key, int value, int action) {
            this.key = key;
            this.value = value;
            this.action = action;

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return key == listNode.key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, action);
        }

        @Override
        public int compareTo(ListNode o) {
            return this.action - o.action;
//            if (this.action == o.action) {
//                return 0;
//            } else if (this.action > o.action) {
//                return -1;
//            } else {
//                return 1;
//            }

        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
        this.action = 0;
        this.hashMap = new HashMap<>();
        this.treeSet = new TreeSet<>();

    }

    public int get(int key) {
        ListNode listNode = hashMap.get(key);
        if (listNode == null) {
            return -1;
        }
        treeSet.remove(listNode);
        listNode.action = ++action;
        treeSet.add(listNode);
        hashMap.put(key, listNode);
        return listNode.value;
    }

    public void put(int key, int value) {
        ListNode listNode = hashMap.get(key);
        if (listNode != null) {
            //存在
            treeSet.remove(listNode);
            listNode.value = value;
            listNode.action = ++ action;
            hashMap.put(key, listNode);
            treeSet.add(listNode);
        } else {
            //不存在
            ListNode addNode = new ListNode(key, value, ++action);
            hashMap.put(key, addNode);
            if (currentSize < capacity) {
                treeSet.remove(addNode);
                treeSet.add(addNode);
                currentSize++;
            } else if (currentSize == capacity) {
                ListNode removeNode = treeSet.pollFirst();
                hashMap.remove(removeNode.key);
                treeSet.remove(addNode);
                treeSet.add(addNode);
            }
        }

    }


    /**
     * 输入
     ["LRUCache","put","put","put","put","get","get"]
     [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
     * @param args
     */
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
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

}
