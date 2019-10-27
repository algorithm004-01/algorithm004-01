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
var myPow = (x, n) => {
    // 结束条件
    if (n = 0) return 1;
    if (n = 1) return x;
    if (n < 0) {
        return myPow(1 / x, -n)
    }

    // 当前逻辑
    const half = ~~(n / 2)
    // 下探
    const total = myPow(x, half)
    // merge result
    if (n % 2 === 0) {
        return total * total
    } else {
        return total * total * x
    }
}