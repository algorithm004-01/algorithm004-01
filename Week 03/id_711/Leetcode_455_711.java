package Week3;

import java.util.Arrays;

public class Leetcode_455_711 {
    public static void main(String[] args) {
        int[] g = {1,1,3};
        int[] s = {1,1};
        System.out.println(findContentChildren(g,s));
    }

    /**
     *
     * 执行用时 :10 ms, 在所有 java 提交中击败了99.34%的用户
     * 内存消耗 :39.2 MB, 在所有 java 提交中击败了96.14%的用户
     * @param g
     * @param s
     * @return
     */
    private static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int x = 0, y = 0;
        int ans = 0;
        while (x < g.length && y < s.length) {
            if (s[y] >= g[x]) {
                ans++;
                x++;
                y++;
            }
            else {
                y++;
            }
        }
        return ans;
    }
}
