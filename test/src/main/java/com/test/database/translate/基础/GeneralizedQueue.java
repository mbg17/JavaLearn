package com.test.database.translate.基础;

import lombok.val;

public class GeneralizedQueue<T> {
    private class Node {
        private T val;
        private Node next;
        private int size;

        public Node(T val) {
            this.val = val;
        }

        public Node() {

        }
    }

    private Node root;
    private int size;

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(T t) {
        Node node = new Node(t);
        if (this.root == null) {
            this.root = node;
        } else {
            Node pre = this.root;
            while (pre != null && pre.next != null) {
                pre = pre.next;
            }
            pre.next = node;
        }
        this.size++;
    }

    public T delete(int k) {
        if (k > this.size) {
            return null;
        }
        Node node = new Node();
        node.next = this.root;
        int index = 0;
        while (index < k - 1) {
            node = node.next;
            index++;
        }
        Node next = node.next;
        if (next == this.root) {
            this.root = next.next;
        }
        node.next = next.next;
        this.size--;
        return next.val;
    }

    public static void main(String[] args) {
        GeneralizedQueue<Integer> integerGeneralizedQueue = new GeneralizedQueue<>();
        integerGeneralizedQueue.insert(1);
        integerGeneralizedQueue.insert(2);
        integerGeneralizedQueue.insert(3);
        System.out.println(integerGeneralizedQueue.delete(1));
        System.out.println(integerGeneralizedQueue.delete(1));
        System.out.println(integerGeneralizedQueue.delete(1));
        System.out.println(integerGeneralizedQueue.delete(1));
        System.out.println();
    }
}
