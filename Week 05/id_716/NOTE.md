# NOTE

## 动态规划笔记

分治、递归、动态规划本质上是一样的。

- 误区

1. 人肉递归低效，很累，一定不要做人肉递归
2. 找到最近最简方法，将其拆解成可重复解决的问题；复杂的大问题肯定可以拆解成更小的多个子问题
3. 使用数学归纳法思维，抵制人肉递归；比如n=1，n=2时的情况，n和n+1之间的关系等
4. 本质：寻找重复性，转变成计算机指令集（if-else，loop，递归等）
5. 如果想要体验一下递归的话，画递归状态树

- 动态规划

动态规划的定义：[wiki Dynamic programming](https://en.wikipedia.org/wiki/Dynamic_programming)。把复杂的问题分解成简单的子问题，一般是采用递归的方式。等价于分治+最优子结构。

可以理解为动态递推。动态规划和分治或者递归没有根本性区别，关键看有无最优的子结构。共性是找到重复子问题。差异是最优子结构，中途可以淘汰次优解。

关键步骤：

1. 将原问题化繁为简成为子问题
2. 定义好状态空间
3. 找出DP方程，动态规划的方程

解决DP问题的两种常见方式是：递归+记忆化搜索（这个是自顶向下），另外一个是循环递推（这个是自底向上），建立DP Table bottom-up

- 题目

1. Fibonacci 数列
2. 路径计数 count the path  <https://leetcode-cn.com/problems/unique-paths/>  (done)
3. 路径计数II <https://leetcode-cn.com/problems/unique-paths-ii/> (done)
4. 最长公共子序列题目 <https://leetcode-cn.com/problems/longest-common-subsequence/>
5. <https://leetcode-cn.com/problems/climbing-stairs/description/>  如果可以走1，2，3步，该怎么解决；如果是相邻的两步不能相同，如何解决？
6. <https://leetcode-cn.com/problems/triangle/description/>  (done)
7. <https://leetcode.com/problems/triangle/discuss/38735/Python-easy-to-understand-solutions-(top-down-bottom-up)>
8. <https://leetcode-cn.com/problems/maximum-subarray/>  (done)
9. <https://leetcode-cn.com/problems/maximum-product-subarray/description/>  (done)
10. <https://leetcode-cn.com/problems/coin-change/description/>  (done)
11. https://leetcode-cn.com/problems/house-robber/
https://leetcode-cn.com/problems/house-robber-ii/description/
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/#/description
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/

高级DP题目：

https://leetcode-cn.com/problems/perfect-squares/
https://leetcode-cn.com/problems/edit-distance/ （重点）
https://leetcode-cn.com/problems/jump-game/
https://leetcode-cn.com/problems/jump-game-ii/
https://leetcode-cn.com/problems/unique-paths/
https://leetcode-cn.com/problems/unique-paths-ii/
https://leetcode-cn.com/problems/unique-paths-iii/
https://leetcode-cn.com/problems/coin-change/
https://leetcode-cn.com/problems/coin-change-2/

作业：

https://leetcode-cn.com/problems/longest-valid-parentheses/
https://leetcode-cn.com/problems/minimum-path-sum/  (done)
https://leetcode-cn.com/problems/edit-distance/
https://leetcode-cn.com/problems/decode-ways
https://leetcode-cn.com/problems/maximal-square/ (done)
https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
https://leetcode-cn.com/problems/frog-jump/
https://leetcode-cn.com/problems/split-array-largest-sum
https://leetcode-cn.com/problems/student-attendance-record-ii/
https://leetcode-cn.com/problems/task-scheduler/
https://leetcode-cn.com/problems/palindromic-substrings/
https://leetcode-cn.com/problems/minimum-window-substring/
https://leetcode-cn.com/problems/burst-balloons/

---

## 总结

### 【716-Week 05】分治、回溯、贪心和动态规划

本周是第五周，主要学习动态规划相关的内容，以前总有一个感觉是DP是一个很玄学的东西，不知所云。每每看到用动态规划解决问题的时候，就会觉得解法如此巧妙，但是却难以理解。而本周通过听讲解，做题，看解法，看相关文章和书籍，重新认识了动态规划。

本质上，动态规划是一种算法设计技巧，最终都会有一些可以复用的规律。动态规划是用来解决最优化问题的，所以一般情况下的最优化问题都可以使用它来解决。而动态规划相关的问题有一些套路，演化规律是：使用暴力递归解决 -> 使用带有备忘录的递归解决 -> 使用非递归的动态规划（自顶向下和自底向上）；整个过程是层层递进，从递归树中一点点找到可以重复利用的规律。

我们知道，适合用动态规划的最优化问题需要具备两个基本要素：最优子结构和重叠子问题，那么正确理解这两个基本要素是非常重要的。

- 最优子结构

怎么理解最优子结构呢？最优子结构意思是原问题的解由子问题的最优解构成，也就是说可以用子问题的最优解来推导出问题的最优解，仍然是很抽象。比如 Coin Change 问题，用 coins 中的哪个硬币之间并不会相互影响，子问题的解之间是相互独立的，也就是说 f(11) = f(10) + f(9) + f(6)，子问题 f(10)/f(9)/f(6) 之间是相互独立的且组合后可以推导出问题的解，这种性质就是说明该问题具备最优子结构的性质，这个很关键。

- 重叠子问题

这是另外一个DP的基本特性。在求解DP问题时，子问题的空间要足够小，递归算法会反复求解相同的子问题，而不是一直生成新的子问题，还是很抽象。比如求解斐波那契额数列时，计算 f(10), 需要计算 f(9) 和 f(8), 计算 f(9) 需要计算 f(8) 和 f(7), 可见子问题 f(8) 被重复计算了多次，而 f(8) 这种现象就是重叠子问题，以此类推，会有很多这样的重叠子问题，重叠子问题带来的坏处是大量的重复计算，要消去重叠子问题带来的影响，一种办法就是使用备忘录，通过查询备忘录减少重复计算。在动态规划中可以使用状态转移表。

除此之外，状态转移方程是解决DP问题时又一个重要的特点。我们从最优子结构特性可以知道通过递归求解子问题来得到问题的解，所以可以得到递归推导式，也可以叫做状态转移方程。一般有自顶向下的备忘录递归解法和自底向上的迭代推导解法。能够正确找到状态转移方程是解决DP问题的关键一步。

### 爬楼梯问题的升级

优秀题解参考：<https://shimo.im/docs/pXr9YwjPgpxdHrRT/read>

#### 题目

爬楼梯问题的原问题1：假设你正在爬楼梯，每次你可以爬 1 个或者 2 个台阶，你有多少种不同的方法可以爬到第 n 阶呢？
升级版的问题2：假设你正在爬楼梯，每次你可以爬 1 个、2 个或 3 个台阶，那么在相邻步数不能相同的条件下，你有多少种不同的方法可以爬到第 n 阶呢？

#### 思路

对于问题1，相对来讲会简单一些，解决方法有如下两类：使用自顶向下的递归和自底向上的迭代递推。

- 自顶向下的递归实现中可以发现存在大量的重叠子问题，所以利用备忘录功能可以优化效率，代码如下

```java
public class Stairs {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climbStairs(n, memo);
    }

    private int climbStairs(int n, int[] memo) {
        if (n <= 2) return n;
        if (memo[n] > 0) return memo[n];
        memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
        return memo[n];
    }
}
```

- 自底向上的迭代递推实现可以借助动态规划的思想来解决

状态转移方程：当 `n = 1` 或 `n = 2` 时，返回 `n`；否则 f(n) = f(n-1) + f(n-2)；也就是说将求解原问题的解转换成求子问题 `n-1` 和子问题 `n-2` 的解。

```java
public class Stairs {
    public int climbStairs(int n) {
        // 状态转移数组
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            // 状态转移方程
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
```

对于问题2，增加了一些限制：可以一次走三步和相邻步数不能相同。

先考虑一次走三步的情况：

```text
当 n=1 时，f(1)=1
当 n=2 时，f(2)=2
当 n=3 时，f(3)=4
当 n>3 时，f(n)=f(n-1) + f(n-2) + f(n-3)
```

可见这个和只能走1步或2步没有太大的区别。现在我们考虑相邻步数不能相同的情况

我们使用动态规划来求解该问题，一般步骤是：

1. 原问题拆分为子问题，进行分治，通过一定方法证明该问题具备最优子结构
2. 定义状态数组
3. 推导分析出DP方程

拆分子问题，找最优子结构

1. 如果当前爬1步，那么上一步只能是爬2步或者3步
2. 如果当前爬2步，那么上一步只能是爬1步或者3步
3. 如果当前爬3步，那么上一步只能是爬1步或者2步

由此可见，问题的解是上面三种情况相加得到，可以得到

1. 若是从第 n-1 个台阶爬了 1 个台阶到达了第 n 个台阶，那么此时到达第n个台阶的方法数 = 上一步爬 2 个台阶到达第 n-1 个台阶的方法数 + 上一步爬 3 个台阶到达第 n-1 个台阶的方法数；
2. 若是从第 n-2 个台阶爬了 2 个台阶到达了第 n 个台阶，那么此时到达第n个台阶的方法数 = 上一步爬 1 个台阶到达第 n-2 个台阶的方法数 + 上一步爬 3 个台阶到达第 n-2 个台阶的方法数；
3. 若是从第 n-3 个台阶爬了 3 个台阶到达了第 n 个台阶，那么此时到达第n个台阶的方法数 = 上一步爬 1 个台阶到达第 n-3 个台阶的方法数 + 上一步爬 2 个台阶到达第 n-3 个台阶的方法数；

我们可以构建一个二维的状态数组`dp[i][j]`，用来表示状态转移过程，i 取 1、2、3，j 表示台阶，`dp[i][j]` 表示从上一个位置爬 i 个台阶到达第 j 个台阶所有的方法数

```java
public int climbStairs(int n) {
    if (n <= 2) return 1;
    if (n == 3) return 3;

    // state array
    int[][] dp = new int[4][n + 1];
    dp[1][1] = 1;
    dp[2][2] = 1;
    dp[1][3] = dp[2][3] = dp[3][3] = 1;

    for (int i = 4; i <= n; i++) {
        // dp 状态转移
        dp[1][i] = dp[2][i - 1] + dp[3][i - 1];
        dp[2][i] = dp[1][i - 2] + dp[3][i - 2];
        dp[3][i] = dp[1][i - 3] + dp[2][i - 3];
    }
    return dp[1][n] + dp[2][n] + dp[3][n];
}
```
