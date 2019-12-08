/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
  let result = [];
  helper(0, 0, n, "", result);
  return result;
};

var helper = function(left, right, n, s, memo) {
  //   terminate
  if (left === n && right === n) {
    memo.push(s);
    return;
  }
  //   process logic
  //   drill down
  if (left < n) helper(left + 1, right, n, s + "(", memo);
  if (right < left) helper(left, right + 1, n, s + ")", memo);
  //   reverse state
};
