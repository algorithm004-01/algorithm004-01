# 【701-week0】预习周总结

## 数据结构与算法总览

### 精通一个领域

- Chunk it up 切碎知识点
    - 庖丁解牛
    - 脉络连接
- Deliberate Practicing 刻意练习
    - 过遍数
    - 练习缺陷、弱点地方
- Feedback 反馈
    - 及时
    - 主动：Github, LettCode, etc
    - 被动: Code review
- 切题四件套
    - Clarification
    - Possible Solutions
        - compare (time/space)
        - optimal
    - Coding
    - Test cases
- 刷题方法
    - 第一遍
        - 5分钟：读题 + 思考 
        - 直接看解法：注意多解法，比较解法优劣
        - 背诵、默写好的解法
    - 第二遍
        - 马上自己写 —> LeetCode 提交
        - 多种解法比较、体会 —> 优化
    - 第三遍
        - 过了一天后，再重复做题
        - 不同解法的熟练程度 —> 专项练习
    - 第四遍
        - 过了一周：反复回来练习相同题目
    - 第五遍
        - 面试前一周恢复性训练

### 数据结构

- 一维
    - 基础：数组 array (string), 链表 linked list
    - 高级：栈 stack, 队列 queue, 双端队列 deque, 集合 set, 映射 map (hash or map), etc
- 二维
    - 基础：树 tree, 图 graph
    - 高级：二叉搜索树 binary search tree (red-black tree, AVL), 堆 heap, 并查集 disjoint set, 字典树 Trie, etc
- 特殊
    - 位运算 Bitwise, 布隆过滤器 BloomFilter
    - LRU Cache

> 了解每种数据结构的原理和代码框架

### 算法

- If-else, switch —> branch
- for, while loop —> Iteration
- 递归 Recursion (Divide & Conquer, Backtrace)
- 搜索 Search: 深度优先搜索 Depth ﬁrst search, 广度优先搜索 Breadth ﬁrst search, A*, etc
- 动态规划 Dynamic Programming
- 二分查找 Binary Search
- 贪心 Greedy
- 数学 Math , 几何 Geometry

> 在头脑中回忆上面每种算法的思想和代码模板

### 脑图总览

<div align="center">

<image src='images/00.png' alt="算法">

`算法`

<image src='images/01.png' alt="数据结构">

`数据结构`

</div>

## 编程技巧

- 环境配置
- 效率工具
- 编码风格
- 自顶向下的编程方式

## 复杂度分析(Big O notation)

- O(1):  Constant Complexity 常数复杂度 
- O(log n):  Logarithmic Complexity 对数复杂度 
- O(n):  Linear Complexity 线性时间复杂度 
- O(n^2): N square Complexity 平⽅方 
- O(n^3): N square Complexity ⽴立⽅方 
- O(2^n): Exponential Growth 指数 
- O(n!): Factorial 阶乘

> 注意：只看最⾼高复杂度的运算

<div align="center">

<image src="images/02.png" alt="算法复杂度比较">

[算法复杂度比较](https://www.bigocheatsheet.com)

<image src="images/03.png" alt="常见数据结构操作">

`常见数据结构操作`

<image src="images/04.png" alt="数组排序算法">

`数组排序算法`

</div>