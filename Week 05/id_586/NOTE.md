# 动态规划

动态规划和 递归/分治没有根本的区别（关键是看有没有最优子结构）

共性： 找到重复的子问题
差异性： 最优子结构，中途可以淘汰次优解

1. 可以用数组缓存中间值

## Fibonacci数列

```c
/* O(2^n) 指数级 分治 */
int fib(int n) {
    if (n <= 0) return 0;
    else if (n == 1) return 1;
    else return fib(n - 1) + fib(n - 2);
}

/* 加缓存： 记忆化搜索
 * O(n)
 */
int memo[1024] = {0};
int fib(int n) {
    if (n <= 1) return n;

    if (memo[n] == 0)
        memon[n] = fib(n - 1) + fib(n - 2);

    return memon[n];
}

/* 自底向上递推 -- 数学归纳法
 * f(n) = f(n - 1) + f(n - 2)
 */
int fib(int n) {
    if (n <= 1) return n;
    a[0] = 0, a[1] = 1;
    for (int i = 2; i <= n; i++) {
        a[i] = a[i - 1] + a[i - 2];
    }
    return a[n];
}
```

## 62 路径计数

取舍最优子结构？

```cpp

int countPaths( frid, int row, int col) {

}

```

## 不同路径题目

```cpp


```

## 不同路径 2 题目

## 最长公共子序列题目

## MIT 动态规划课程最短路径算法


DP

- 重复性（分治）   problem(i, j) = min(sub(i + 1, j), sub(i + 1, j + 1) + a[i, j])
- 定义状态数组  f(i, j)
- DP 方程       f(i, j = ) = min(f(i + 1, j), f(i + 1, j + 1) + a[i, j])
 

```cpp
// triangle : https://leetcode-cn.com/problems/triangle/description/
class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        vector<int> dp(triangle.back());
        
        for (int layer = triangle.size() - 2; layer >=0 ; --layer) {
            for (int j = 0; j <= layer; ++j)
                dp[j] = min(dp[j], dp[j + 1]) + triangle[layer][j];
        }
        
        return dp[0];
    }
};
```

```c
// https://leetcode-cn.com/problems/maximum-subarray/
// 1. 重复性（分治）   max_sum(i) = max(max_sum(i - 1), 0) + a[i];
// 2. 定义状态数组  f(i, j)
// 3. DP 方程  f(i) = max(f(i - 1), 0) + a[i]




```

```c
// https://leetcode-cn.com/problems/coin-change/description/
// 1. 重复性（分治）   max_sum(i) = max(max_sum(i - 1), 0) + a[i];
// 2. 定义状态数组 f(n) = min(f(n - k) (k in array)) + 1
// 3. DP 方程  f(i)


```

```c
// https://leetcode-cn.com/problems/house-robber/
// 1. 重复性（分治）   max_sum(i) = max(max_sum(i - 1), 0) + a[i];
// 2. 定义状态数组 f(n) = min(f(n - k) (k in array)) + 1
// 3. DP 方程  f(i)

// a[i] : 0..i 能偷的最大值 a[n - 1]
// a[i][0,1] 0: 偷, 1：不偷
```


    https://leetcode-cn.com/problems/climbing-stairs/description/
    https://leetcode-cn.com/problems/triangle/description/
    https://leetcode.com/problems/triangle/discuss/38735/Python-easy-to-understand-solutions-(top-down-bottom-up)
    https://leetcode-cn.com/problems/maximum-subarray/
    https://leetcode-cn.com/problems/maximum-product-subarray/description/
    https://leetcode-cn.com/problems/coin-change/description/

实战题目

    https://leetcode-cn.com/problems/house-robber/
    https://leetcode-cn.com/problems/house-robber-ii/description/
    https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/#/description
    https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
    https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
    https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
    https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
    https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
    https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/

高级 DP 实战题目

    https://leetcode-cn.com/problems/perfect-squares/
    https://leetcode-cn.com/problems/edit-distance/ （重点）
    https://leetcode-cn.com/problems/jump-game/
    https://leetcode-cn.com/problems/jump-game-ii/
    https://leetcode-cn.com/problems/unique-paths/
    https://leetcode-cn.com/problems/unique-paths-ii/
    https://leetcode-cn.com/problems/unique-paths-iii/
    https://leetcode-cn.com/problems/coin-change/
    https://leetcode-cn.com/problems/coin-change-2/

注意：请大家先消化前面的实战题目，高级 DP 的方法和题解会在课程后面解锁。
课后作业

    https://leetcode-cn.com/problems/longest-valid-parentheses/
    https://leetcode-cn.com/problems/minimum-path-sum/
    https://leetcode-cn.com/problems/edit-distance/
    https://leetcode-cn.com/problems/decode-ways
    https://leetcode-cn.com/problems/maximal-square/
    https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
    https://leetcode-cn.com/problems/frog-jump/
    https://leetcode-cn.com/problems/split-array-largest-sum
    https://leetcode-cn.com/problems/student-attendance-record-ii/
    https://leetcode-cn.com/problems/task-scheduler/
    https://leetcode-cn.com/problems/palindromic-substrings/
    https://leetcode-cn.com/problems/minimum-window-substring/
    https://leetcode-cn.com/problems/burst-balloons/

