/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    public int[] countBits(int num) {
        int[]
        f = new int[num  + 1];
        for (int i = 1; i <= num; i++) f[i] = f[i >> 1] + ( i & 1);
        return f;
        
    }
}
// @lc code=end

