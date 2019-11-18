/*
 * @lc app=leetcode.cn id=77 lang=javascript
 *
 * [77] 组合
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {
    //循环匹配
    if(k == 0 || k > n) return [[]];
    let result = [];
    let temp = [];
    return dfs(1, n, k, result, temp);
 };
 var dfs = function(start, n, k, result, temp) {
   if(temp.length == k) {
     result.push([...temp]);
     return;
   }
   for (let i = start; i < n+1; i++) {
     temp.push(i);
     dfs(i+1, n, k, result, temp);
     temp.pop();
   }
   return result;
 }
 // @lc code=end
 