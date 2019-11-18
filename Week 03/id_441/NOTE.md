# NOTE

## 深度优先和广度优先

之前对于深度优先遍历和广度优先遍历的了解。利用while可以实现广度优先遍历，利用递归可以实现深度优先遍历。

## 启发式搜索

优先级优先的搜索，推荐算法。快手，抖音的推荐算法。

### js中的深拷贝涉及到的深度优先遍历

```js

export const deepCopy = (obj) => {
    if(obj = null) return obj;
    if(obj instanceof Date) return new Date(obj);
    if(obj instanceof RegExp) return new RegExp(obj);
    if(typeof obj !== 'object') return obj;
    let newObj = new obj.constructor();
    for( let k in obj){
        newObj[key] = deepCopy(obj[key])
    }
    return obj
}

```

## 深度优先搜索的代码模板

深度优先遍历通常是递归或者使用栈的方式来解决。

### python 

```python

// 二叉树

def dfs(node):

    if node in visited:
        return 
    visited.add(node)
    defs(node.left)
    defs(node.right)

// 普适对象

visited = set();
def dfs(node, visited):
    visited.add(node)

    for next_node in node.children():
        if not next_node in visited:
            defs(next_node, visited)

// 普遍递归思路

visited = set()
def dfs(node, visited):
    if node in visited:
        return
    visited.add(node)

    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node, visited)

// 非递归写法

def DFS (self, tree):
    if tree.root is None:
        return [];
    
    visited, stack =[], [tree.root]

    while stack:
        node = stack.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)

        stadk.push(nodes)

```

## 广度优先的代码模板

一般使用while或者队列来实现。

```python

def BFS(graph ,start , end):
    queue = []
    queue.append([start])
    visited.add(start)

    while queue:
        node = queue.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)

```

## 贪心算法
在每一步选择中都采取当前状态下最优的选择。从而希望全局最优。和动态规划不同的地方在于，对每一个子问题都有决策，不能回退。而动态规划则会保存以前的计算结果，根据历史计算结果对当前做出选择。有回退的功能。最优状态的回溯就叫做动态规划。
贪心算法可以在某一步使用，并且配合动态规划或者递归来达到解决问题的目的。
贪心算法一般用来处理最优最好的情况。如：图中最小的树，哈夫曼编码等。但是在工程中和生活中并不能起到作用。
另外就是作为辅助算法来进行解决实际问题。
使用场景：
1：问题比较特殊（比如：整除关系。）
2：问题能够分为子问题

## 二分查找

1：单调性
2：存在边界（上下界）
3：索引访问