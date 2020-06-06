package LambdaLianXi;

import java.util.function.Supplier;

public class GetMaxLianXI {
    public static void main(String[] args) {
        int[] arr = {1, 56, 4, 65, 2};
        int max = getMax(() -> {
            int m = 0;
            for (int i : arr) {
                if (i > m) {
                    m = i;
                }
            }
            return m;
        });
        System.out.println(max);
    }

    public static int getMax(Supplier<Integer> sp) {
        return sp.get();
    }
}
