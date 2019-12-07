/**
 * @param {number} num
 * @return {boolean}
 */
var isPerfectSquare = function(num) {
  if (num === 0 || num === 1) return true;
  let left = 1,
    right = num;
  while (left <= right) {
    let mid = left + ((right - left) >>> 1);
    if (mid * mid === num) {
      return true;
    } else if (mid * mid > num) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }
  return false;
};
