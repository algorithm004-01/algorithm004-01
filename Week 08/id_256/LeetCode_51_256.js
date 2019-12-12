/*
 * @lc app=leetcode.cn id=51 lang=javascript
 *
 * [51] N皇后
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
  //方法一 回溯
  let col = new Array(n).fill(false);
  let left = new Array(n * 2).fill(false);
  let right = new Array(n + 2).fill(false);
  let board = Array.from({ length: n }, () =>
    Array.from({ length: n }, () => ".")
  );
  let res = [];
  var backtrack = function(i) {
    if (i === n) {
      res.push(board.map(row => row.join("")));
      return res;
    }
    for (let j = 0; j < n; j++) {
      let l = i + j;
      let r = j - i + n - 1;
      if (!col[j] && !left[l] && !right[r]) {
        board[i][j] = "Q";
        col[j] = true;
        left[l] = true;
        right[r] = true;
        backtrack(i + 1);
        board[i][j] = ".";
        col[j] = false;
        left[l] = false;
        right[r] = false;
      }
    }
  };
  backtrack(0);
  return res;
};
// @lc code=end
