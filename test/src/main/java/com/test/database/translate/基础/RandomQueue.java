package com.test.database.translate.基础;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class RandomQueue<T> implements Iterable<T> {
    private T[] elementData;
    private int size;

    public RandomQueue(int cap) {
        this.elementData = (T[]) new Object[cap];
    }

    public void enqueue(T t) {
        if (this.size == this.elementData.length) {
            this.elementData = Arrays.copyOf(this.elementData, this.size * 2);
        } else if (this.size == this.elementData.length / 4 && this.elementData.length > 8) {
            this.elementData = Arrays.copyOf(this.elementData, this.size * 2);
        }
        this.elementData[size++] = t;
    }

    public T dequeue() {
        if (this.size < 0) {
            return null;
        }
        Random random = new Random();
        int i = random.nextInt(this.size);
        T elementDatum = this.elementData[i];
        for (int j = i; j < this.size - 1; j++) {
            this.elementData[j] = this.elementData[j + 1];
        }
        this.elementData[--this.size] = null;
        return elementDatum;
    }

    public T sample() {
        if (this.size < 0) {
            return null;
        }
        Random random = new Random();
        int i = random.nextInt(this.size);
        return this.elementData[i];
    }

    @Override
    public Iterator<T> iterator() {
        return new RandomQueueIteator();
    }

    private class RandomQueueIteator implements Iterator<T> {
        private T[] innerElement = RandomQueue.this.elementData;
        private int start = 0;
        private int end = RandomQueue.this.size;

        public RandomQueueIteator() {
            int innerEnd = end;
            int innerBegin = 0;
            Random random = new Random();
            while (innerEnd > 0) {
                int i = random.nextInt(innerEnd);
                T temp = innerElement[i];
                this.innerElement[i] = this.innerElement[innerBegin];
                this.innerElement[innerBegin++] = temp;
                innerEnd--;
            }
        }

        @Override
        public boolean hasNext() {
            return start < end;
        }

        @Override
        public T next() {
            return innerElement[start++];
        }
    }

    public static void main(String[] args) {
        RandomQueue<Integer> integerRandomQueue = new RandomQueue<Integer>(4);
//        integerRandomQueue.enqueue(1);
//        integerRandomQueue.enqueue(2);
//        integerRandomQueue.enqueue(3);
//        integerRandomQueue.enqueue(4);
//        integerRandomQueue.enqueue(5);
////        for (int i = 0; i < 5; i++) {
////            System.out.println(integerRandomQueue.sample());
////        }
//        for (int i = 0; i < 5; i++) {
//            System.out.println(integerRandomQueue.dequeue());
//        }
        integerRandomQueue.enqueue(1);
        integerRandomQueue.enqueue(2);
        integerRandomQueue.enqueue(3);
        integerRandomQueue.enqueue(4);
        integerRandomQueue.enqueue(5);
        for (Integer integer : integerRandomQueue) {
            System.out.println(integer);
        }
    }
}
