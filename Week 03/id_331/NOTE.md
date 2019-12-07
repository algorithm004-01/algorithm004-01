# NOTE

  

#### DFS代码 - 递归写法

```java
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



#### DFS代码 - 非递归写法

```java
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



#### BFS 代码模块

```java
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



#### 贪心算法 Greedy

##### 定义

贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。



##### 适用贪心算法的场景

简单地说，问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解称为最优子结构。



#### 二分查找

##### 前提

- 目标函数单调性（单调递增或递减）
- 存在上下界
- 能够通过索引访问



##### 代码模板

```java
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



##### 课后习题

>  使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方 

```java
class Solution {
  
  //思路：
  //1.直接套用代码模板，先将left,right,mid三个指针找到。
  //2.如果nums[mid]大于nums[right]，说明右端无序，将left指针移动到mid+1
  //3.如果nums[mid]小于nums[right],说明左端无序，将right指针移动到mid+1
  //4.当left > right,取nums[left]
  public int search(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int left = 0;
    int right = nums.length - 1;
    int mid;
    while (left <= right) {
      mid = (left + right) / 2;

      if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return nums[left];
  }
}
```

