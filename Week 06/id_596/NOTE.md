# NOTE

## 学习笔记

## 字典树 Tire

### 字典树的基本结构

字典树，即Trie树，又称单词查找树或者建树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。
它的优点是：最大限度的减少无谓的字符串比较，查询效率比哈希表高。

### 字典树的基本性质

1. 节点本身不存完整单词
2. 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串
3. 每个节点的所有子节点路径代表的字符都不相同

### 核心思想

Trie树的核心思想是空间换时间

利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的

### 实现

```python
class Trie(object):
	def _init_(self):
		self.root = {}
		self.end_of_word = "#"
	
	def insert(self, word):
		node = self.root
		for char in word:
			node = node.setdefault(char, {}) # 有值则取值没值赋值{}
		node[self.end_of_word] = self.end_of_word

	def search(self,word):
		node = self.root
		for char in word:
			if char not in node:
				return False
			node = node[char]
		return self.end_of_word in node

	def startsWith(self,prefix):
		node = self.root
		for char in prefix:
			if char not in node:
				return False
			node = node[char]
		return True
```

## 高级搜索

### 回溯法

回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚至是上几步的计算，再通过其他的可能的分步解答再次尝试寻找问题的答案。

回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况：

- 找到一个可能存在的正确答案
- 再尝试了所有可能的分步方法后宣告问题没有答案

在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。

### 双向BFS

从图的开始和结束节点同时向中间扩散，在中间相遇即为搜索到了。

### 启发式搜索(A* search)

代码模版

```python
def AstarSearch(graph,start,end):
	pq = collections.priority_queue() # 优先级队列
	pq.append([start])
	visited.add(start)

	while pq:
		node = pq.pop() # can we add more intelligence here?
		visited.add(node)

		process(node)
		nodes = generate_related_nodes(node)
		unvisited = [node for node in nodes if node not in visited]
		pq.push(unvisited)
```

### 估价函数

启发式函数：h(n)，它用来评价那些节点最有希望的是一个我们要找的节点，h(n)会返回一个非负实数，也可以认为是从节点n的目标节点路径的估计成本。

启发式函数是一种告知搜索方向的方法。它提供了一种明智的方法来猜测哪个邻居节点会导向一个目标。

## AVL树和红黑树

### AVL树

1. 发明者G.M.Adelson-Velsky和Evgenii Landis
2. Balance Factor（平衡因子）：

    是它的左子树的高度减去它右子树的高度（有时相反）。

    balance factor = {-1,0,1}
3. 通过旋转操作来进行平衡（四种）

#### 旋转操作

1. 左旋
2. 右旋
3. 左右旋
4. 右左旋

#### AVL总结

1. 平衡二叉搜索树
2. 每个节点存balance factor = {-1, 0 ,1 }
3. 四种旋转操作

不足：节点需要存储额外信息、且调整次数频繁

### 红黑树(Red-black Tree)

红黑树是一种近似平衡的二叉搜索树（Binary Search Tree），它能够确保任何一个节点的左右子树的高度差小于两倍。具体来说，红黑树是满足如下条件的二叉搜索树：

- 每个节点要么是红色，要么是黑色
- 根节点是黑色
- 每个叶节点（NIL节点，空节点是黑色的）
- 不能有相邻的两个红色节点
- 从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点。

#### 关键性质

从根到叶子的最长的可能路径不多于最短可能路径的两倍长。