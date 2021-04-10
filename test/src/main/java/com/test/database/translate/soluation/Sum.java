package com.test.database.translate.soluation;

import java.util.Arrays;
import java.util.Random;

public class Sum {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 3, 6, 8, 5, 4, 3, 6, 7, 8, 6};
        // 打印出最大最小数
        int max = Arrays.stream(ints).max().getAsInt();
        int min = Arrays.stream(ints).min().getAsInt();
        System.out.println(max + ":" + min);
        Arrays.sort(ints);
        int i = ints.length % 2 == 0 ? (ints[ints.length / 2] + ints[ints.length / 2 - 1]) / 2 : ints[ints.length / 2];
        System.out.println(ints[5]);
        int sum = Arrays.stream(ints).map(s -> s * s).sum();
        double average = Arrays.stream(ints).average().getAsDouble();
        for (int j = ints.length - 1; j >= 0; j--) {
            if (ints[j] == (int) average) {
                System.out.println(((double) (ints.length - 1 - j) / (double) (ints.length - 1)) * 100);
                break;
            }
        }
        boolean[] booleans = new boolean[ints.length];
        int all = ints.length;
        Random random = new Random();
        while (all > 0) {
            int i1 = random.nextInt(ints.length);
            if (!booleans[i1]) {
                System.out.print(ints[i1] + " ");
                booleans[i1] = !booleans[i1];
                all--;
            }
        }
    }
}
