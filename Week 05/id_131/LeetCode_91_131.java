package com.lzhlyle.leetcode.self.no91;

public class DecodeWays_2 {
    public int numDecodings(String s) {
        // base condition
        if (s == null || s.length() < 1 || s.startsWith("0")) return 0;

        char[] chars = s.toCharArray();
        int f0 = 0, f1 = 1;
        for (int i = 1; i < chars.length; i++) {
            int a1 = (chars[i] > '0') ? f0 + f1 : 0;
            int a0 = (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] <= '6')) ? f1 : 0;

            f1 = a1;
            f0 = a0;
        }
        return f0 + f1;
    }
}
