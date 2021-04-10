package com.test.database.translate.soluation;

public class Fibonacci {
    public static long F1(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        return F1(N - 1) + F1(N - 2);
    }

    public static long F2(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int[] dp = new int[N];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N - 1];
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(F1(10));
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(F2(10));
        System.out.println(System.currentTimeMillis());
    }
}
