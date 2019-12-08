/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
  let helper = n & (n - 1);
  return n > 0 && helper === 0;
};

isPowerOfTwo(2);
