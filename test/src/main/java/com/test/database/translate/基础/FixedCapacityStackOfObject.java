package com.test.database.translate.基础;

import java.util.Arrays;
import java.util.Iterator;

public class FixedCapacityStackOfObject<T> implements Iterable<T> {
    private T[] objects;
    private int index = 0;

    public FixedCapacityStackOfObject(int cap) {
        this.objects = (T[]) new Object[cap];
    }

    public void push(T item) {
        if (this.index == this.objects.length / 2) {
            objects = Arrays.copyOf(this.objects, objects.length * 2);
        }
        this.objects[index++] = item;
    }

    public T pop() {
        if (this.index > 0) {
            T object = this.objects[--index];
            this.objects[index] = null;
            if (this.index == this.objects.length / 4) {
                objects = Arrays.copyOf(this.objects, objects.length / 2);
            }
            return object;
        }
        return null;
    }

    public boolean isEmpty() {
        return this.index == 0;
    }

    public int size() {
        return this.index;
    }

    public int cap() {
        return this.objects.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new InnerIterator();
    }

    private class InnerIterator implements Iterator<T> {
        private int N = FixedCapacityStackOfObject.this.index;

        @Override
        public boolean hasNext() {
            return N > 0;
        }

        @Override
        public T next() {
            return FixedCapacityStackOfObject.this.objects[--N];
        }
    }

    public static void main(String[] args) {
        FixedCapacityStackOfObject<Integer> integerFixedCapacityStackOfObject = new FixedCapacityStackOfObject<>(1);
        integerFixedCapacityStackOfObject.push(1);
        integerFixedCapacityStackOfObject.push(1);
        integerFixedCapacityStackOfObject.push(1);
        integerFixedCapacityStackOfObject.push(1);
        for (Integer integer : integerFixedCapacityStackOfObject) {
            System.out.println(integer);
        }
//        System.out.println(integerFixedCapacityStackOfObject.cap());
//        System.out.println(integerFixedCapacityStackOfObject.pop());
//        System.out.println(integerFixedCapacityStackOfObject.cap());
    }
}
