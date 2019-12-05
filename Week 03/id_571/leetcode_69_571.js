/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
  if (x === 0 || x === 1) return x;
  let left = 1,
    right = x;
  while (left <= right) {
    let mid = left + ((right - left) >>> 1);
    if (mid * mid > x) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }
  return right;
};
