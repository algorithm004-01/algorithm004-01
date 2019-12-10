import java.util.*;
/**
 * 分发饼干
 */
public class Solution {
    /**
     * 分发饼干
     */
    public int findContentChildren(int[] g, int[] s) {
        int sum = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = s.length - 1, j = g.length - 1; i >= 0 && j >= 0; ) {
            if (s[i] >= g[j]) {
                sum++;
                i--;
            }
            j--;
        }
        return sum;
    }

    /**
     * 分发饼干
     * (改进版)
     */
    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
}