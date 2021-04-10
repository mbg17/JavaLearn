package com.test.database.translate.基础;

import java.util.Iterator;

public class Deque<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    private class Node {
        private Node next;
        private Node pre;
        private T val;

        public Node(T val) {
            this.val = val;
        }
    }

    private Node left;
    private Node right;
    private int size;

    public int size() {
        return this.size;
    }

    public void pushLeft(T t) {
        if (this.left == null) {
            this.left = new Node(t);
            this.right = this.left;
        } else {
            Node node = new Node(t);
            node.next = this.left;
            this.left.pre = node;
            this.left = node;
        }
        this.size++;
    }

    public void pushRight(T t) {
        if (this.right == null) {
            this.right = new Node(t);
            this.left = this.right;
        } else {
            Node node = new Node(t);
            this.right.next = node;
            node.pre = this.right;
            this.right = node;
        }
        this.size++;
    }

    public T popLeft() {
        if (this.left == null) {
            return null;
        }
        Node left = this.left;
        this.left = this.left.next;
        if (this.left != null) {
            this.left.pre = null;
        }
        if (left == this.right) {
            this.right = this.left;
        }
        this.size--;
        return left.val;
    }

    public T popRight() {
        if (this.right == null) {
            return null;
        }
        Node right = this.right;
        this.right = right.pre;
        if (right == this.left) {
            this.left = this.right;
        }
        this.size--;
        return right.val;
    }

    private class DequeIterator implements Iterator<T> {
        private Node start = Deque.this.left;

        @Override
        public boolean hasNext() {
            return start != null;
        }

        @Override
        public T next() {
            T val = start.val;
            start = start.next;
            return val;
        }
    }

    public static void main(String[] args) {
        Deque<Integer> integers = new Deque<>();
        integers.pushLeft(1);
        integers.pushRight(2);
        integers.pushLeft(3);
        integers.pushRight(4);
//        for (Integer integer : integers) {
//            System.out.println(integer);
//        }
        while (integers.size > 0) {
            System.out.println(integers.popRight());
        }
        System.out.println();
    }
}
