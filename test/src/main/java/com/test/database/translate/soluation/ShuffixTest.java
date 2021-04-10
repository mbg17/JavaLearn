package com.test.database.translate.soluation;

import java.util.Arrays;
import java.util.Random;

public class ShuffixTest {
    public static void main(String[] args) {
        int[] ints = {1, 1, 2};
        System.out.println(Arrays.deepToString(shuffix(ints, 3)));
    }

    public static int[][] shuffix(int[] arr, int N) {
        int[][] ints = new int[N][arr.length];
        Random random = new Random();
        int i1 = random.nextInt(ints.length);
        for (int i = 0; i < N; i++) {
            boolean[] booleans = new boolean[arr.length];
            int index = 0;
            while (index < arr.length) {
                int i2 = random.nextInt(arr.length);
                if (!booleans[i2]) {
                    if (i2 == index) {
                        ints[i][index] += 1;
                    }
                    index++;
                }
            }
        }
        return ints;
    }
}
