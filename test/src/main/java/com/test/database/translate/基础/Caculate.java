package com.test.database.translate.基础;


import java.util.Stack;

/**
 * 计算器待实现！！
 */
public class Caculate {
    public static void main(String[] args) {
        Caculate caculate = new Caculate();
        int count = caculate.count("-1-(1*3)+1");
        System.out.println(count);
    }

    public int count(String s) {
        int sum = 0;
        Stack<Integer> integers = new Stack<>();
        Stack<Character> characters = new Stack<>();
        char[] chars = s.toCharArray();
        int index = 0;
        while (index < chars.length) {
            char aChar = chars[index];
            if (aChar > '9' || aChar < '0') {
                if (aChar == '(' || aChar == '+' || aChar == '-') {
                    if (aChar == '-' && integers.isEmpty()) {
                        integers.push(0);
                    }
                    characters.push(aChar);
                } else if (aChar == '/' || aChar == '*') {
                    if (!characters.isEmpty() && wight(characters.peek()) < wight(aChar)) {
                        String num = "";
                        while (index < chars.length - 1 && chars[index + 1] >= '0' && chars[index + 1] <= '9') {
                            num += chars[++index];
                        }
                        if (aChar == '/') {
                            integers.push(integers.pop() / Integer.parseInt(num));
                        } else {
                            integers.push(integers.pop() * Integer.parseInt(num));
                        }
                    } else {
                        characters.push(aChar);
                    }
                } else {
                    while (characters.peek() != '(') {
                        Integer two = integers.pop();
                        Integer one = integers.pop();
                        Character pop = characters.pop();
                        integers.push(sum(pop, one, two));
                    }
                    characters.pop();
                }
            } else {
                String num = "" + chars[index];
                while (index < chars.length - 1 && chars[index + 1] >= '0' && chars[index + 1] <= '9') {
                    num += chars[++index];
                }
                integers.push(Integer.parseInt(num));
            }
            index++;
        }
        while (!characters.isEmpty() && integers.size() > 1) {
            Integer one = integers.remove(0);
            Integer two = integers.remove(0);
            Character pop = characters.remove(0);
            integers.add(0,sum(pop, one, two));
        }
        return integers.peek();
    }

    public int wight(char c) {
        int weight = 0;
        if (c == '(') {
            weight = 3;
        }
        if (c == '-' || c == '+') {
            weight = 1;
        }
        if (c == '*' || c == '/') {
            weight = 2;
        }
        return weight;
    }

    public int sum(char i, int one, int two) {
        int all = 0;
        if (i == '/') {
            all = one / two;
        } else if (i == '*') {
            all = one * two;
        } else if (i == '+') {
            all = one + two;
        } else {
            all = one - two;
        }
        return all;
    }
}
