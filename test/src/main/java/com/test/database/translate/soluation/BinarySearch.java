package com.test.database.translate.soluation;

import java.util.Arrays;
import java.util.HashSet;

public class BinarySearch {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 4, 4, 4, 4, 4, 4, 4, 5, 6, 7, 8, 9, 9, 9, 9};
        System.out.println(rank2(ints, 4));
        System.out.println(Arrays.toString(deleleAgain(ints)));
        int value = 4;
        System.out.println(randTwo(ints, 0, ints.length - 1, value));
        System.out.println(2.0e-6 * 100000000.1);
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001) {
            t = (9.0 / t + t) / 2.0;
        }
        System.out.println(t);//3.00009155413138
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        System.out.println(sum);// 499500
        sum = 0;
        for (int i = 1; i < 1000; i *= 2) {
            for (int j = 0; j < 1000; j++) {
                sum++;
            }
        }
        System.out.println(sum);//1024000
        String s = "";
        for (int i = 8; i > 0; i /= 2) {
            s = (i % 2) + s;
        }
        System.out.println(s);
        boolean[][] booleans = new boolean[][]{
                {true, false, true, false, true},
                {true, false, true, false, true},
                {true, false, false, false, true},
                {false, false, true, false, true}};
        for (int i = 0; i < booleans.length; i++) {
            for (int j = 0; j < booleans[0].length; j++) {
                System.out.print(i + ":" + j + (booleans[i][j] == true ? "*" : " ") + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < booleans[0].length; i++) {
            for (int j = 0; j < booleans.length; j++) {
                System.out.print(booleans[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println(lg(7));
        System.out.println(Arrays.toString(histogram(new int[]{1, 2, 3, 4, 5, 1, 2, 3}, 6)));
        System.out.println(exR1(6));//311361142246
        System.out.println(mystrey(3, 11));
    }

    public static int[] deleleAgain(int[] arr) {
        Arrays.sort(arr);
        // 1,2,2,3,4,4
        int left = 0;
        int right = 1;
        while (right < arr.length) {
            if (arr[right] != arr[left]) {
                int temp = arr[right];
                arr[right] = arr[++left];
                arr[left] = temp;
            }
            right++;
        }
        return Arrays.copyOfRange(arr, 0, left + 1);
    }

    public static int mystrey(int a, int b) {
        if (b == 0) {
            return 0;
        }
        if (b % 2 == 0) {
            return mystrey(a * 2, b / 2);
        }
        return mystrey(a * 2, b / 2) + a;
    }

    public static String exR1(int n) {
        if (n <= 0) {
            return "";
        }
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }

    public static int[] histogram(int[] arr, int M) {
        int[] ints = new int[M];
        for (int i = 0; i < arr.length; i++) {
            ints[arr[i]]++;
        }
        return ints;
    }

    private static int lg(int N) {
        int i = 0;
        //不能使用if语句，if语句不具有循环性质
        while (N > 0) {
            //除以2向下取整
            N = N >> 1;
            i++;
        }
        return i - 1;
    }

    public static int rank(int[] arr, int value) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > value) {
                right = mid - 1;
            } else if (arr[mid] < value) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int rank2(int[] arr, int value) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > value) {
                right = mid - 1;
            } else if (arr[mid] < value) {
                left = mid + 1;
            } else {
                int count = 0;
                while (mid >= 0) {
                    count++;
                    mid--;
                }
                return count;
            }
        }
        return -1;
    }

    public static int randTwo(int[] arr, int left, int right, int value) {
        if (left > right) {
            System.out.println("- " + value);
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == value) {
            System.out.println("+ " + value);
            return mid;
        } else if (arr[mid] < value) {
            return randTwo(arr, mid + 1, right, value);
        } else {
            return randTwo(arr, left, mid - 1, value);
        }
    }

}
