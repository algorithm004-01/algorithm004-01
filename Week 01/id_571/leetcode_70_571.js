/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
  if (n <= 2) return n;
  let f1 = 1,
    f2 = 2,
    f3 = 3;
  for (let i = 3; i < n; i++) {
    f1 = f2;
    f2 = f3;
    f3 = f1 + f2;
  }
  return f3;
};
