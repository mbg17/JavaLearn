package FileLianXi;

public class DiGuiLianXi {
    public static void main(String[] args) {
        int num = num(100);
        System.out.println(num);
        int jiechen = jiechen(4);
        System.out.println(jiechen);

    }

    // 递归计算1-I的和
    public static int num(int i){
        if (i>1){
            return i+num(i-1);
        }
        return i;
    }

    // 递归计算1-I的阶乘
    public static int jiechen(int i){
        if (i>1){
            return i*jiechen(i-1);
        }
        return i;
    }
}
