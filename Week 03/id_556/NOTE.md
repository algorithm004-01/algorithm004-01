# 二分查找寻找半有序数组无序点

约定旋转点为被旋转部分第一个元素的下标，如[4, 5, 6, 7, 8, 0, 1, 2]中0的下标

若数组无旋转应当为单调递增，找旋转点即为寻找第一次减小（也是唯一一次）的地方，直观的想法为依次比较a[i]与a[i+1]，复杂度为O(n)。而使用二分法，一步步缩小旋转点存在的区间范围来找到旋转点，复杂度为O(logn)。

- 初始化：l=0, r=a.length-1, m=l+(r-l)/2
- 思路1: 比较a[m]与前一个数，如果a[m]<a[m-1]，则找到，返回m；否则，比较a[m]与右端，如果a[m]>a[r]，则说明旋转点在m到r之间，令l=m+1；否则，说明旋转点在l到m之间，令r=m-1;

代码：
```java
public static int findIndex(int[] a) {
    if (a[0] < a[a.length - 1]) {
        return 0;
    }
    int l = 0, r = a.length - 1;
    int m = l + (r - l) / 2;
    while (l <= r) {
        m = l + (r - l) / 2;
        if (a[m] < a[m - 1]) {
            return m;
        } else {
            if (a[m] > a[r]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
    }
    return m;
}
```
以上代码其实是存在bug的，比如数组长度为2且降序时（如[3,1]），m=0，m-1=-1会造成数组下标越界。

- 思路2: 比较a[m]与后一个数，如果a[m]>a[m+1]，则找到，返回m+1；否则，比较a[m]与左端，如果a[m]<a[l]，则说明旋转点在l到m之间，令r=m-1；否则，说明旋转点在m到r之间，令l=m+1;

```java
public static int findRotateIndex(int[] a) {
        if (a[0] < a[a.length - 1]) {
            return 0;
        }
        int l = 0, r = a.length - 1;
        int m = l + (r - l) / 2;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (a[m] > a[m + 1]) {
                return m+1;
            } else {
                if (a[m] < a[l]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return m;
    }
```

# Week3-9-深度广度优先遍历
搜索很多时候就需要遍历，算法可以根据数据结构特征进行提升；DFS和BFS复杂度都是O(n)，区别在于顺序不同。

## DFS
### 递归写法：
```python
def dfs(node):
    if node in visited:
        return
    visited.add(node)
    # process current node
    ...
    dfs(node.left)
    dfs(node.right)
```
```python
def dfs(node, visited):
    visited.add(node)
    # process current node
    ...
    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node, visited)
```
```python
def dfs(node, visited):
    if node in visited: # terminator
        return
    visited.add(node)
    # process current node
    ...
    for next_node in node.children():
        if not next_node in visited: # check again
            dfs(next_node, visited)
```
非递归写法：(其实是用栈手动模拟递归过程)
```python
def dfs(self, tree):
    if tree.root is None:
        return []
    visited, stack = [], [tree.root]
    while stack:
        node = stack.pop()
        visited.add(node)
        process(node)
        nodes = get_related_nodes(node)
        stack.push(nodes)
```
## BFS
```python
def bfs(node):
    queue = []
    queue.append([start])
    visited.add(start)
    while queue:
        node = queue.pop()
        visited.add(node)
        process(node)
        nodes = get_related_nodes(node)
        queue.push(nodes)
```

## PFS（启发式搜索）

# Week3-10-贪心算法

 贪心算法：在每一步选择中都选取当前状态下最优的选，希望结果得到全局最优，因此主要解决最优化问题（如最小生成树，霍夫曼编码等）

> Greedy与DP的不同：DP可以保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能
（带最优判断的回溯）

> 贪心法一般不能得到实际问题的最优解，但高效且结果接近最优解，因此可以用作辅助算法。

> 一旦一个问题可以用贪心法解决，那么贪心法一般是解决这个问题的最好和自然方法。但这种情况很少。


适合贪心法的情况：

- 问题能分解成子问题，而子问题的最优解能递推到最终问题的最优解（最优子结构）

> 贪心法难的在于证明和转换角度（有时需要从前往后/从后往前/局部切入进行贪心）

# Week3-11-二分查找

适合二分查找的条件：
1. 目标函数单调性（有序）
2. 存在上下界
3. 能够通过索引访问

代码模板
```python
left, right=0, len(array)-1
while left <= right:
    mid = (left + right) / 2
    if array[mid] == target:
        # find the target
        return result
    elif array[mid] < target:
        left = mid + 1
    else:
        right = mid - 1
```

四步切题
1. 与面试官确认题目细节，边界条件，输入输出，以及corner case;
2. 思考自己能想到的所有解法，分析时间空间复杂度；
3. 与面试官探讨自己想到的最优解法，得到确认或提示；
4. 开始写代码，给出test case（正常，边界，错误，变态）。
