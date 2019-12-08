package com.mrglint.leetcode.week07.solution191;

/**
 * @author luhuancheng
 * @since 2019-11-25 08:07
 */
public class Solution {

    /**
     * 二进制表示：
     * 11000 - 1 = 10111
     * 11000 & 10111 = 10000 打掉了一个1，
     * 循环这两步操作，并记录循环次数。直到值为0，循环次数即为1的个数
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}

