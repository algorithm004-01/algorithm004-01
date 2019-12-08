# 学习总结

## 深度优先搜索和广度优先搜索

### 遍历需要满足的条件

- 每个节点都要访问一次
- 每个节点仅仅访问一次
- 对于节点的访问顺序不限

深度优先搜索可以使用递归来实现，或者使用迭代配合一个栈来模拟调用堆栈

### dfs 递归写法

```visited = set()
def dfs(node, visited):
    if node in visited:
        return

    visited.add(node)
    # process current node
    ...
    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node, visited)
```

### dfs 非递归写法

```def dfs(self, tree):
    if tree.root is None:
        return []
    visited, stack = [], [tree.root]

    while stack:
        node = stack.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_ndoes(node)
        stack.push(nodes)
    
    # other processing work
```

### 相对的广度优先搜索可以使用队列来实现

```def bfs(graph, start, end):
    queue = []
    queue.append([start])
    visited.add(start)

    while queue:
        node = queue.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)

    # other process work
    ...
```

## 贪心算法

贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。

### 贪心算法与动态规划的区别

贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择不能回退。
动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

贪心：当前做局部最优判断
回溯：能够回退
动态规划：最优判断+回退

### 贪心算法的作用

贪心法可以解决一些最优化问题，如：求图中最小生成树，求哈夫曼编码等。然而对于工程和生活中的问题，贪心法一般不能得到我们所要求的答案
一旦一个问题可以通过贪心法来解决，小么贪心法一般是解决这个问题的最好办法。由于贪心法的高效性以及其所求得的答案比较接近最优结果，贪心法也可以用作辅助算法或者直接解决一些要求结果不特别精确的问题。

### 贪心算法的适用场景

简单的说，问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解称为最优子结构。

贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

## 二分查找

### 二分查找的前提

- 目标函数单调性（单调递增或者递减）
- 存在上下界（bounded）
- 能够通过索引访问（index accessible）

代码模版
```left, right = 0, len(array)-1
while left <= right:
	mid = (left + right)/2
	if array[mid] == target:
		# find the target!!
		break or return result
	elif array[mid] < target:
		left = mid + 1
	else:
		right = mid + 1
```