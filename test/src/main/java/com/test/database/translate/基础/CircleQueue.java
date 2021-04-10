package com.test.database.translate.基础;

import java.util.Iterator;

/**
 * 1.3.29
 */
public class CircleQueue<T> implements Iterable<T> {

    public static void main(String[] args) {
        CircleQueue<Integer> integers = new CircleQueue<>();
        integers.enqueue(1);
        integers.enqueue(2);
        integers.enqueue(3);
        while (!integers.isEmpty()) {
            System.out.println(integers.dequeue().val);
        }
        System.out.println(integers.size());
    }

    @Override
    public Iterator iterator() {
        return new CircleQueueIterator();
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

    private Node first;
    private Node last;
    private int N;

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int size() {
        return this.N;
    }

    public void enqueue(T t) {
        if (this.first == null && this.last == null) {
            Node node = new Node(t, null);
            this.first = node;
            this.last = node;
            this.first.next = this.last;
            this.last.next = this.first;
        } else {
            Node node = new Node(t, this.first);
            this.last.next = node;
            this.last = this.last.next;
        }
        this.N++;
    }

    public Node dequeue() {
        if (this.N == 0) {
            return null;
        }
        Node node = null;
        if (this.first == this.last) {
            Node first = this.first;
            this.first = null;
            this.last = null;
            node = first;
        } else {
            node = this.first;
            this.first = this.first.next;
            this.last.next = this.first;
        }
        this.N--;
        return node;
    }

    private class CircleQueueIterator implements Iterator<T> {
        private Node start = CircleQueue.this.first;
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < CircleQueue.this.N;
        }

        @Override
        public T next() {
            T val = start.val;
            start = start.next;
            index++;
            return val;
        }
    }
}
