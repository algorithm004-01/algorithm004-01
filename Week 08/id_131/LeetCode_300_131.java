package com.lzhlyle.leetcode.recite.no300;

import java.util.Arrays;

public class LongestIncreasingSubsequence_2 {
    // dp O(n^2)
    public int lengthOfLIS(int[] nums) {
        // base condition
        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 4};
        int res = new LongestIncreasingSubsequence_2().lengthOfLIS(nums);
        System.out.println(res);
    }
}
