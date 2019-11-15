# NOTE

### Week-2-6-树、二叉树、二叉搜索树

链表也是通过指针将多个元素连到一起的数据结构，因此可以看作退化到一维的树

常用的二维数据结构：tree&graph，二者的区别：是否存在环

BST（二叉搜索树）: 左子树的`所有节点`的值均小于其根节点，右子树的`所有节点`的值均大于其根节点，且中序遍历是递增有序的（可用来判断BST是否合法）

树的常见操作：
access/search/insertion/deletion：O（logn）
插入与查询需要经过的路径类似，因此也是O（logn）

树通常使用递归调用操作，因为节点本身就是递归定义的，而且具有自重复性

> 递归算法不一定低效，慢的地方主要在多开一些栈，如果递归比较深的话；但是现代编译器的优化下，基本可以认为和循环效率差不多

### Week-2-7-范型递归

通过《盗梦空间》来类比递归思想：
1. 对称性
2. 通过参数同步
3. 环境是一份拷贝

递归模板：
```python
def recursion(level, para…):
	# terminator
	if ~:
		return
	# process logic in current level
	process(level, param)
	# drill down
	self.recursion(level+1, para…)
	# reverse the current level status if needed
```

> 所有面试题基本上几十行，说明肯定有重复性

注意点：
1，抛弃递归树以及人肉递归
2，找到最近重复子问题
3，数学归纳法思维

### Week-2-8-分治，回溯

分治可以看作一种特殊的递归,回溯法采用分步试错法探索搜索空间

最优重复性：动态规划

```python
def divide_conquer(problem, para…):
	# terminator
	if problem is None:
		print_result
		return
	# prepare data
	data = prepare_data(problem)
	subproblems=split_problem(problems, data)
	# conquer subproblem
	sub_result1=self.divide_conquer(subproblems[0], p1…)
	sub_result2=self.divide_conquer(subproblems[1], p1…) 	# process and generate the final result
	result = process_result(sub_result1, sub_result2…)

	# revert the global current level states
```


  

