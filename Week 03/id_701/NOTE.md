# 【701-week3】第三周学习总结

## 深度优先搜索和广度优先搜索

这两种搜索方式的时间复杂都都是 O(n)，每个节点都要且仅仅访问一次，区别在于节点的访问顺序不一样。

树的遍历示例代码模板

```python
def dfs(node):
    if node in visited:
        return

    visited.add(node)

    if node.left:
        dfs(node.left)
    if node.right:
        dfs(node.right)
```

DFS 代码示例模板：

```python
# 递归方式
visited = set()
def dfs(node, visited):
    if node in visited:
        return
    
    visited.add(node)

    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node, visited)

# 非递归方式
def dfs(self,tree):
    if tree.root is None:
        return []
    visited, stack = [], [tree.root]

    while stack:
        node = stack.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        stack.push(nodes)
```

BFS 代码示例模板：

```python
def bfs(graph, start, end):
    queue = []
    queue.appned([start])
    visited.add(statrt)

    while queue:
        node = queue.pop()
        visited.add(node)

        # process(node)

        nodes = generate_related_nodes(node)
        queue.push(nodes)
```

### 贪心算法

贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。 

贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

贪心法可以解决一些最优化问题，如：求图中的最小生成树、求哈夫曼编码等。然而对于工程和生活中的问题，贪心法一般不能得到我们所要求的答案。 

一旦一个问题可以通过贪心法来解决，那么贪心法一般是解决这个问题的最好办法。由于贪心法的高效性以及其所求得的答案比较接近最优结果，贪心法也可以用作辅助算法或者直接解决一些要求结果不特别精确的问题。

适用场景：简单地说，问题能够分解成子问题来解决，子问题的最优解能递推到最终 问题的最优解。这种子问题最优解称为最优子结构。


### 二分查找

使用条件：

- 目标函数单调性（单调递增或递减）
- 存在上下界
- 能够通过索引访问

代码模板：

```python
def binnary_search(array, target):
    left, right = 0, len(array) - 1
    while left <= right:
        mid = left + (right-left) // 2
        if array[mid] == target:
            return array[mid]
        elif array[mid] > target:
            right = mid - 1
        else:
            left = mid + 1
```
