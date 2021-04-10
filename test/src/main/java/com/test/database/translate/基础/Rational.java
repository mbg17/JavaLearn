package com.test.database.translate.基础;

public class Rational {
    private final long num;
    private final long den;

    public Rational(long numerator, long denominator) {
        if (denominator == 0)
            throw new RuntimeException("Denominator is zero");
        long g = gcd(numerator, denominator);

        if (denominator < 0)
            g = -g;

        this.num = numerator / g;
        this.den = denominator / g;
    }

    public Rational plus(Rational b) {
        long d = den * b.den;
        long n = num * b.den + den * b.num;
        return new Rational(n, d);
    }

    public Rational minus(Rational b) {
        long d = den * b.den;
        long n = num * b.den - den * b.num;
        return new Rational(n, d);
    }

    public Rational times(Rational b) {
        return new Rational(num * b.num, den * b.den);
    }

    public Rational divides(Rational b) {
        return new Rational(num * b.den, den * b.num);
    }

    public boolean equals(Rational that) {
        if (this == that) return true;
        if (that == null) return false;
        if (this.getClass() != that.getClass()) return false;
        return (num == that.num && den == that.den);
    }

    private static long gcd(long m, long n) {
        if (m < 0) m = -m;
        if (n < 0) n = -n;
        if (n == 0) return m;
        return gcd(n, m % n);
    }

    public String toString() {
        if (this.den == 1)
            return String.format("%d", this.num);
        return String.format("%d/%d", this.num, this.den);
    }
}
