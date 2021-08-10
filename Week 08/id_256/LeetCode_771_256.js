/*
 * @lc app=leetcode.cn id=771 lang=javascript
 *
 * [771] 宝石与石头
 */

// @lc code=start
/**
 * @param {string} J
 * @param {string} S
 * @return {number}
 */
var numJewelsInStones = function(J, S) {
    let J_arr = [...J];
    let S_arr = [...S];
    let count = 0;
    S_arr.forEach(key => {
        if(J_arr.indexOf(key) >= 0) {
            count ++;
        }
    })
    return count;
};
// @lc code=end

