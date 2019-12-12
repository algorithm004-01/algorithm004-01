# NOTE

  

#### Dynamic Programming

DP=分治+最优子结构

一般用于求解：最优解，最大值，最少方式...

DP本质是动态递推，和分治或递归没有本质区别

- 共性：找重复子问题

- 差异：缓存（储存中间状态）、淘汰次优

- 指数-->多项式（n^2或n）

> 形成机器思维，计算机处理问题的本质是重复性，是理解复杂问题的关键，放弃人肉递归事事亲为的思维习惯，而要化繁为简！

#### 实例：
##### 1. 一维DP
fibonacci：自顶向下记忆化搜索（Memoization）

```java
int fib(int n, int[] memo) {
    // terminator
    if(n<=1){
        return n;
    }
    if(memo[n] == 0){
        memno[n]= fib(n-1) + fib(n-2)
    }
}
```

fibonacci：自底向上循环（动态规划（DP））
```java
int fib(int n, int[] a){
    a[0] = 0;
    a[1] = 1;
    for(int i=2;i<=n;+r+i){
        a[i] = a[i-1] + a[i-2];
    }
    return a[n];
}
```

优化：只需要保存最近的两个结果（a[i-1]和a[i-2]）即可

```java
int fib(int n){
    int one = 0, two = 1;
    int res = -1;
    if (n <= 1) {
        res = n;
    }
    for (int i = 2; i <= n; ++i) {
        res = one + two;
        one = two;
        two = res;
    }
    return res;
}
```


> 更好的做法基本是自顶向上进行递推

多维递推，存在取舍最优子结构，放弃人肉递归，使用数学归纳法思维

##### 2. 二维简单DP：路径计数（62/63）

递推（状态转移方程/DP方程）：opt[i, j] = opt[i-1, j] + opt[i, j-1]


优化：只需要保存一行的结果

##### 3. 字符串进行变化DP：最长公共子序列(1143)

暴力：枚举1的每一个子序列，看是否也是2的子序列O(2^n)

重复性：

先看特殊/边界情况(corner case)，再数学归纳一般情况：
1. S1="", S2=""
2. S1="", S2=任意
3. S1="A"，S2=任意
4. S1="...A"，S2="...A" --> 子问题：S1="...", S2="..." + 1
5. S1="...A", S2="...B" --> 子问题：Max(LCS(S1="...", S2="...B"), LCS(S1="...A", S2="..."))

使用二维数组，保存两个字符串变化中间状态的结果

DP公式：
```
if s1[-1] != s2[-1]:
    LCS(s1, s2) = max(LCS(s1-1, s2), LCS(s1, s2-1))
if s1[-1] == s2[-1]:
    LCS(s1, s2) = LCS(s1-1, s2-1) + 1
return LCS[s1.length, s2.length]
```
     5 steps to DP:
    
    1. define repetitive subproblems (divide)
    
    2. guess part of solution
    
    3. merge subproblem solutions
    
    4. build DP table bottom-up (OR recurse & memorize)
    
    5. solve the original problem

习题：

##### 4. ClimbingStairs思考：
    1. 假设可以1、2、3步
    2. 假设相邻两步不能相同

##### 5. Triangle(120):
> 相当于路径计数中二维数组砍掉一半的三角形

(1) 重复性子问题：solve(i, j) = min(solve(i+1, j) + solve(i+1, j+1)) + a[i, j]

(2) 递推公式：f[i, j] = min(f(i+1, j) + f(i+1, j+1)) + a[i, j]

思考：记忆化递归写法

##### 6. 子序列的最大和(53)/积

> 平时就养成在纸上/电脑上/白板上将自己的思考过程写出来的习惯，面试时按照平时的习惯就不虚了！

(1) brutal force

(2) DP: 子问题：当前元素自身最大（即之前最大和为0），或加上以前最大和后最大（要么不用之前的，要么用）

solve(i) = max(solve(i-1), 0) + a[i]

f[i] = max(f[i-1], 0) + a[i]

结果：max(f)

优化：为负就抛弃
nums[i] = nums[i] + max(0, nums[i-1])
return max(nums)

> 思考：乘积最大

##### 7. Coin Change (322)

暴力：转化为状态树，递归（O(2^n）

BFS: 广度优先遍历状态树，找最短达到0的路径长度

DP: f(n) = min(f(n-k)), for k in [1,2,5]) + 1

##### 8. House Robber (198)
(1) 子问题
(2) 状态定义
(3) DP方程

使用二维数组，保存第i个房子是否偷

a[i][0/1]: 0表示当前第i个房子不偷

a[i][0] = max(a[i-1][0], a[i-1][1])

a[i][1] = a[i-1][0] + nums[i]

结果：a[n-1]


一位数组：

a[i]：表示nums[i]必偷的最大值

a[i] = max(a[i-1] + 0, a[i-2] + nums[i])

甚至不需要开数组，只需三个变量即可

> 面试中状态定义比较重要，竞赛中递归方程会比较难

##### 9. 股票买卖（121）
...

##### 10. Edit Distance