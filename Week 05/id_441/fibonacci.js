// 斐波那契代码
function fib (n, memo) {
    if( n < 0) {
        return 0
    }else if(n === 1) {
        return 1
    }else if(memo[n] === 0){
        memo[n] = fib(n-1) + fib(n-2)
    }
    return memo[n]
}
function fib (n, memo) {
    if(n<=1) {
        return n;
    }
    if(!memo[n]){
        memo[n] = fib(n-1)+fib(n-2)
    }
    return memo[n]
}
function fib (n){
    let a = [0,1]
    console.log()
    for(let i =2; i<n; ++i){
        console.log(a[i])
        a[i] = a[i-1]+a[i-2]
    }
    return a[n]
}
fib(3)

// 二维的fib格子走法
// 一维的递推： f(n) = f(n-1) + f(n-2)
// 二维的递推公式： f(i,j) = f(i-1,j)+f(i,j-1)
function fib(m,n){
    // 初始化x轴和y轴
    let a = [[],[]]
    for(let i =0 ; i<10; ++i) {
        a.push([])
        a[i][0] = 1
    }
    for(let j =0; j<10; ++j) {
        a[0][j] = 1
    }
    console.log(a)
    for(let  j=0; j<m;  ++j){
        for(let k=0; k<n; ++k){
            a[j][k] = a[j-1][k] + a[j][k-1]
        }
    }
    return a[m-1][n-1]
}

let a = [[],[]]
    for(let i =0 ; i<10; ++i) {
        a.push([])
        a[i][0] = 1
    }
    for(let j =0; j<10; ++j) {
        a[0][j] = 1
    }
    console.log(a)
