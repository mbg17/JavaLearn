package com.test.database.translate.soluation;

import java.util.HashMap;
import java.util.Map;

public class Questions {
    public static int compress(char[] chars) {
        char[] tempChars = new char[2000];
        int tIndex = 0;
        int index = 0;
        while (index < chars.length) {
            char aChar = chars[index];
            int end = index;
            while (end < chars.length) {
                if (aChar == chars[end]) {
                    end++;
                } else {
                    end--;
                    break;
                }
            }
            int sum = (end >= chars.length ? chars.length - 1 : end) - index + 1;
            if (sum == 1) {
                tempChars[tIndex++] = aChar;
            } else {
                String s = aChar + "" + sum;
                for (char c : s.toCharArray()) {
                    tempChars[tIndex++] = c;
                }
            }
            index = end + 1;
        }
        for (int i = 0; i < tIndex; i++) {
            chars[i] = tempChars[i];
        }
        return tIndex;
    }

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
    }
}
