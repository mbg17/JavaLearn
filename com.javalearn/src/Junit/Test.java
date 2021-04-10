package Junit;

public class Test {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String[] s1 = s.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (String s2 : s1) {
            for (int i = s2.length()-1; i >=0 ; i--) {
                stringBuffer.append(s2.charAt(i));
                if(i==0){
                    stringBuffer.append(" ");
                }
            }
        }

    }
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        return null;
    }
}
