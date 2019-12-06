package com.lzhlyle.leetcode.self.no231;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & (n - 1)) == 0;
    }
}
