package com.test.database.translate.基础;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class RandomBag<T> implements Iterable<T> {
    private T[] elementData;
    private int size;

    public RandomBag(int cap) {
        this.elementData = (T[]) new Object[cap];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void add(T t) {
        if (this.size == this.elementData.length) {
            this.elementData = (T[]) Arrays.copyOf(this.elementData, this.size * 2);
        } else if (this.size == this.elementData.length / 4 && this.size > 2) {
            this.elementData = (T[]) Arrays.copyOf(new Object[this.size / 2], this.size);
        }
        this.elementData[size++] = t;
    }

    @Override
    public Iterator<T> iterator() {
        return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<T> {

        private int start = 0;
        private T[] randomElement = RandomBag.this.elementData;
        private int all = RandomBag.this.size;

        public RandomBagIterator() {
            int index = 0;
            int end = all;
            Random random = new Random();
            while (index < all) {
                int i = random.nextInt(end--);
                T e = randomElement[i];
                T s = randomElement[index];
                this.randomElement[index++] = e;
                this.randomElement[i] = s;
            }
        }

        @Override
        public boolean hasNext() {
            return start < all;
        }

        @Override
        public T next() {
            return this.randomElement[start++];
        }
    }

    public static void main(String[] args) {
        RandomBag<Integer> integers = new RandomBag<>(4);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(6);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
