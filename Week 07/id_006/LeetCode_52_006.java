package com.mrglint.leetcode.week07.solution52;

/**
 * 使用一个32位的int来标记
 *
 * @author luhuancheng
 * @since 2019-11-26 08:49
 */
public class Solution {

    private int size;
    private int count;

    public int totalNQueens(int n) {
        count = 0;
        size = ( 1 << n) - 1;
        solve(0, 0, 0);
        return count;
    }

    private void solve(int row, int ld, int rd) {
        if (row == size) {
            count++;
            return;
        }
        int pos = size & (~(row | ld | rd));

        while (pos != 0) {
            int p = pos & (-pos);
            pos -= p;
            solve(row | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }

    private String toBinaryRepresent(int n) {
        int[] buffer = new int[32];
        for (int i = 0; i < 32; i++) {
            buffer[31 - i] = n & 1;
            n = n >> 1;
        }
        StringBuilder res = new StringBuilder();
        for (int i : buffer) {
            res.append(i);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.totalNQueens(4);
        System.out.println(res);
        // 原码：00000000000000000000000000000100
        // 反码：00000000000000000000000000000100
        // 补码：00000000000000000000000000000100
        // int input = 4;

        // 原码：10000000000000000000000000000100  最高位作为符号位，置为1
        // 反码：11111111111111111111111111111011  符号位不变，其余位取反
        // 补码：11111111111111111111111111111100  在反码的基础上加1
//        int input = 4 & -4;
//        input = 4 - input;
//        int[] buffer = new int[32];
//        for (int i = 0; i < 32; i++) {
//            buffer[31 - i] = input & 1;
//            input = input >> 1;
//        }
//        StringBuilder res = new StringBuilder();
//        for (int i : buffer) {
//            res.append(i);
//        }
//        System.out.println(res.toString());
    }

}

