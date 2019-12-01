/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
  let memo = [];
  helper(0, n, [], [], [], [], memo);
  return format(memo);
};

var helper = function(row, n, cols, left, right, state, memo) {
  if (row >= n) {
    memo.push(state);
    return;
  }
  for (let col = 0; col < n; col++) {
    if (cols[col] || left[row + col] || right[row - col]) continue;
    cols[col] = true;
    left[row + col] = true;
    right[row - col] = true;
    helper(row + 1, n, cols, left, right, state.concat([col]), memo);
    cols[col] = false;
    left[row + col] = false;
    right[row - col] = false;
  }
};

var format = function(memo) {
  let result = [];
  for (let arr of memo) {
    let ele = [];
    for (let pos of arr) {
      ele.push(".".repeat(pos) + "Q" + ".".repeat(arr.length - pos - 1));
    }
    result.push(ele);
  }
  return result;
};

solveNQueens(4);
