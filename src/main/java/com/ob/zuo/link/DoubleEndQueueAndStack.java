package com.ob.zuo.link;

/**
 * DoubleEndQueueAndStack
 *
 * @Description:
 * @CreateDate: 2022/9/3 15:11
 * @Version: 1.0
 * @Author: oubin
 */
public class DoubleEndQueueAndStack {

    public static class Node<T> {
        private T value;

        private Node<T> next;

        private Node<T> last;

        public Node(T t) {
            this.value = t;
        }


    }

    public static class DoubleEndQueue<T> {
        private Node<T> head;

        private Node<T> tail;

        public void addFromHead(T t) {
            Node<T> cur = new Node<>(t);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
        }

        public void addFromTail(T t) {
            Node<T> cur = new Node<>(t);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                cur.last = tail;
                tail = cur;
            }

        }

        public T popFromHead() {
            if (head == null) {
                return null;
            }
            Node<T> cur = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.last = null;
                cur.next = null;
            }
            return cur.value;
        }

        public T popFromTail() {
            if (head == null) {
                return null;
            }
            Node<T> cur = tail;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                tail.next = null;
                cur.last = null;
            }
            return cur.value;
        }
        public boolean isEmpty() {
            return head == null;
        }
    }

    public static class Queue<T> {
        private DoubleEndQueue<T> queue;

        public Queue() {
            this.queue = new DoubleEndQueue<>();
        }

        public void push(T t) {
            this.queue.addFromHead(t);
        }

        public T pop() {
            return this.queue.popFromTail();
        }

        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

    }

    public static class Stack<T> {
        private DoubleEndQueue<T> queue;

        public Stack() {
            this.queue = new DoubleEndQueue<>();
        }

        public void push(T t) {
            this.queue.addFromTail(t);
        }

        public T pop() {
            return this.queue.popFromTail();
        }

        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

    }

    public static void main(String[] args) {
        queueTest();
        stackTest();
    }

    public static void queueTest() {
        Queue<Integer> queue = new Queue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

    public static void stackTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
