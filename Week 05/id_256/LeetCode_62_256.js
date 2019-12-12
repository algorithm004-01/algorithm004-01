/*
 * @lc app=leetcode.cn id=62 lang=javascript
 *
 * [62] 不同路径
 */

// @lc code=start
/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
  // 方法一二维递推
  //   let arr = new Array(n);
  //   for (let i = 0; i < n; i++) {
  //     let m_arr = new Array(m);
  //     arr[i] = m_arr;
  //   }
  //   for (let i = 1; i <= n; i++) {
  //     for (let j = 1; j <= m; j++) {
  //       if (i == 1 || j == 1) {
  //         arr[n - i][m - j] = 1;
  //       } else {
  //         arr[n - i][m - j] = arr[n - i][m - j + 1] + arr[n - i + 1][m - j];
  //       }
  //     }
  //   }
  //   return arr[0][0];
  // 方法二 一维递推
  let temp_arr = new Array(n);
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (i == 0 || j == 0) {
        temp_arr[j] = 1;
      } else {
        temp_arr[j] = temp_arr[j] + temp_arr[j - 1];
      }
    }
  }
  return temp_arr[n - 1];
};
// @lc code=end
