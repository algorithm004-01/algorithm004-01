/* 
 * 假设你正在爬楼梯，需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶，你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 1. 递归的方法：运行超时
 * 
 *      递归公式为 ： f(n) = f(n - 1) + f(n - 2)
 *      f(1) = 1
 *      f(2) = 2
 * 2. 迭代方法: 斐波那契数
 *      使用中间变量存储中间值
 * 
 * 3. 在上一种方法中，我们计算每一步的结果时出现了冗余。另一种思路是，我们可以把每一步的结果存储在 memo 数组之中，每当函数再次被调用，我们就直接从 memo 数组返回结果
 * */
int climbStairs(int n){

#if 0
    /* 暴力递归 */
    if (n <= 2) return n;
    return climbStairs(n - 1) + climbStairs(n - 2);
#else
    /* 斐波那契数 */
    if (n <= 2) return n;
    int arg1 = 1;
    int arg2 = 2;
    int i, ret;
    for(i = 3; i <= n; i++) {
        ret = arg1 + arg2;
        arg1 = arg2;
        arg2 = ret;
    }
    return ret;

#endif
}