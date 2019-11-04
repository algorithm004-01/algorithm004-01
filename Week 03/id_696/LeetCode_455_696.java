package week03;

import java.util.Arrays;

public class LeetCode_455_696 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length;) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                result++;
            } else {
                j++;
            }
        }
        return result;
    }
}
