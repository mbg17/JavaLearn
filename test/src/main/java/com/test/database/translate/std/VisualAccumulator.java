package com.test.database.translate.std;

public class VisualAccumulator {
    private double total;
    private int N;

    public VisualAccumulator(int trials, double max) {
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(.005);
    }

    public void addDataValue(double val) {
        N++;
        total += val;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(N, val);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(N, total / N);
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

    public static void main(String[] args) {
        int T = 100;
        VisualAccumulator visualAccumulator = new VisualAccumulator(20, 1.0);
        for (int i = 0; i < T; i++) {
            visualAccumulator.addDataValue(StdRandom.random());
        }
        StdOut.println(visualAccumulator);
    }
}
