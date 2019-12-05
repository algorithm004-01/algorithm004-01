# NOTE

[DFS 代码模板（递归写法、非递归写法）](https://shimo.im/docs/ddgwCccJQKxkrcTq/read)

递归写法

```python
visited = set()

def dfs(node, visited):
    if node in visited: # terminator
        # already visited
        return

    visited.add(node)

    # process current node here.
    # ...
    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node, visited)
```

非递归写法

```python
def DFS(self, tree):

    if tree.root is None:
        return []

    visited, stack = [], [tree.root]

    while stack:
        node = stack.pop()
        visited.add(node)

        process (node)
        nodes = generate_related_nodes(node)
        stack.push(nodes)

    # other processing work
    # ...
```

[BFS 代码模板](https://shimo.im/docs/P8TqKHGKt3ytkYYd/read)

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
    # ...
```

实战题目

    https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description
    https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description
    https://leetcode-cn.com/problems/generate-parentheses/#/description
    https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description

课后作业

    https://leetcode-cn.com/problems/word-ladder/description/
    https://leetcode-cn.com/problems/word-ladder-ii/description/
    https://leetcode-cn.com/problems/number-of-islands/
    https://leetcode-cn.com/problems/minesweeper/description/

参考链接

    [coin change 题目](https://leetcode-cn.com/problems/coin-change/)
    [动态规划定义](https://zh.wikipedia.org/wiki/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92)

课后作业

    https://leetcode-cn.com/problems/lemonade-change/description/
    https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
    https://leetcode-cn.com/problems/assign-cookies/description/
    https://leetcode-cn.com/problems/walking-robot-simulation/description/
    https://leetcode-cn.com/problems/jump-game/ 、 https://leetcode-cn.com/problems/jump-game-ii/

参考链接

[二分查找代码模板](https://shimo.im/docs/hjQqRQkGgwd9g36J/read)
[Fast InvSqrt() 扩展阅读](https://www.beyond3d.com/content/articles/8/)

```python
left, right = 0, len(array) - 1
while left <= right:
    mid = (left + right) / 2
    if array[mid] == target:
        # find the target!!
        break or return result
    elif array[mid] < target:
        left = mid + 1
    else:
        right = mid - 1
```

实战题目

    https://leetcode-cn.com/problems/sqrtx/
    https://leetcode.com-cn/problems/valid-perfect-square/

课后作业

    https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
    https://leetcode-cn.com/problems/search-a-2d-matrix/
    https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
    使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
    说明：同学们可以将自己的思路、代码写在第 3 周的学习总结中