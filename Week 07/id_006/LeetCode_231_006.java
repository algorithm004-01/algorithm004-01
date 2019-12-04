package com.mrglint.leetcode.week07.solution231;

/**
 * @author luhuancheng
 * @since 2019-11-25 08:36
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n != 0 && (n & (n - 1)) == 0;
    }
}

