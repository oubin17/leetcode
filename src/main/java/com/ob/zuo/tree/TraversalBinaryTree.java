package com.ob.zuo.tree;

import java.util.Stack;

/**
 * TraversalBinaryTree: 遍历二叉树
 *
 * @Description:
 * @CreateDate: 2022/9/5 23:27
 * @Version: 1.0
 * @Author: oubin
 */
public class TraversalBinaryTree {

    public static class Node<T> {
        private final T value;

        private Node<T> left;

        private Node<T> right;

        public Node(T value) {
            this.value = value;
        }
    }

    /**
     * 先序遍历
     *
     * @param head
     */
    public static void pre(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    /**
     * 中序遍历
     *
     * @param head
     */
    public static void in(Node head) {
        if (head == null) {
            return;
        }
        in(head.left);
        System.out.println(head.value);
        in(head.right);
    }

    /**
     * 后序遍历
     *
     * @param head
     */
    public static void pos(Node head) {
        if (head == null) {
            return;
        }

        pos(head.left);
        pos(head.right);
        System.out.println(head.value);

    }

    /**
     * 不同的打印顺序，对应不同的遍历方式
     * 1.先序遍历
     * 2.中序遍历
     * 3.后序遍历
     *
     * @param head
     */
    public static void f(Node head) {
        if (head == null) {
            return;
        }
        //1
        f(head.left);
        //2
        f(head.right);
        //3
    }

    /**
     * 非递归先序遍历
     *
     * @param head
     */
    public static void preOrderUnRecur(Node<Integer> head) {
        System.out.println("pre-order: ");
        if (head != null) {
            Stack<Node<Integer>> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    /**
     * 非递归版本中序遍历
     *
     * @param head
     */
    public static void inOrderUnRecur(Node<Integer> head) {
        System.out.println("in-order: ");
        if (head != null) {
            Stack<Node<Integer>> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.value + "");
                    head = head.right;
                }
            }
        }
    }


    /**
     * 非递归版本的后续遍历
     *
     * @param head
     */
    public static void posOrderUnRecur(Node<Integer> head) {
        System.out.println("post-order: ");
        if (head != null) {
            Stack<Node<Integer>> s1 = new Stack<>();
            Stack<Node<Integer>> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.println(s2.pop().value + " ");
            }
        }
    }


    public static void main(String[] args) {

        Node<Integer> head = generateTree();

//        System.out.println("先序遍历：");
//        pre(head);
//        System.out.println("中序遍历：");
//        in(head);
        System.out.println("后序遍历");
        pos(head);

//        System.out.println("非递归，先序遍历");
//        preOrderUnRecur(head);
//        System.out.println("非递归，中序遍历");
//        inOrderUnRecur(head);
        System.out.println("非递归，后续遍历");
        posOrderUnRecur(head);


    }

    public static Node<Integer> generateTree() {
        Node<Integer> head = new Node<>(1);
        head.left = new Node<>(2);
        head.right = new Node<>(3);
        head.left.left = new Node<>(4);
        head.left.right = new Node<>(5);
        head.right.left = new Node<>(6);
        head.right.right = new Node<>(7);
        return head;
    }
}
