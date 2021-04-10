package com.test.database.translate.基础;


import java.util.Arrays;

/**
 * 1.3.9
 */
public class ReversePoland {
    public static void main(String[] args) {
        String s = "12+2)*3-4)*5-6)))";
        // 中序表达式
        Stack<String> strings = new Stack<>();
        Stack<Character> characters = new Stack<>();
        char[] chars = s.toCharArray();
        int index = 0;
        while (index < chars.length) {
            char aChar = chars[index];
            if (aChar > '9' || aChar < '0') {
                if (aChar == ')') {
                    String two = strings.pop();
                    String one = strings.pop();
                    Character symbol = characters.pop();
                    if (symbol == '*' || symbol == '/') {
                        strings.push("(" + one + (symbol == '*' ? '*' : '/') + two + ')');
                    } else {
                        strings.push("(" + one + (symbol == '+' ? '+' : '-') + two + ')');
                    }
                } else {
                    characters.push(aChar);
                }
            } else {
                String s2 = "" + aChar;
                while (index < chars.length - 1 && chars[index + 1] >= '0' && chars[index + 1] <= '9') {
                    s2 += chars[++index];
                }
                strings.push("" + s2);
            }
            index++;
        }
        while (!characters.isEmpty()) {
            String two = strings.pop();
            String one = strings.pop();
            Character symbol = characters.pop();
            if (symbol == '*' || symbol == '/') {
                strings.push(one + (symbol == '*' ? '*' : '/') + two);
            } else {
                strings.push(one + (symbol == '+' ? '+' : '-') + two);
            }
        }
        System.out.println("待补全公式" + s);
        System.out.println("中序表达式" + strings.peek());
        ReversePoland reversePoland = new ReversePoland();
        String infixToPostFix = reversePoland.infixToPostFix(strings.peek());
        System.out.println("后序表达式" + infixToPostFix);
        int sum = reversePoland.evaluatePostfix(infixToPostFix);
        System.out.println("后序表达式计算结果" + sum);
    }

    // 后序表达式
    // 1.3.10
    // 不能计算多位数（*** 待解决）
    public String infixToPostFix(String s) {
        String s1 = new String();
        Stack<String> strings = new Stack<>();
        Stack<Character> characters = new Stack<>();
        char[] chars = s.toCharArray();
        int index = 0;
        while (index < chars.length) {
            char aChar = chars[index];
            if (chars[index] == '(' || chars[index] == ' ') {
                index++;
                continue;
            }
            if ((aChar > '9' || aChar < '0') && aChar != ')') {
                characters.push(aChar);
            } else if (aChar == ')') {
                String two = strings.pop();
                String one = strings.pop();
                Character symbol = characters.pop();
                strings.push(one + two + symbol);
            } else {
                String s2 = "" + aChar;
                while (index < chars.length - 1 && chars[index + 1] >= '0' && chars[index + 1] <= '9') {
                    s2 += chars[++index];
                }
                strings.push("" + s2 + ".");
            }
            index++;
        }
        while (!characters.isEmpty()) {
            strings.push(strings.pop() + characters.pop());
        }
        return strings.peek();
    }

    public int evaluatePostfix(String s) {
        Stack<Integer> integers = new Stack<>();
        Stack<Character> characters = new Stack<>();
        char[] chars = s.toCharArray();
        int index = 0;
        while (index < chars.length) {
            char aChar = chars[index];
            if (aChar > '9' || aChar < '0') {
                Integer two = integers.pop();
                Integer one = integers.pop();
                switch (aChar) {
                    case '*':
                        integers.push(one * two);
                        break;
                    case '/':
                        integers.push(one / two);
                        break;
                    case '+':
                        integers.push(one + two);
                        break;
                    case '-':
                        integers.push(one - two);
                        break;
                }
            } else {
                String num = "" + aChar;
                while (index < chars.length - 1 && chars[index + 1] != '.') {
                    num += chars[++index];
                }
                index++;
                integers.push(Integer.parseInt(num));
            }
            index++;
        }
        return integers.peek();
    }
}
