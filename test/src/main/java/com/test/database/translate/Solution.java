package com.test.database.translate;

import java.util.*;

public class Solution {

    public static int longestSubstring(String s, int k) {
        int len = s.length();
//        如果长度小于k直接返回
        if (len < k) {
            return 0;
        }
//        统计出现的次数
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            characterIntegerHashMap.put(aChar, characterIntegerHashMap.getOrDefault(aChar, 0) + 1);
        }
//        遍历字符串
        Set<Character> characters = characterIntegerHashMap.keySet();
        for (Character character : characters) {
//            如果出现的次数小于K，以当前字母作为切割点切割递归调用判断左边和右边是否又符合的要求的最长字符串
            if (characterIntegerHashMap.get(character) < k) {
                int res = 0;
                String[] split = s.split(character.toString());
                for (String s1 : split) {
                    res = Math.max(res, longestSubstring(s1, k));
                }
                return res;
            }
        }
//        没有调用递归则说明整个字符串都符合要求
        return len;
    }

    public static boolean isMonotonic(int[] A) {
        Boolean flag = null;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A[i + 1]) {
                continue;
            }
            if (flag == null) {
                if (A[i] >= A[i + 1]) {
                    flag = false;
                } else {
                    flag = true;
                }
            }
            if (!flag) {
                if (A[i] < A[i + 1]) {
                    return false;
                }
            } else {
                if (A[i] > A[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }


    public static List<String> letterCombinations(String digits) {
        ArrayList<String> strings = new ArrayList<>();
        if (digits.length() == 0) {
            return strings;
        }
        HashMap<Character, String> stringHashMap = new HashMap<>();
        stringHashMap.put('0', "");
        stringHashMap.put('1', "");
        stringHashMap.put('2', "abc");
        stringHashMap.put('3', "def");
        stringHashMap.put('4', "ghi");
        stringHashMap.put('5', "jkl");
        stringHashMap.put('6', "mno");
        stringHashMap.put('7', "pqrs");
        stringHashMap.put('8', "tuv");
        stringHashMap.put('9', "wxyz");
        StringBuffer stringBuffer = new StringBuffer();
        backCall(strings, digits, stringHashMap, 0, stringBuffer);
        return strings;
    }

    // 深度优先
    public static void backCall(ArrayList<String> strings, String digits, HashMap<Character, String> stringHashMap, int index, StringBuffer stringBuffer) {
        if (digits.length() == index) {
            strings.add(stringBuffer.toString());
            return;
        }
        char c = digits.charAt(index);
        String s = stringHashMap.get(c);
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c1 = s.charAt(i);
            stringBuffer.append(c1);
            backCall(strings, digits, stringHashMap, index + 1, stringBuffer);
            stringBuffer.deleteCharAt(index);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> integers = new ArrayList<>();
        if (nums.length == 0) {
            return integers;
        }
        Deque<Integer> ints = new LinkedList<>();
        boolean[] booleans = new boolean[nums.length];
        permuteBackCall(integers, nums, 0, ints, booleans);
        return integers;
    }

    public static void permuteBackCall(List<List<Integer>> integers, int[] nums, int index, Deque<Integer> ints, boolean[] booleans) {
        if (index == nums.length) {
            integers.add(new ArrayList<>(ints));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!booleans[i]) {
                ints.add(nums[i]);
                booleans[i] = true;
                permuteBackCall(integers, nums, index + 1, ints, booleans);
                booleans[i] = false;
                ints.removeLast();
            }
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ArrayList<ListNode> listNodes = new ArrayList<>();
        ListNode prehead = head;
        while (head != null) {
            listNodes.add(head);
            head = head.next;
        }
        listNodes.get(listNodes.size() - 1).next = prehead;
        int allIndex = listNodes.size() - k % listNodes.size();
        head = listNodes.get(allIndex - 1).next;
        listNodes.get(allIndex - 1).next = null;
        return head;
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        // 开二位数组存储数据
        // 默认第一个数没有子串
        // dp[i][j] 表示text1[0...i] 和 text2[0...j]的最长公共子序列
        // dp[i][j] = max(dp[i-1][j], dp[i][j-1]) if text1[i]!=text2[j]
        // dp[i][j] = dp[i-1][j-1] + 1 if text1[i] == text2[j]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 和上一个子串的最大值相加
                if (t1[i - 1] == t2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // 和前一个字符串的最长子串数比较的结果取最大值
                dp[i][j] = dp[i][j - 1] > dp[i][j] ? dp[i][j - 1] : dp[i][j];
                // 和前一次比较的结果取最大值
                dp[i][j] = dp[i - 1][j] > dp[i][j] ? dp[i - 1][j] : dp[i][j];

            }
        }
        return dp[m][n];
    }

    public static int nthUglyNumber(int n) {
        if (n <= 6) {
            return n;
        }
        PriorityQueue<Long> longs = new PriorityQueue<>();
        longs.offer(1L);
        HashSet<Long> ints = new HashSet<>();
        ArrayList<Long> answer = new ArrayList<>();
        while (true) {
            if (answer.size() >= n) {
                break;
            }
            Long poll = longs.poll();
            if (poll < 0) {
                continue;
            }
            answer.add(poll);
            if (!ints.contains(poll * 2)) {
                ints.add(poll * 2);
                longs.offer(poll * 2);
            }
            if (!ints.contains(poll * 3)) {
                ints.add(poll * 3);
                longs.offer(poll * 3);
            }
            if (!ints.contains(poll * 5)) {
                ints.add(poll * 5);
                longs.offer(poll * 5);
            }
        }
        long aLong = answer.get(n - 1);
        return (int) aLong;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k + 1];
        int[][] ints = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            int sum = Arrays.stream(mat[i]).sum();
            ints[i] = new int[]{i, sum};
        }
        System.out.println(Arrays.deepToString(ints));
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < k; i++) {
            ans[i] = ints[i][0];
        }
        return ans;
    }

    private int ans = 1;
    private int g_n;

    public int findIntegers(int n) {
        this.g_n = n;
        dfs(1);
        return ans;
    }

    private void dfs(int i) {
        if (i > g_n) {
            return;
        }
        ans++;
        if ((i & 1) == 1) {
            dfs(i << 1);
        } else {
            dfs(i << 1);
            dfs((i << 1) + 1);
        }
    }

    public boolean checkValidString(String s) {
        Stack<Integer> stars = new Stack<>();
        Stack<Integer> left = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                continue;
            }
            if (chars[i] == '(') {
                left.push(i);
            } else if (chars[i] == '*') {
                stars.push(i);
            } else {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!stars.isEmpty()) {
                    stars.pop();
                } else {
                    return false;
                }
            }
        }
        while (!left.isEmpty() && !stars.isEmpty()) {
            Integer l = left.pop();
            Integer star = stars.pop();
            if (star < l) {
                return false;
            }
        }
        return left.isEmpty();
    }

    int test() {
        try {
            return func1();
        } finally {
            return func2();
        }
    }

    private int func2() {
        System.out.println("func2");
        return 2;
    }

    private int func1() {
        System.out.println("func1");
        return 1;
    }

    //    解题思路: 有四个洗衣机，装的衣服数为[0, 0, 11, 5]，最终的状态会变为[4, 4, 4, 4]，那么我们将二者做差，得到*[-4, -4, 7, 1]，这里负数表示当前洗衣机还需要的衣服数
//    ，正数表示当前洗衣机多余的衣服数。我们要做的是*要将这个差值数组每一项都变为0，对于第一个洗衣机来说，需要四件衣服可以从第二个洗衣机获得，那么就可以 把-4移给二号洗衣机，那么差值数组变为[0, -8, 7, 1]
//    ，此时二号洗衣机需要八件衣服，那么至少需要移动8次。然后二号洗衣机把这八件衣服从三号洗衣机处获得，那么差值数组变为[0, 0, -1, 1]，
//    此时三号洗衣机还缺1件，就从四号洗衣机处获得，此时差值数组成功变为了[0, 0, 0, 0]，成功。那么移动的最大次数就是差值 数组中出现的绝对值最大的数字，8次
    public int findMinMoves(int[] machines) {
        int all = Arrays.stream(machines).sum();
        int mod = all % machines.length;
        if (mod != 0) {
            return -1;
        }
        int div = all / machines.length;
        int[] ints = new int[machines.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = machines[i] - div;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < ints.length - 1; i++) {
            ans = Math.max(ans, Math.abs(ints[i]));
            ans = Math.max(ans, ints[i + 1]);
            ints[i + 1] += ints[i];
        }
        return Math.max(ans, ints[ints.length - 1]);
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int a = (ay2 - ay1) * (ax2 - ax1);
        int b = (by2 - by1) * (bx2 - bx1);
        int x1 = 0;
        int x2 = 0;
        int y1 = 0;
        int y2 = 0;
        if ((by2 < ay2 && by2 > ay1) || ay2 == by2) {
            y1 = by2;
        }
        if ((ay2 < by2 && ay2 > by1) || ay2 == by2) {
            y1 = ay2;
        }
        if ((by1 > ay1 && by1 < ay2) || ay1 == by1) {
            y2 = by1;
        }
        if ((ay1 > by1 && ay1 < by2) || ay1 == by1) {
            y2 = ay1;
        }
        if ((bx1 > ax1 && bx1 < ax2) || bx1 == ax1) {
            x1 = bx1;
        }
        if ((ax1 > bx1 && ax1 < bx2) || bx1 == ax1) {
            x1 = ax1;
        }
        if ((bx2 < ax2 && bx2 > ax1) || bx2 == ax2) {
            x2 = bx2;
        }
        if ((ax2 < bx2 && ax2 > bx1) || ax2 == bx2) {
            x2 = ax2;
        }
        return a + b - (y1 - y2) * (x2 - x1);
    }

    public String destCity(List<List<String>> paths) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        HashSet<String> strings = new HashSet<>();
        for (List<String> path : paths) {
            stringStringHashMap.put(path.get(0), path.get(1));
            strings.add(path.get(0));
            strings.add(path.get(1));
        }
        String ans = "";
        for (String string : strings) {
            String s = stringStringHashMap.get(string);
            if (s == null) {
                ans = string;
                break;
            }
        }
        return ans;
    }

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuffer stringBuffer = new StringBuffer();
        long a = numerator;
        long b = denominator;
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            stringBuffer.append("-");
        }
        a = Math.abs(a);
        b = Math.abs(b);
        long i = a / b;
        stringBuffer.append(i);
        if (a % b == 0) {
            return stringBuffer.toString();
        }
        stringBuffer.append(".");
        HashMap<Long, Integer> longIntegerHashMap = new HashMap<>();
        while ((a = (a % b) * 10) > 0 && !longIntegerHashMap.containsKey(a)) {
            longIntegerHashMap.put(a, stringBuffer.length());
            stringBuffer.append(a / b);
        }
        if (a == 0) {
            return stringBuffer.toString();
        }
        return stringBuffer.insert(longIntegerHashMap.get(a).intValue(), '(').append(')').toString();
    }

    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 3) {
            return nums[nums.length - 1];
        }
        int ans = nums.length - 1;
        int num = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length || nums[i] == nums[i + 1]) {
                continue;
            } else {
                num++;
                ans = i;
            }
            if (num == 3) {
                break;
            }
        }
        return num == 3 ? nums[ans] : nums[nums.length - 1];
    }

    public int countSegments(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        boolean flag = false;
        for (char aChar : chars) {
            if (aChar == ' ') {
                if (flag) {
                    flag = false;
                }
                continue;
            }
            if (!flag) {
                ans++;
                flag = true;
            }
        }
        return ans;
    }

    public static String simplifyPath(String path) {
        System.out.println(1);
        String[] split = path.split("/");
        String ans = new String();
        Stack<String> strings = new Stack<>();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < split.length; i++) {
            if (".".equals(split[i]) || "".equals(split[i])) {
                continue;
            } else if ("..".equals(split[i])) {
                if (!strings.isEmpty()) {
                    strings.pop();
                }
            } else {
                strings.push(split[i]);
            }
        }
        while (!strings.isEmpty()) {
            String pop = strings.pop();
            ans = "/" + pop + ans;
        }
        return ans.equals("") ? "/" : ans;
    }

    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < first) {
                first = nums[i];
            } else if (first < nums[i]) {
                second = nums[i];
            } else if (nums[i] > second) {
                return true;
            }
        }
        return false;
    }

    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int first = -1;
        int second = -1;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (Math.max(second, nums[i]) > second) {
                first = second;
                second = nums[i];
                max = i;
            } else if (nums[i] < second && nums[i] > first) {
                first = nums[i];
            }
        }
        return (first==0) && second / first >= 2 ? max : -1;
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
        String[] split = "111".split("\\.");
        System.out.println(split.length);
    }
}
