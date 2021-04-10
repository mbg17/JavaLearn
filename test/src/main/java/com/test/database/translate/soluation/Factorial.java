package com.test.database.translate.soluation;

public class Factorial {
    public static int method(int num) {
        if (num == 1) {
            return 1;
        }
        return num * method(num - 1);
    }

    public static void main(String[] args) {
        System.out.println(method(7));
    }
}
