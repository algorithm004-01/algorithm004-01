# NOTE

> DP  dynamic programming


    最近最简的重复性
    分治 + 最优子结构
    divide & conquer + optional substructure


    分解 重复子问题
    状态 存储数组
    DP 方程式
    
##### 0-1 背包

    
##### Fibonacci 数列


##### 路径计算


##### 爬楼梯

    f(n) = f(n-1) + f(n-2)

    扩展
    1. 1,2,3
    2. 相邻两部的步伐不能相同

##### 最长公共子序列

    
##### 三角形最小路径和

    dp[i] = Max(nums[i],nums[i]+dp[i-1])

    nums[i] + Max(0,dp[i-1])
    
##### 最大子序列和


    当前元素自身最大，或者 包含之前最大

    Max(i) = Max(i-1, 0) + a[i]
    
##### 打家劫舍

    [1,6,2,9,3,1,6,5,2,1]

    升维 一维数组=> 二维 => 多维

    a[i] = a[i-1] + nums[i]


    a[i][0] true
    a[i][1] false

    a[i][0] = Max(a[i-1][0], a[i-1][1])
    a[i][1] = Max(a[i-1][0], 0) + nums[i]
