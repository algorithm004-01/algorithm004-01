package com.mrglint.leetcode.week03.solution455;

import java.util.Arrays;

/**
 * @author luhuancheng
 * @since 2019-11-03 22:17
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) {
            return 0;
        }
        // 从小到大排序
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int childrenIndex = 0;
        int cookieIndex = 0;
        while (childrenIndex < g.length && cookieIndex < s.length) {
            if (s[cookieIndex] < g[childrenIndex]) {
                cookieIndex++;
            } else {
                cookieIndex++;
                childrenIndex++;
                count++;
            }
        }
        return count;
    }
}

