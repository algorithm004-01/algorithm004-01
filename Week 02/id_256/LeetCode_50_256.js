/*
 * @lc app=leetcode.cn id=50 lang=javascript
 *
 * [50] Pow(x, n)
 */

// @lc code=start
/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function(x, n) {
    //暴力
    // if(n == 0) return 1;
    // let result = x;
    // let temp = n;
    // if(n < 0) {
    //     temp = Math.abs(n);
    // }
    // while(temp > 1) {
    //     result *= x;
    //     temp--;
    // }
    // return n < 0 ? 1/result : result;
    // 暴力二
    // if(n == 0) return 1;
    // let N = n;
    // if(n < 0) {
    //     N = -n;
    //     x = 1 / x;
    // }
    // let result = 1;
    // for (let i = 0; i < N; i++) {
    //     result *= x;
    // }
    // return result;
    // 快递递归幂
    if (n < 0) {
      n = -n;
      x = 1 / x;
    }
    return fastPow(x, n);
  };
  var fastPow = function(x, n) {
    if (n == 0) {
      return 1;
    }
    let half = fastPow(x, parseInt(n / 2));
    if (n % 2 == 0) {
      return half * half;
    } else {
      return half * half * x;
    }
  };
  // @lc code=end
  