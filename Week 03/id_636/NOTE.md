# NOTE

### 第三课、补充第二课中一些知识：
* [常见的数据结构](https://github.com/teslapatrick/algorithm004-01/blob/master/Week%2003/id_636/常用数据结构（待完善）.pdf)
* [常见的算法](https://github.com/teslapatrick/algorithm004-01/blob/master/Week%2003/id_636/常用算法（待完善）.pdf)

### 贪心算法、动态规划对比
* 贪心算法是一种在每一步中都取最优解，则由此判断为全局最优解；同时贪心算法会对每个子问题的解法方案给出选择，不能回退状态；
* 对比动态规划，其会保存以前的运算结果，并根据以前的结果对当前进行选择，"可以回退"；

### BFS Module
```Python
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

### DFS Module

```Python
递归写法：
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
			
非递归写法：

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
  
  

