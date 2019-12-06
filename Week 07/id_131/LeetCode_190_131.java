package com.lzhlyle.leetcode.self.no190;

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0b0, i = 0;
        while (i++ < 32) res = (res << 1) | ((n >>> (i - 1)) & 1);
        return res;
    }
}
