package SystemLianXi;

import java.util.Date;

public class Demo01 {
    public static void main(String[] args) {
        // 获取系统当前时间毫秒
        long date = System.currentTimeMillis();
        System.out.println(date);

        // 赋值数组
        // 参数列表：原数组，原数组起始值，目标数组，目标数组起始值，复制长度
        int[] array1 = {1,2,3,4,5,6,7,8,9};
        int[] array2 = {2,5,7,4,3,6,7,8,5};

        System.arraycopy(array1,3,array2,0,3);
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i]);
        }
    }
}
