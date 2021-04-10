package com.test.database.translate.基础;

/**
 * 环形队列（数组实现）
 */
public class RingBuffer<T> {
    private T[] elementData;
    private int size;
    private int start;
    private int end;

    public RingBuffer(int cap) {
        this.elementData = (T[]) new Object[cap];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void insert(T t) {
        if (this.size == this.elementData.length || this.elementData[start] != null) {
            throw new RuntimeException("环形队列已满");
        }
        this.elementData[start++] = t;
        this.size++;
        if (this.start == this.elementData.length) {
            this.start = 0;
        }
    }

    public T push() {
        if (this.elementData[this.end] == null) {
            throw new RuntimeException("环形队列已空");
        }
        T elementDatum = this.elementData[end];
        this.elementData[end++] = null;
        this.size--;
        if (this.end == this.elementData.length) {
            this.end = 0;
        }
        return elementDatum;
    }

    public static void main(String[] args) {
        RingBuffer<Integer> integerRingBUffer = new RingBuffer<Integer>(3);
        integerRingBUffer.insert(1);
        integerRingBUffer.insert(2);
        integerRingBUffer.insert(3);
        System.out.println(integerRingBUffer.push());
        integerRingBUffer.insert(4);
        System.out.println(integerRingBUffer.push());
        System.out.println(integerRingBUffer.push());
        System.out.println();
    }
}
