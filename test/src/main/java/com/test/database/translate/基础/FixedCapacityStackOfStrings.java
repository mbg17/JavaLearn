package com.test.database.translate.基础;

public class FixedCapacityStackOfStrings {
    private String[] strings;
    private int index;

    public FixedCapacityStackOfStrings(int cap) {
        this.strings = new String[cap];
    }

    public void push(String s) {
        this.strings[index++] = s;
    }

    public String pop() {
        return this.strings[--index];
    }

    public boolean isEmpty() {
        return this.index == 0;
    }

    public boolean isFull() {
        return this.index == this.strings.length;
    }

    public int size() {
        return this.index;
    }

    public String peek() {
        return this.strings[index - 1];
    }
}
