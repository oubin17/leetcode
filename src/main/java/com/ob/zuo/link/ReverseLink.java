package com.ob.zuo.link;

/**
 * ReverseLink
 *
 * @Description:
 * @CreateDate: 2022/8/25 22:30
 * @Version: 1.0
 * @Author: oubin
 */
public class ReverseLink {

    public static void main(String[] args) {


    }

    /**
     * 单链表
     * @param <T>
     */
    public static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T t) {
            this.value = t;
        }
    }

    public static class DoubleNode<T> {
        private T value;
        private DoubleNode<T> pre;
        private DoubleNode<T> next;

        public DoubleNode(T t) {
            this.value = t;
        }
    }

    /**
     * 反转双链表
     *
     * @param head
     * @param <T>
     * @return
     */
    public static <T> DoubleNode<T> reverseDoubleNode(DoubleNode<T> head) {
        DoubleNode<T> pre = null;
        DoubleNode<T> next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 反转链表
     *
     * @param head
     * @param <T>
     * @return
     */
    public static <T> Node<T> reverseNode(Node<T> head) {
        Node<T> next;
        Node<T> pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 测试反转链表
     */
    public static void testReverseNode() {
        Node<Integer> node = new Node<>(0);
        Node<Integer> pre = node;
        for (int i = 1; i < 10; i++) {
            pre.next = new Node<>(i);
            pre = pre.next;
        }
        System.out.println("原链表：");
//        while (node != null) {
//            System.out.println(node.value);
//            node = node.next;
//        }
        System.out.println("旋转后新链表：");
        Node<Integer> integerNode = reverseNode(node);
        while (integerNode != null) {
            System.out.println(integerNode.value);
            integerNode = integerNode.next;
        }
    }

}
