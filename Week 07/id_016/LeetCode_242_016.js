/*
 * @Description: This is a description
 * @Author: Ask
 * @LastEditors: Ask
 * @Date: 2019-12-01 18:26:22
 * @LastEditTime: 2019-12-01 18:26:28
 */
/*
 * @lc app=leetcode id=242 lang=javascript
 *
 * [242] Valid Anagram
 *
 * https://leetcode.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (53.77%)
 * Likes:    965
 * Dislikes: 124
 * Total Accepted:    432.4K
 * Total Submissions: 796.2K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * Given two strings s and t , write a function to determine if t is an anagram
 * of s.
 * 
 * Example 1:
 * 
 * 
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your
 * solution to such case?
 * 
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
// var isAnagram = function(s, t) {
//     if(s.length!=t.length) return false;
//     let temp = t.split("");
//     for(let i = 0; i < s.length; i++){
//         let index = temp.indexOf(s[i]);
//         if(index>-1){
//             temp.splice(index,1);
//         }
//     }
//     return !temp.length
// };

var isAnagram = function(s, t) {
    if(s.length !== t.length) return false;
    let ts = s.split("").sort().join("");
    let tt = t.split("").sort().join("");
    
    return tt === ts
};
// @lc code=end

