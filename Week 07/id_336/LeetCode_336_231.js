// 解法：2的幂数的数字的二进制特点 + 位操作
// 2的幂数的数字的二进制有且只有一个1，其余均是0
// n & (n-1)：清零最低位的1
// 合起来 n & (n-1) == 0
/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
    return n > 0 && (n & (n-1)) == 0;
};
