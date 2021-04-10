package com.test.database.translate.基础;

import com.test.database.translate.std.In;

public class Josephus {
    public static void main(String[] args) {
        Queue<Integer> integers = new Queue<>();
        for (int i = 0; i < 7; i++) {
            integers.enqueue(i);
        }
        int start = 1;
        while (integers.size() > 1) {
            if (start % 2 == 0) {
                System.out.println(integers.dequeue());
            } else {
                integers.enqueue(integers.dequeue());
            }
            start++;
        }
        System.out.println(integers.dequeue());
    }
}
