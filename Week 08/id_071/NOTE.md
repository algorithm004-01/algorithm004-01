# NOTE

> 高级动态规划

##### 基础概念

    找到重复子问题

    递归

    分治 

    动态规划(动态递推) = 分治 + 最优子结构 

    dp状态定义  dp := map[string]int
    dp状态转移方程 func
    
##### 实战题目

    70 爬楼梯  f(n) = f(n-1) + f(n-2)

    换硬币

    62 不同路径 f(x, y) = f(x-1, y) + f(x, y-1)

    198 打家劫舍
    dp[i] = max(dp[i- 2] + nums[i], dp[i- 1])

    dp[i][0] = max(dp[i-1][0], dp[i- 1][1]) //没偷 i
    dp[i][1] = dp[i- 1][0] + nums[i]        //偷了 i

    64 最小路径和 dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + A[i][j]

    121 股票买卖
    今天没有持有股票
    dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + price[i])

    今天持有股票
    dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])

##### 高级DP

    复杂度：
    1 状态拥有更多为维度
    2 状态方程更加复杂


    爬楼梯

    746 使用最小花费爬楼梯

    编辑距离
    dp[i][j] word1.substr(0,i) 到 word2.substr(0,j)的距离

    w1 ....x i
    w2 ...y  j
    if w1[i] == w2[j] {
        edit_dist(i, j) = edit_dist(i-1, j-1) + 1 
    } else { 
        edit_dist(i, j) =  Min(edit_dist(i-1, j-1) + 1, edit_dist(i-1, j) + 1, edit_dist(i, j-1) + 1)
    }
    
****

> 字符串算法

##### 基础知识 golang

    声明 var s := "string" //immutable 线程安全
    遍历 for 
    比较 equal 

    异位词
    回文词

##### 最长子串(无间隔)、子序列(有间隔)

    longest common sequence

    longest common substring

    edit distance

    longest palindromic substring

    P(i,j) = ( P(i+1, j-1) && s[i] == s[j] )