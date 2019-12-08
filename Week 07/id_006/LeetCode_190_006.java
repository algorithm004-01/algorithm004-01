package com.mrglint.leetcode.week07.solution190;

/**
 * @author luhuancheng
 * @since 2019-11-25 08:42
 */
public class Solution {

    public int reverseBits1(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // result << 1左移一位，为补上来的n的最后一位留出空间
            result = (result << 1) + (n & 1);
            // n >> 1 右移一位，将下一次要补上到result最后一位的值，移动到n的最后一位，下一次循环通过 n & 1获得
            n = n >> 1;
        }
        return result;
    }

    /**
     * 循环32次
     * 1. 空出一位
     * 2. 空出的一位置换为n的最后一位
     * 3. n的最后一位替换为倒数第二位
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= n & 1;
            n >>= 1;
        }
        return result;
    }
}

