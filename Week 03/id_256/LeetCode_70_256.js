/*
 * @lc app=leetcode.cn id=70 lang=javascript
 *
 * [70] 爬楼梯
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    //方法一 暴力
//   let dfs = function(start, n) {
//     if (start > n) {
//       return 0;
//     } else if (start === n) {
//       return 1;
//     }
//     return dfs(start + 1, n) + dfs(start + 2, n);
//   };
//   return dfs(0, n);
   //方法二
   let valueMap = {};
   valueMap['1'] = 1;
   valueMap['2'] = 2;
   for (let i = 3; i <= n; i ++) {
       valueMap[`${i}`] =  valueMap[`${i-1}`] + valueMap[`${i-2}`];
   }
   return valueMap[`${n}`];
};

// @lc code=end
