package com.test.database.translate;

import com.test.database.translate.std.StdDraw;

public class DrawTest {
    public static void main(String[] args) {
        int N = 100;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, (double) N * N);
        StdDraw.setPenRadius(.01);
        for (int i = 0; i <= N; i++) {
            StdDraw.point(i, i);
            StdDraw.point(i, i * i);
            StdDraw.point(i, i * Math.log(i));
        }
    }
}
