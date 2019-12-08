package cn.jomoon.nov03;

import java.util.Arrays;

public class LeetCode455 {
    public static void main(String[] args) {
        new LeetCode455().findContentChildren(new int[]{1,2,3},new int[]{3});
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int usedIndex = 0;
        for (int i = 0; i < g.length; i++) {
            int greedy = g[i];
            for (; usedIndex < s.length;) {
                if (s[usedIndex++] >= greedy) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }


    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0,si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
}
