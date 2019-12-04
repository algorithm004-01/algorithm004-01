/* 
若 n = 2^x
x 且 x 为自然数（即 n 为 2 的幂），则一定满足以下条件
n 二进制最高位为 1，其余所有位为 0；
(n−1) 二进制最高位为 0，其余所有位为 1； 
*/
var isPowerOfTwo = function(n) {
  return n > 0 && (n & (n - 1)) == 0
};