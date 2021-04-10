package com.test.database.translate.std;

public class Accumulator {
    private double total;
    private int N;

    public void addDataValue(double val) {
        N++;
        total += val;
    }

    public double mean() {
        System.out.println(total + ":" + N);
        return total / N;
    }

    @Override
    public String toString() {
        return "Accumulator{" +
                "N=" + N +
                "，value=" + String.format("%7.5f", mean()) +
                '}';
    }
}
