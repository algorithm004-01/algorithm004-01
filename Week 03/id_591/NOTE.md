# 笔记
## 1、树深度优先遍历和广度优先遍历
### 1.1、区别
#### 1.1.1、遍历顺序不一样
深度优先遍历是先遍历子节点再遍历兄弟节点，广度优先遍历是先遍历兄弟节点再遍历子节点。
#### 1.1.2、实现算法不一样
因为访问都是从根节点开始，深度优先遍历采用递归或者栈实现，实现先进后出，而广度优先遍历采用先进先出的队列的方式实现。

深度优先遍历模版
```python
//递归实现
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

//非递归实现，自己维护栈来实现
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
例子：二叉树的深度遍历：
```javascript
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */

var levelOrder = function(root) {
    var result = {};
    
    var levelOrderRecursion = function(root, level){
        if(!root){
            return;
        }
    
        if(!result[level]){
            result[level] = [];
        }
        result[level].push(root.val);
        
        levelOrderRecursion(root.left, level+1);
        levelOrderRecursion(root.right, level+1);
    }
    
    levelOrderRecursion(root, 0);
    return Object.values(result);
};
```

广度优先遍历模版：
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
## 2、贪心算法
贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有
利）的选择，从而希望导致结果是全局最好或最优的算法。

### 2.1、与动态规划的区别
贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退；动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

### 2.2、适用贪心算法的场景
简单地说，问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解称为最优子结构。
  
## 3、二分查找
### 3.1、二分查找的前提
1. 目标函数单调性（单调递增或者递减）
2. 存在上下界（bounded）
3. 能够通过索引访问（index accessible)

### 3.2、代码模版
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

