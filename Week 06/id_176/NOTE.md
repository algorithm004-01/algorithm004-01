## NOTE

DFS代码 - 递归写法 

```python
visited = set()
def dfs(node, visited):
  if node in visited: # terminator
      # already visited
    return
  visited.add(node)
  # process current node here.
  ...
  for next_node in node.children(): 
    if not next_node in visited:
  		dfs(next_node, visited)
```

DFS代码 - 非递归写法 

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
  ...
```

BFS代码

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
```

### Trie树 -- 字典树

**概述：字典树，即Trie 树，又称单词查找树或键树，是一-种树形结构。典型应用是用于统计和排序大量的字符串(但不仅限于字符串)，所以经常被搜索引擎系统用于文本词频统计。根据业务需求，它的结点可以存储额外的信息，已供统计。**

**优点：它的优点是:最大限度地减少无谓的字符串比较，查询效率比哈希表高。**

**核心思想：1.Trie树的核心思想是空间换时间。2.利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。**

### 并查集

**适用场景：1、组团、配对问题 2、Group or not ?**

**基本操作：
makeSet(s):建立一个新的并查集，其中包含s个单元素集合
unionSet(x, y):把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并。
find(x):找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将它们各自的代表比较一下就可以了**

###高级搜索

**剪枝：根据业务需求进行搜索范围缩进，或过滤到不必要的重复查询**

**双向BFS：从两头一起广度优先搜索，在中间集合返回结果**

**启发式搜索：可以基于BFS和DFS，区别在于，要定义一个估价函数，来推测哪个邻居节点导向一个目标**
**估价函数：
启发式函数: h(n), 它用来评价哪些结点最有希望的是一个我们要找的结点，h(n) 会返回一个非负实数，也可以认为是从结点n的目标结点路径的估计成本。
启发式函数是一种告知搜索方向的方法。它提供了一种明智的方法来猜
测哪个邻居结点会导向一个目标。**

### 红黑树

**概述：红黑树是一种近似平衡的二叉搜索树(Binary SearchTree)，它能够确保任何一个结点的左右子树的高度差小于两倍。具体来说，红黑树是满足如下条件的二又搜索树:
1、每个结点要么是红色，要么是黑色
2、根结点是黑色
3、每个叶结点(NIL结点，空结点)是黑色的。
4、不能有相邻接的两个红色结点
5、从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点。
**

### AVL树

**特性：高度差绝对值小于等于1的平衡二叉搜索树**

**平衡因子(Balance Fator)：
是它的左子树的高度减去它的右子树的高度(有时相反)
balance factor={-1,0, 1}**

**平衡方式：
通过旋转操作来进行平衡(四种)**

**不足: 结点需要存储额外信息、且调整次数频繁**

