/*
 * @lc app=leetcode.cn id=191 lang=javascript
 *
 * [191] 位1的个数
 */

// @lc code=start
/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
    let sum = 0;
    while( n != 0) {
        //清零最低位的1
        n &= (n-1);
        sum++;
    }
    return sum;
};
// @lc code=end

