package com.test.database.translate.基础;

import java.util.Iterator;

/**
 * 1.3.32
 */
public class Steque<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new StequeIterator();
    }

    private class Node {

        private T val;
        private Node next;

        public Node(T val) {
            this.val = val;
        }


    }

    private int size;
    private Node last;
    private Node root;

    // 队列
    public void enqueue(T t) {
        if (this.last == null) {
            this.last = new Node(t);
            this.root = this.last;
        } else {
            this.last.next = new Node(t);
            this.last = this.last.next;
        }
        this.size++;
    }

    // 栈
    public void push(T t) {
        if (this.root == null) {
            this.root = new Node(t);
            this.last = this.root;
        } else {
            Node node = new Node(t);
            node.next = this.root;
            this.root = node;
        }
        this.size++;
    }

    public T pop() {
        if (this.root == null) {
            return null;
        }
        Node root = this.root;
        this.root = this.root.next;
        if (this.last == root) {
            this.last = this.root;
        }
        this.size--;
        return root.val;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private class StequeIterator implements Iterator<T> {
        private Node start = Steque.this.root;

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
        Steque<Integer> integers = new Steque<>();
        integers.push(1);
        integers.push(2);
        integers.push(3);
        integers.enqueue(4);
        integers.enqueue(5);
//        for (Integer integer : integers) {
//            System.out.println(integer);
//        }
        while (!integers.isEmpty()) {
            System.out.println(integers.pop());
        }
        System.out.println();
    }
}
