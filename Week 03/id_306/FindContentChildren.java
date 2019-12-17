import java.util.Arrays;

/**
 * Created by LynnSun on 2019/10/31.
 * 力扣题目地址：https://leetcode-cn.com/problems/assign-cookies/description/
 */
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0, r = 0,res = 0;
        while (l < g.length && r < s.length) {
            if (g[l] <= s[r]) {
                l++;
                res++;
            }
            r++;
        }
        return res;
    }
}
