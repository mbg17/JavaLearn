package com.test.database.translate.基础;

import java.util.Iterator;

public class ResizingArrayDeque<T> implements Iterable<T> {
    private T[] elementData;
    private int size;

    public ResizingArrayDeque(int cap) {
        if (cap <= 0) {
            throw new RuntimeException("长度不能为0");
        }
        this.elementData = (T[]) new Object[cap];
    }

    public int size() {
        return this.size;
    }

    public boolean pushLeft(T t) {
        copyArray();
        for (int i = this.size; i > 0; i--) {
            this.elementData[i] = this.elementData[i - 1];
        }
        this.size++;
        this.elementData[0] = t;
        return true;
    }

    public boolean pushRight(T t) {
        copyArray();
        this.elementData[this.size++] = t;
        return true;
    }

    public void copyArray() {
        T[] objects;
        if (this.size == this.elementData.length) {
            objects = (T[]) new Object[this.elementData.length * 2];
            for (int i = 0; i < this.elementData.length; i++) {
                objects[i] = this.elementData[i];
            }
            this.elementData = objects;
        }
    }

    public void delArray() {
        T[] objects;
        if (this.size == this.elementData.length / 4 && this.elementData.length >= 2) {
            objects = (T[]) new Object[this.elementData.length / 2];
            for (int i = 0; i < this.size; i++) {
                objects[i] = this.elementData[i];
            }
            this.elementData = objects;
        }
    }

    public T popLeft() {
        delArray();
        T elementDatum = this.elementData[0];
        for (int i = 0; i < this.size - 1; i++) {
            this.elementData[i] = this.elementData[i + 1];
        }
        if (this.size > 0) {
            this.elementData[--this.size] = null;
        }
        return elementDatum;
    }

    public T popRight() {
        delArray();
        if (this.size > 0) {
            T elementDatum = this.elementData[--this.size];
            this.elementData[this.size] = null;
            return elementDatum;
        } else {
            return null;
        }
    }

    public int getCap() {
        return this.elementData.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new ResizingArrayDequeIterator();
    }

    private class ResizingArrayDequeIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < ResizingArrayDeque.this.size;
        }

        @Override
        public T next() {
            T elementDatum = ResizingArrayDeque.this.elementData[index++];
            return elementDatum;
        }
    }

    public static void main(String[] args) {
        ResizingArrayDeque<Integer> integerResizingArrayDeque = new ResizingArrayDeque<Integer>(2);
        integerResizingArrayDeque.pushLeft(1);
        integerResizingArrayDeque.pushRight(3);
        integerResizingArrayDeque.pushRight(4);
        integerResizingArrayDeque.pushLeft(2);
        for (Integer integer : integerResizingArrayDeque) {
            System.out.println(integer);
        }
        System.out.println(integerResizingArrayDeque.popRight());
        System.out.println(integerResizingArrayDeque.popLeft());
        System.out.println(integerResizingArrayDeque.popRight());
        System.out.println(integerResizingArrayDeque.popRight());
        System.out.println(integerResizingArrayDeque.getCap());
        System.out.println(integerResizingArrayDeque.popLeft());
        System.out.println(integerResizingArrayDeque.popLeft());
    }
}
