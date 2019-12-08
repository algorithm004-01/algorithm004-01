
### 1.深度优先搜索 广度优先搜索
#### 1.1 搜索-遍历

 - 每个节点都要访问一次
 - 每个节点仅访问一次

- 深度优先：depth first search 
  - [模板](https://shimo.im/docs/ddgwCccJQKxkrcTq/read)
- 广度优先：breath first search搜索：暴力、简单朴素
  - [模板](https://shimo.im/docs/P8TqKHGKt3ytkYYd/read)
- 其他优先：比如从中间优先
- 在树图中寻找特定点

- 案例： 
    - 深度优先：递归、遍历
    - 广度优先：队列
    - 广度优先实例：水波纹、地震。 更符合人脑裂解

#### 1.2 应用
- java:链表 link 、双端队列deque

- python:高性能connection库的deque



- 启发式搜索:抖音、快手

#### 1.3 实战、高频
- 二叉树的层次遍历
- 岛屿数量:bfs dfs 并查集  flood fill

### 2.贪心算法 Greedy
#### 2.1 前提
- 能证明用贪心能得到全局最优解
- 从后往前、从局部贪心

#### 2.2 与回溯、动态规划对比
- 贪心：当下做局部最优判断
- 回溯：能够回退
- 动态规划：最优判断+回退

#### 2.3 实战
- 硬币法


### 3.二分查找  [模板](https://shimo.im/docs/hjQqRQkGgwd9g36J/read)

#### 3.1 二分查找前提

- 目标函数单调性（单调递增或递减）
- 存在上下界（bounded）
- 能够通过索引访问（index accessible）




#### 3.实战 高频
- 平方根： 二分、牛顿迭代法

