package com.test.database.translate.基础;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class Node {
        private Node next;
        private T val;

        public Node(T val) {
            this.val = val;
        }

        public Node() {
        }
    }

    private Node root;
    private int size;

    public Stack() {
        this.root = new Node();
    }

    private class StackIterator implements Iterator<T> {

        private Node start = Stack.this.root;

        @Override
        public boolean hasNext() {
            return start.next != null;
        }

        @Override
        public T next() {
            start = start.next;
            return start.val;
        }
    }

    public void push(T t) {
        Node newNode = new Node(t);
        if (root.next == null) {
            root.next = newNode;
        } else {
            newNode.next = root.next;
            root.next = newNode;
        }
        this.size++;
    }

    public T pop() {
        if (root.next == null) {
            return null;
        }
        T val = root.next.val;
        root.next = root.next.next;
        this.size--;
        return val;
    }

    public boolean isEmpty() {
        return root.next == null;
    }

    public int size() {
        return this.size;
    }

    public T peek() {
        return root.next != null ? root.next.val : null;
    }

    // 1.3.12
    public Stack<T> copyOf(Stack<T> stack) {
        for (T t : this) {
            stack.push(t);
        }
        return stack;
    }

    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        Stack<Integer> integers = integerStack.copyOf(new Stack<>());
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println(integerStack.pop());
        System.out.println(integerStack.peek());
        System.out.println(integerStack.size);
        System.out.println(integerStack.pop());
        System.out.println(integerStack.pop());
        System.out.println(integerStack.isEmpty());
    }
}
