# NOTE

## BFS && DFS

   * 遍历 = 暴力搜索
   * 树/图 每个节点只被访问一次
   * 深度优先、广度优先、优先级优先(启发式搜索算法， 推荐算法)

```python
def dfs(node):
    if node in visited:
        return
    visited.add(node)

    #process current node

    dfs(node.left)
    dfs(node.right)

visited = set();
def dfs(node, visited):
    # terminator
    if node in visited:
    # already visited
        return

    visited.add(node)

    # process current node here.
    ...
    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node, visited)

def DFS(node):
    visited, stack = [], [node]

    for len(stack) > 0 {
        node = stack.pop()
        visited.add(node)

        process_cur(node)
        nodes = generate_related_nodes(node)
        stack.push(nodes)
    }

    #other process work
```

```python
def BFS(graph, start, end):
    queue = []
    queue.append([start])

    while queue:
        node = queue.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)

    # other processing work
    ...

```

## 贪心算法

* 贪心算法: 当下做出局部最优判断，不能回退, 适合最优子结构性质的问题
* 回溯算法: 能够回退
* 动态规划: 最优判断+ 回退, 会保存之前的结果， 根据结果选择回退，常常适用于有重叠子问题和最优子结构性质的问题

场景：

  1. 图的最小生成树
  2. 哈夫曼编码

特点：

   1. 高效
   2. 适合接近最优解的情况
   3. 可作为辅助算法

## 二分查找

条件：

   1. 有序
   2. 上下界
   3. 索引访问

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

```c
//牛顿迭代法
float InvSqrt (float x){
    float xhalf = 0.5f*x;
    int i = *(int*)&x;
    i = 0x5f3759df - (i>>1);
    x = *(float*)&i;
    x = x*(1.5f - xhalf*x*x);
    return x;
}
```
