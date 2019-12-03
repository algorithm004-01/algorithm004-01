// 二维的fib格子走法
// 一维的递推： f(n) = f(n-1) + f(n-2)
// 二维的递推公式： f(i,j) = f(i-1,j)+f(i,j-1)

var uniquePaths = function (m, n) {
    // 初始化x轴和y轴
    let a = []
    let b = []
    for (let i = 0; i < n; i++) {
        b.push(1)
    }
    for (let i = 0; i < m; i++) {
        a.push(b)
    }
    for (let i = 1; i < m; ++i) {
        for (let j = 1; j < n; ++j) {
            console.log(a[i][j], i, j)
            a[i][j] = a[i - 1][j] + a[i][j - 1]
        }
    }
    return a[m - 1][n - 1]

};
uniquePaths(3, 2)