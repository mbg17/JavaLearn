package com.test.database.translate.soluation;

import java.util.ArrayList;
import java.util.Arrays;

public class Excel {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("haha", 20, 50));
        people.add(new Person("xixi", 20, 50));
        people.add(new Person("huhu", 20, 50));
        people.add(new Person("hehe", 20, 50));
        for (Person person : people) {
            System.out.printf("%s : %.3f", person.getName(), (float) person.getNum() / person.getMingzhong());
            System.out.println();
        }
        boolean[][] booleans = new boolean[3][3];
        for (int i = 0; i < booleans.length; i++) {
            for (int j = 0; j < booleans[0].length; j++) {
                booleans[i][j] = isDigist(i, j) == 1 ? true : false;
            }
        }
        Arrays.stream(booleans).forEach(booleans1 -> System.out.println(Arrays.toString(booleans1)));
    }

    public static class Person {
        private String name;
        private int mingzhong;
        private int num;

        public Person(String name, int mingzhong, int num) {
            this.name = name;
            this.mingzhong = mingzhong;
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMingzhong() {
            return mingzhong;
        }

        public void setMingzhong(int mingzhong) {
            this.mingzhong = mingzhong;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }

    public static int isDigist(int p, int q) {
        if (p == 0) {
            return -1;
        }
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return isDigist(q, r);
    }
}
