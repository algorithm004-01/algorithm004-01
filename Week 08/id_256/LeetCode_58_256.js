/*
 * @lc app=leetcode.cn id=58 lang=javascript
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
    let letters = s.split(' ');
    if(letters.length == 0) return 0;
    while(letters.length > 0 && letters[letters.length-1] == "") {
        letters.pop();
    }
    if(letters.length == 0) return 0;
    return letters[letters.length-1].length;
};
// @lc code=end

