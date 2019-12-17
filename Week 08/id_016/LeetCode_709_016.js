/*
 * @Description: This is a description
 * @Author: Ask
 * @LastEditors: Ask
 * @Date: 2019-12-08 21:21:08
 * @LastEditTime: 2019-12-08 21:21:24
 */
/*
 * @lc app=leetcode id=709 lang=javascript
 *
 * [709] To Lower Case
 *
 * https://leetcode.com/problems/to-lower-case/description/
 *
 * algorithms
 * Easy (77.72%)
 * Likes:    360
 * Dislikes: 1250
 * Total Accepted:    165.5K
 * Total Submissions: 211.9K
 * Testcase Example:  '"Hello"'
 *
 * Implement function ToLowerCase() that has a string parameter str, and
 * returns the same string in lowercase.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "Hello"
 * Output: "hello"
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "here"
 * Output: "here"
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "LOVELY"
 * Output: "lovely"
 * 
 * 
 * 
 * 
 */

// @lc code=start
/**
 * @param {string} str
 * @return {string}
 */
// [a,z] = [97,122]
// [A,Z] = [65,90]
// var toLowerCase = function(str) {
//    let res = "";
//    let code;
//    for(let i = 0; i < str.length; i++){
//        code = str.charCodeAt(i);
//        if(code>=65 && code <= 90){
//            res += String.fromCharCode(code+32);
//            continue;
//        }
//        res += str[i];
//    } 
//    return res;
// };

// 大写变小写、小写变大写 : ASCII码 ^= 32
// 大写变小写、小写变小写 : ASCII码 |= 32
// 小写变大写、大写变大写 : ASCII码 &= -33
var toLowerCase = function(str) {
   let res = "";
   for(let i = 0; i < str.length; i++){
        res += String.fromCharCode(str.charCodeAt(i) | 32);
   } 
   return res;
};
// @lc code=end

