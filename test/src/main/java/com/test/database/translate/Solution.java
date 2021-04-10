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

    public static void main(String[] args) {
//        System.out.println(longestCommonSubsequence("bsbininm"
//                , "jmjkbkjkv"));
        System.out.println(nthUglyNumber(1690));
//        System.out.println(permute(new int[]{1, 2, 3}));
//        System.out.println(letterCombinations("23"));
//        System.out.println(isMonotonic(new int[]{1,1,2}));
//        System.out.println(longestSubstring("acaabb", 3));
    }
}
