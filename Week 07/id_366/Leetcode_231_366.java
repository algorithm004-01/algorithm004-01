/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        boolean flag = false;
        if ((n & (n - 1)) == 0 && n > 0) {
                flag = true;         
        }
        return flag;
    }
}
// @lc code=end

