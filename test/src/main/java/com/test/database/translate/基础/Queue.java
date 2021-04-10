package com.test.database.translate.基础;

import com.test.database.translate.std.In;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int N;

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class Node {
        private T val;
        private Node next;

        public Node() {
            this.next = null;
        }

        public Node(T val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public Queue() {
        this.first = null;
        this.last = null;
        this.N = 0;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int size() {
        return this.N;
    }

    public void enqueue(T t) {
        if (this.last == null) {
            this.first = new Node(t, null);
            this.last = this.first;
        } else {
            this.last.next = new Node(t, null);
            this.last = this.last.next;
        }
        this.N++;
    }

    public T dequeue() {
        Node node = null;
        if (this.first == null) {
            return null;
        } else {
            if (this.first == this.last) {
                node = this.first;
                this.first = null;
                this.last = null;
            } else {
                node = this.first;
                this.first = this.first.next;
            }
        }
        this.N--;
        return node.val;
    }

    private class QueueIterator implements Iterator<T> {

        private Node first = Queue.this.first;

        @Override
        public boolean hasNext() {
            return first != null;
        }

        @Override
        public T next() {
            T val = first.val;
            first = first.next;
            return val;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> integers = new Queue<>();
        integers.enqueue(1);
        integers.enqueue(2);
        integers.enqueue(3);
        integers.enqueue(4);
        System.out.println(integers.getK(3));
        while (!integers.isEmpty()) {
            System.out.println(integers.dequeue());
        }
    }

    public T getK(int k) {
        if (this.N < k) {
            return null;
        }
        Node pre = this.first;
        for (int i = 0; i < this.N - k; i++) {
            pre = pre.next;
        }
        return pre == null ? null : pre.val;
    }
}
