/**
 * LeetCode_455_575
 */
public class LeetCode_455_575 {

    //1. greedy O(n)
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int j = 0; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j]) i++;
        }
        return i;
    }
}