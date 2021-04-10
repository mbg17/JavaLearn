package com.test.database.translate.基础;

import java.util.Stack;

public class Paraentheses {
    public boolean checkBrackets(String expression) {
        if (expression.length() == 0) {
            return true;
        }
        Stack<Character> characters = new Stack<>();
        char[] chars = expression.toCharArray();
        for (char aChar : chars) {
            if (aChar == '{' || aChar == '[' || aChar == '(') {
                characters.push(aChar);
            } else {
                if (characters.isEmpty()) {
                    return false;
                }
                if ((characters.peek() == '(' && aChar == ')') || (characters.peek() == '[' && aChar == ']') || (characters.peek() == '{' && aChar == '}')) {
                    characters.pop();
                } else {
                    return false;
                }
            }
        }
        return characters.isEmpty();
    }

    public static void main(String[] args) {
        boolean b = new Paraentheses().checkBrackets("{[}]");
        System.out.println(b);
        Stack<Integer> integers = new Stack<>();
        int N = 50;
        while (N > 0) {
            integers.push(N % 2);
            N /= 2;
        }
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

}
