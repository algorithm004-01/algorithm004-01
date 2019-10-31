# NOTE

### Week 03 关键部分笔记

##### 深度优先搜索和广度优先搜索

- 深度优先搜索：DFS，Deep First Search

代码模版

```python
# 递归写法
visited = set()
def dfs(node, visited):
    # terminator
    if node in visited:
        return

    visited.add(node)

    # process current node here
    # ...

    # drill down
    for next_node in node.children():
        if next_node not in visited:
            dfs(next_node, visited)


# 非递归写法
def DFS(root):
    if root is Node:
        return []
    visited, stack = [], [root]

    while stack:
        node = stack.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node) 
		stack.push(nodes) 

```

- 广度优先搜索：BFS，Bread First Search

代码模版

```python
def BFS(graph, start, end):
	queue = [] 
	queue.append([start]) 
	visited.add(start)

	while queue: 
		node = queue.pop() 
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)

	# other processing work 
	...
```

- 题目
https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description
https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description
https://leetcode-cn.com/problems/generate-parentheses/#/description
https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description

https://leetcode-cn.com/problems/word-ladder/description/
https://leetcode-cn.com/problems/word-ladder-ii/description/
https://leetcode-cn.com/problems/number-of-islands/
https://leetcode-cn.com/problems/minesweeper/description/

##### 贪心算法

- 题目

https://leetcode-cn.com/problems/coin-change/
https://leetcode-cn.com/problems/lemonade-change/description/  (done)
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/ (done)
https://leetcode-cn.com/problems/assign-cookies/description/  (done)
https://leetcode-cn.com/problems/walking-robot-simulation/description/
https://leetcode-cn.com/problems/jump-game/ 
https://leetcode-cn.com/problems/jump-game-ii/

##### 二分查找

- 前提

1. 单调性（单调递增或递减）
2. 存在上下界 (bounded)
3. 能够通过索引访问 (index accessable)

- 代码模版

```

```

- 题目

https://leetcode-cn.com/problems/sqrtx/
https://leetcode.com-cn/problems/valid-perfect-square/

https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
https://leetcode-cn.com/problems/search-a-2d-matrix/
https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
说明：同学们可以将自己的思路、代码写在第 3 周的学习总结中

--- 

### 【716-Week 03】总结

// todo

### 思考题

思考题：使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方


