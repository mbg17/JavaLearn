package StringBuilderLianXi;

public class Demo01 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();// 创建空的字符串
        System.out.println(sb);

        StringBuilder sb2 = new StringBuilder("abc");// 返回带有值的字符串容器
        System.out.println(sb2);

        // 拼接字符串
        sb2.append(1);
        sb2.append('1');
        sb2.append(true);
        sb2.append(0.001);
        System.out.println(sb2);
        // 链式拼接
        sb.append(1).append('2').append(true).append(1223.2323);
        System.out.println(sb);
        // 翻转字符串
        sb2.reverse();
        System.out.println(sb2);
    }
}
