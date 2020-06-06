package DataToString;

public class DatasToString {
    public static void main(String[] args) {
        // Integer-> String
        final String s1 = Integer.toString(1);
        System.out.println(s1);

        Integer i = 1;
        String s2 = i+"";
        System.out.println(s2);

        String s3 = String.valueOf(1);
        System.out.println(s3);
    }

}
