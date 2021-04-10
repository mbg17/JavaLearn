package com.test.database.translate.基础;

import java.util.Arrays;
import java.util.Iterator;


// 1.3.14
public class ResizingArrayQueueOfStrings implements Iterable<String> {
    private String[] strings;
    private int end = 0;
    private int begin = 0;

    public ResizingArrayQueueOfStrings(int cap) {
        this.strings = new String[cap];
    }

    public void push(String s) {
        if (this.end == this.strings.length) {
            this.strings = Arrays.copyOf(this.strings, this.strings.length * 2);
        }
        this.strings[end++] = s;
    }

    public String pop() {
        if (begin == end) {
            return null;
        }
        String string = this.strings[begin++];
        this.strings[begin] = null;
        if (this.begin == this.strings.length / 4 * 3) {
            String[] temp = new String[this.strings.length / 2];
            for (int i = begin, j = 0; i < end; i++, j++) {
                temp[j] = this.strings[i];
            }
            this.strings = temp;
            this.end = this.end - this.begin;
            this.begin = 0;
        }
        return string;
    }

    public int cap() {
        return this.strings.length;
    }

    public boolean isEmpty() {
        return this.end == 0;
    }

    public int size() {
        return this.end - this.begin;
    }

    @Override
    public Iterator<String> iterator() {
        return new IndexIterator();
    }

    private class IndexIterator implements Iterator<String> {
        @Override
        public boolean hasNext() {
            return begin < ResizingArrayQueueOfStrings.this.end;
        }

        @Override
        public String next() {
            return ResizingArrayQueueOfStrings.this.strings[begin++];
        }

        private int begin = ResizingArrayQueueOfStrings.this.begin;
    }

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings(2);
        queue.push("1");
        queue.push("2");
        queue.push("3");
        System.out.println(queue.cap());
        System.out.println(queue.pop());
        System.out.println(queue.size());
    }
}
