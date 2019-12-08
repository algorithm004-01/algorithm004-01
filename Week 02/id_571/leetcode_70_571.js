/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
  let memo = Array(n + 1);
  memo[1] = 1;
  memo[2] = 2;
  return helper(n, memo);
};

var helper = function(n, memo) {
  if (n <= 0) return 0;
  if (memo[n]) return memo[n];
  memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
  return memo[n];
};
