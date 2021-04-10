package com.test.database.translate.基础;

public class DoubleNode {
    private Node root = new Node(-1);
    private Node after = this.root;
    private int N = 0;

    private class Node {
        private Node first;
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public void offer(int val) {
        Node node = new Node(val);
        if (this.root.next == null) {
            Node next = this.root.next;
            node.first = this.root;
            node.next = next;
            this.root.next = node;
            this.after = node;
        } else {
            Node next = this.root.next;
            this.root.next = node;
            node.first = this.root;
            node.next = next;
            next.first = node;
        }
        this.N++;
    }

    public void push(int val) {
        Node node = new Node(val);
        if (this.after.next == null) {
            this.after.next = node;
            node.first = this.after;
            this.after = node;
        } else {
            this.after.next = node;
            node.first = this.after;
            this.after = this.after.next;
        }
        this.N++;
    }

    public Node removeFirst() {
        if (this.root == this.after) {
            return null;
        }
        Node next = this.root.next;
        this.root.next = next.next;
        if (next.next != null) {
            next.next.first = this.root;
        }
        if (next == this.after) {
            this.after = root;
        }
        this.N--;
        return next;
    }

    public Node removeLast() {
        if (this.after == this.root) {
            return null;
        }
        Node next = this.after;
        if (next == this.root.next) {
            this.after = this.root;
            this.root.next = null;
        } else {
            this.after = next.first;
        }
        this.N--;
        return next;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public static void main(String[] args) {
        DoubleNode doubleNode = new DoubleNode();
        // 向队列头部添加元素
        doubleNode.offer(1);
        doubleNode.offer(2);
        // 向队列头部尾部元素
        doubleNode.push(3);
        doubleNode.push(4);
//        System.out.println(doubleNode.removeFirst().val);
//        System.out.println(doubleNode.removeLast().val);
//        System.out.println(doubleNode.removeFirst().val);
//        System.out.println(doubleNode.removeLast().val);
//        System.out.println(doubleNode.removeFirst());
//        System.out.println(doubleNode.removeLast());
//        while (!doubleNode.isEmpty()) {
//            System.out.println(doubleNode.removeFirst().val);
//        }
        while (!doubleNode.isEmpty()) {
            System.out.println(doubleNode.removeLast().val);
        }
    }
}
