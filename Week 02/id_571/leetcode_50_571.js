/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function(x, n) {
  if (n < 0) {
    x = 1 / x;
    n = -n;
  }
  //   terminator
  if (n === 0) return 1.0;
  //   process current logic split problems
  //   drill down, merge
  let subresult = myPow(x, n >>> 1);
  if (n & (1 === 1)) {
    return subresult * subresult * x;
  } else {
    return subresult * subresult;
  }
  //   reverse state
};
