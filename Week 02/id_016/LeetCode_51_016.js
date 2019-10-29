/*
 * @Description: This is a description
 * @Author: Ask
 * @LastEditors: Ask
 * @Date: 2019-10-26 12:01:34
 * @LastEditTime: 2019-10-26 15:25:45
 */
/*
 * @lc app=leetcode id=51 lang=javascript
 *
 * [51] N-Queens
 *
 * https://leetcode.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (41.73%)
 * Likes:    1227
 * Dislikes: 57
 * Total Accepted:    163.8K
 * Total Submissions: 390K
 * Testcase Example:  '4'
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 *
 *
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 *
 * Example:
 *
 *
 * Input: 4
 * Output: [
 * ⁠[".Q..",  // Solution 1
 * ⁠ "...Q",
 * ⁠ "Q...",
 * ⁠ "..Q."],
 *
 * ⁠["..Q.",  // Solution 2
 * ⁠ "Q...",
 * ⁠ "...Q",
 * ⁠ ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as
 * shown above.
 *
 *
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string[][]}
 */
// var solveNQueens = function(n) {
//   let res = [];
//   let cols = [];
//   let pie = []; // 存储插入点行列相加的和
//   let na = []; // 存储插入点行-列的差
//   let deal = (n, row, temp) => {
//     // terminator
//     if (row >= n) {
//       res.push(temp);
//       return;
//     }
//     // process logic in current level
//     let pItem, naItem;
//     for (let col = 0; col < n; col++) {
//       console.log(row,col)
//       pItem = col + row;
//       naItem = row - col;
//       if (
//         cols.indexOf(col) > -1 ||
//         pie.indexOf(pItem) > -1 ||
//         na.indexOf(naItem) > -1
//       ) {
//         continue;
//       }
//       cols.push(col);
//       pie.push(pItem);
//       na.push(naItem);

//       // drill down
//       deal(n, row + 1, [...temp, [row, col]]);

//       // reverse state
//       cols.pop();
//       pie.pop();
//       na.pop();
//     }
//   };

//   deal(n, 0, []);
//   console.log(res);

//   let write = () => {
//     return res.map(item => {
//       return item.map(it => {
//         let cur = new Array(n).fill('.');
//         cur.splice(it[1], 1, 'Q');
//         return cur.join('');
//       });
//     });
//   };
//   return write();
// };
var solveNQueens = function(n) {
  let res = [];
  let deal = (row, temp) => {
    // terminator
    if (row === n) {
      res.push(
        temp.map(item => '.'.repeat(item) + 'Q' + '.'.repeat(n - item - 1))
      );
      return;
    }
    // process logica
    for (let col = 0; col < n; col++) {
      // 轮空逻辑
      if (
        temp.some(
          (co, ro) =>
            co === col || ro + co === row + col || ro - co === row - col
        )
      ) {
        continue;
      }
      // drill down - 下探
      deal(row + 1, [...temp, col]);
      // reverse state 回溯回来的时候,去掉当前的值
    }
  };
  deal(0, []);
  return res;
};
// @lc code=end
console.log(solveNQueens(4));
