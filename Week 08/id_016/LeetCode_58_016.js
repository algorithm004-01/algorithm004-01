/*
 * @Description: This is a description
 * @Author: Ask
 * @LastEditors: Ask
 * @Date: 2019-12-08 22:17:13
 * @LastEditTime: 2019-12-08 22:17:19
 */
/*
 * @lc app=leetcode id=58 lang=javascript
 *
 * [58] Length of Last Word
 *
 * https://leetcode.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (32.32%)
 * Likes:    476
 * Dislikes: 1959
 * Total Accepted:    316.3K
 * Total Submissions: 977.5K
 * Testcase Example:  '"Hello World"'
 *
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * Example:
 * 
 * 
 * Input: "Hello World"
 * Output: 5
 * 
 * 
 * 
 * 
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
  let res = 0;
  s = s.replace(/\s+$/g, "");
  for (let i = s.length - 1; i >= 0; i--) {
    if (s[i] === " ") break;
    res++;
  }
  return res;
};
// @lc code=end

