# NOTE

#### 脑图地址（持续更新）


[数据结构](https://naotu.baidu.com/file/2e5493a31ae3dec9bf1526d5101b1e11)

[算法](https://naotu.baidu.com/file/977368cc2d9bc9affce2acd8098ddec8)


#### 学习方法


    1、chunk it up 切碎知识点 脉络相连
    2、deliberate practicing 刻意练习
    3、feedback 反馈

#### 四步切题


    1、clarification 审题
    2、possible solutions 所有可能的实现的方式
    3、coding 编码
    4、test cases 测试案例

#### 刷题


    1、第一遍 有思路的话实现，没有思路直接看解法，默写解法
    2、第二遍 自己实现，leetcode 提交并进行调试，写测试代码
    3、第三遍 隔一天之后继续刷题
    4、第四遍 一周之后再刷题
    5、第五遍 面试之前恢复性刷题

#### 数据结构 

[数据结构](https://naotu.baidu.com/file/2e5493a31ae3dec9bf1526d5101b1e11)

#### 算法 寻找 重复单元    

[算法](https://naotu.baidu.com/file/977368cc2d9bc9affce2acd8098ddec8)

#### 时间复杂度与空间复杂度 Big O notation

    O(1) Constant Complexity
    O(logn) Logarithmic Complexity
    O(n) Liner Complexity
    O(nlogn) 
    O(n^2) N square Complexity
    O(2^n) Exponential Growth
    O(n!) Factorial

> demo1 循环累加

    f(n) = 1+2+3+4+.....+n  o(n)
    f(n) = n*(n+1)/2        o(1)

> demo2 递归 

    递归语句总共执行了多少次（递归状态的递归树）

    f(n) = f(n-1)+f(n-2)  o(2^n)

    主定理 master theorem

    二分查找   O(logn)  T(n) = T(n/2)+O(1)
    二叉树遍历 O(n)     T(n) = 2T(n/2)+O(1)
    二维矩阵   O(n)     T(n) = 2T(n/2)+O(logn)
    归并排序   O(nlogn) T(n) = 2T(n/2)+O(n)