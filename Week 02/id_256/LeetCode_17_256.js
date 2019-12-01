/*
 * @lc app=leetcode.cn id=17 lang=javascript
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    //回溯
    if(!digits) return [];
    let letters_map = ['','','abc','def','ghi','jkl','mno','qprs','tuv','wxyz'];
    let res = [];
    dfs(res, digits, letters_map, '');
    return res;
};
let dfs = function(res, digits, letters_map, tmp) {
    if (tmp.length == digits.length) {
        res.push(tmp);
        return;
    }
    let currLetters = letters_map[parseInt(digits[tmp.length])];
    for (let i = 0; i < currLetters.length; i++) {
        tmp = tmp + currLetters[i];
        dfs(res, digits, letters_map, tmp);
        tmp = tmp.substring(0, tmp.length - 1);
    }
}
// @lc code=end

