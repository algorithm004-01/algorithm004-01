package com.lzhlyle.leetcode.self.no338;

public class CountingBits_2 {
    // dp
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}