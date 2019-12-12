import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int scount = 0,gcount = 0;
        while(scount < s.length && gcount < g.length){
            if(g[gcount] <= s[scount]){
                gcount++;
            }
            scount++;
        }
        return gcount;
    }
}
// @lc code=end

