/*
 * @lc app=leetcode.cn id=231 lang=javascript
 *
 * [231] 2的幂
 */

// @lc code=start
/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
    //位运算
    // 2的幂数的数字的二进制有且只有一个1，其余均是0 
    return n > 0 && n & (n-1) == 0;
};
// @lc code=end

