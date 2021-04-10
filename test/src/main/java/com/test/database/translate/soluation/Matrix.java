package com.test.database.translate.soluation;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Matrix {

    public static double dot(double[] x, double[] y) {
        if (x.length == 0 || y.length == 0) {
            return 0.0;
        }
        double v = 0.0;
        int xlen = Math.max(x.length, y.length);
        for (int i = 0; i < xlen; i++) {
            v += x[i] * (i >= y.length ? 1 : y[i]);
        }
        return v;
    }

    public static double[][] mult(double[][] a, double[][] b) {
        if (a.length == 0) {
            return b;
        }
        if (b.length == 0) {
            return a;
        }
        int xlen = Math.max(a.length, b.length);
        int ylen = Math.max(a[0].length, b[0].length);
        double[][] doubles = new double[xlen][ylen];
        for (int i = 0; i < xlen; i++) {
            for (int j = 0; j < ylen; j++) {
                doubles[i][j] = (i >= a.length || j >= a[0].length ? 1 : a[i][j]) * (i >= b.length || j >= b[0].length ? 1 : b[i][j]);
            }
        }
        return doubles;
    }

    public static double[][] transpose(double[][] a) {
        if (a.length == 0) {
            return a;
        }
        ArrayList<Double> doubles = new ArrayList<>(a.length * a[0].length);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                doubles.add(a[i][j]);
            }
        }
        int index = 0;
        for (int i = a[0].length - 1; i >= 0; i--) {
            for (int j = 0; j < a.length; j++) {
                a[j][i] = doubles.get(index++);
            }
        }
        return a;
    }

    public static double[] mult2(double[][] a, double[] x) {
        if (a.length == 0) {
            return x;
        }
        int xlen = x.length;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < xlen; j++) {
                x[j] = x[j] * (j >= a[i].length ? 1 : a[i][j]);
            }
        }
        return x;
    }

    public static double[] mult3(double[] y, double[][] a) {
        if (a.length == 0) {
            return y;
        }
        int xlen = y.length;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < xlen; j++) {
                y[j] = y[j] * (j >= a[i].length ? 1 : a[i][j]);
            }
        }
        return y;
    }

    public static void main(String[] args) {
        double[][] doubles = {
                {1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        System.out.println("原始矩阵");
        Arrays.stream(doubles).forEach(s -> System.out.println(Arrays.toString(s)));
        System.out.println(dot(new double[]{1.0, 2.0, 3.0, 4.0}, new double[]{2.0, 3.0}));
        System.out.println("转置矩阵");
        Arrays.stream(transpose(doubles
        )).forEach(s -> System.out.println(Arrays.toString(s)));
        System.out.println("向量点乘");
        System.out.println(dot(new double[]{1.0, 2.0, 3.0, 4.0}, new double[]{2.0, 3.0}));
        Arrays.stream(mult(doubles, new double[][]{
                {1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}})).forEach(s -> System.out.println(Arrays.toString(s)));
        System.out.println("矩阵和向量之积");
        System.out.println(Arrays.toString(mult2(doubles, new double[]
                {1.0, 2.0, 3.0, 4.0})));
    }
}
