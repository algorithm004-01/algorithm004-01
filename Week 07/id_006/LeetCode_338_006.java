package com.mrglint.leetcode.week07.solution338;

/**
 * @author luhuancheng
 * @since 2019-11-27 07:50
 */
public class Solution {
    /**
     * pop count 解法
     * @param num
     * @return
     */
    public int[] countBits1(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = popCount(i);
        }
        return res;
    }
    private int popCount(int i) {
        int count = 0;
        while (i > 0) {
            i = i & (i - 1);
            count++;
        }
        return count;
    }

    /**
     * DP解法 最高有效位
     * @param num
     * @return
     */
    public int[] countBits2(int num) {
        // 0 0000
        // 1 0001
        // 2 0010
        // 3 0011
        // 4 0100
        // 5 0101
        // 6 0110
        // 7 0111
        // 8 1000
        // 9 1001
       // 10 1010
       // 11 1011
       // 12 1100
       // 13 1101
       // 14 1110
       // 15 1111

        // [0, 1] -> [2, 3]
        // [0, 3] -> [4, 7]
        // [0, 7] -> [8, 15]

        // 动态转移方程：f(x + b) = f(x) + 1; b = 2^m;
        int[] res = new int[num + 1];
        // 定义状态
        int i = 0;
        int b = 1;
        // 动态推导
        while (b <= num) {
            // b  = 2 ^ m <= num
            while (i < b && i + b <= num) {
                res[i + b] = res[i] + 1;
                i++;
            }
            i = 0;
            b <<= 1;
        }
        return res;
    }

    public int[] countBits3(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.countBits(4);
    }
}

