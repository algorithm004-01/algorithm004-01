// https://leetcode-cn.com/problems/powx-n/
// x的n次方。
// 暴力
var myPow = function (x, n) {
    let xN = x
    if (n === 0) return 1;
    if (n === 1) return x;
    if (n === -1) return 1 / x;
    // if(n === -1)
    if (n > 0) {
        while (n - 1) {
            x = x * xN;
            n--
        }
    } else {
        while (n + 1) {
            x = x * xN;
            n++
        }
        x = 1 / x
    }
    return x
}
// 分治
// 1.子问题结束，2，处理当前逻辑，3，下探，merge result 4，清除当前层
var myPow = function (x, n) {
    let N = n
    if (N < 0) {
        x = 1 / x;
        N = -N;
    }
    return cPow(x, N);
}
function cPow(x, n) {
    if (n === 0) return 1;
    if (n === 1) return x;
    if (n === -1) return 1 / x;
    const pow = cPow(x, n / 2)
    if (n % 2 === 0) {
        return pow * pow
    } else {
        return pow * pow * x
    }
}