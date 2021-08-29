package com.test.database.translate.soluation;

import java.util.Arrays;
import java.util.Random;

public class FourSum {
    /**
     * 四数之和等于零
     */
    public int count(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length - 3; i++) {
            int j = i + 1;
            int k = i + 2;
            ans += findNum(-(arr[i] + arr[j] + arr[k]), k, arr);
        }
        return ans;
    }

    public int findNum(int count, int index, int[] arr) {
        int ans = 0;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + right >> 1;
            if (arr[mid] + count == 0) {
                if (mid == index) {
                    return 0;
                } else {
                    for (int i = mid; i > index; i--) {
                        if (arr[mid] + count != 0) {
                            break;
                        }
                        ans++;
                    }
                }
                return ans;
            } else if (arr[mid] + count > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }


    //[1,4,2,5,3]
    public static int sumOddLengthSubarrays(int[] arr) {
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ans += arr[i];
            arr[i] = arr[i] + arr[i - 1];
        }
        int step = 2;
        while (step < arr.length) {
            for (int i = 0; i < arr.length - step; i++) {
                int index = i + step;
                ans += i == 0 ? arr[index] : arr[index] - arr[i - 1];
            }
            step += 2;
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] ints = new int[1000];
//        Random random = new Random();
//        for (int i = 0; i < 1000; i++) {
//            ints[i] = random.nextInt(100);
//        }
//        System.out.println(new FourSum().count(ints));
        System.out.println(sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
    }

}
