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
https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description  (done)
https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description
https://leetcode-cn.com/problems/generate-parentheses/#/description
https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description

https://leetcode-cn.com/problems/word-ladder/description/
https://leetcode-cn.com/problems/word-ladder-ii/description/
https://leetcode-cn.com/problems/number-of-islands/
https://leetcode-cn.com/problems/minesweeper/description/

- Topic：全面掌握深度优先搜索和广度优先搜索

1. 图的存储
2. 实现BFS和DFS；解决问题时 BFS 和 DFS 能否相互转换
3. 实现 Dijkstra 算法、Bellford 算法、Floyd 算法、A*算法
4. 实现拓扑排序 Kahn 算法、DFS 算法

岛屿个数，有效数独，迷宫问题

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

https://leetcode-cn.com/problems/sqrtx/   (done)
https://leetcode-cn.com/problems/valid-perfect-square/  (done)

https://leetcode-cn.com/problems/search-in-rotated-sorted-array/  (done)
https://leetcode-cn.com/problems/search-a-2d-matrix/
https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
说明：同学们可以将自己的思路、代码写在第 3 周的学习总结中

--- 

### 【716-Week 03】总结

// todo

### 思考题

思考题：使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

分析：

- 理解题目的意思

输入是一个半有序的数组，首先我们假设数组是升序后做了旋转后得到的，所以有一些特点：在断点处的前后都是有序的，但整体无序；第一个元素大于最后一个元素
输出是找到那个无序的索引位置，我们假设返回的是最小元素的位置索引i，自然的，i-1就是最大元素的位置索引

- 找解决思路

思路1：使用暴力方式，以此遍历数组中的每个元素，比较两个元素的大小，如果出现前面的值大于后面的值的地方，就是我们要找的；但是此种方法，时间复杂度是 O(n)，复杂度有些高，考虑是否有更优化的解法

思路2：虽然数组是整体无序的，但是部分是有序的，可以借助这个特性使用二分查找；已知 `nums[0] > nums[nums.length-1]`, 我们使用二分查找获取 `nums[mid]`, 让 `nums[mid]` 和 `nums[nums.length-1]` 做比较，如果 `nums[mid]` 大，说明断点出在 `mid` 之前，就调整 `low` 的位置；否则在 `mid` 之后，调整 `high` 的位置，这样持续下去，直到找到那个位置

此外，mid元素和位置0的元素做比较，道理是一样的

- 编写代码

```java
public class HomeWork1 {
    /**
     * 查找半有序数组的最小元素的索引（同理就是找无序的地方）
     */
    public int findMinElementIndex(int[] nums) {
        int low = 0, high = nums.length - 1;
        int lastElement = nums[high];
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] < lastElement) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}
```

- 测试用例

```
Test Case:
[10, 11, 12, 14, 1, 2, 3, 4, 5, 6, 7, 8, 9]
[10, 9]
[12, 13, 1, 2]
[12]
[12, 13, 14]
```
