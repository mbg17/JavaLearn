package com.test.database.translate.soluation;

public class Euclid {

    public static int sum(int a, int b) {
        if (b == 0) {
            return 0;
        }
        if (a % b == 0) {
            return b;
        }
        return sum(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(sum(1111111, 1234567));
        System.out.println(binomial(100, 50, 0.25));
    }

    private static double[][] map = new double[150][150];

    public static double binomial(int N, int k, double p) {
        double[][] b = new double[N + 1][k + 1];

        for (int i = 0; i <= N; i++) {
            b[i][0] = Math.pow(1.0 - p, i);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= k; j++) {
                b[i][j] = p * b[i - 1][j - 1] + (1.0 - p) * b[i - 1][j];
            }
        }
        return b[N][k];
    }
//    欧几里德的算法关键在于证明等式gcd(a,b)=gcd(b,a mod b)的正确性。
//    定理：a，b为正整数，则gcd(a,b)=gcd(b,a mod b)
//    证明：
//    k,r为整数，设r = a mod b,则a可以表示成a=kb+r。
//    假设d是{a,b}的一个公约数，则d整除a,d整除b，而r=a-kb，因此d整除r，d也是b和r的公约数。
//    假设d是{b,r}的一个公约数，则d整除b,d整除r，而a=kb+r，因此d整除a, d也是a和b的公约数。
//    因此{a,b}和{b,r}的公因子集合是一样的。特别地，{a,b}的最大共因子和{b,r}的最大公因子是一样的，即gcd(a,b)=gcd(b,a mod b)。
}
