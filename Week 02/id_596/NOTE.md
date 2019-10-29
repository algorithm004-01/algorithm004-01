# NOTE

## 课程笔记
### 哈希表、映射和集合
哈希表是我们比较常用的数据结构了，它有着优秀的搜索、插入和删除效率，这三个操作的时间复杂度都是O(1)。
在我自己的项目中，经常使用它作为储存各种缓存或者配置文件数据使用。
哈希表的底层数据结构是数组，核心实现原理是通过一个哈希算法将加入的数据转化成数组的索引，访问时即可直接读取数组对应索引的数据。
这样的设计必然会遇到一个问题，就是不同的数据在哈希算法后得到了相同的索引值，这时候就发生了“哈希碰撞“。
解决哈希碰撞的一个思路叫做“拉链式解决冲突法“，即将哈希值相同的数据组成一个链表，数组对应的索引就指向这个链表。搜索时需要遍历这条链表查找正确的数据。所以如果哈希算法设计的不好或者过于简单，产生大量的哈希碰撞，那么哈希表就会退化为链表。

映射(map)和集合(set)的底层都是用哈希表实现的，具有和哈希表一样时间复杂度的操作，不同的是映射保存的是一组key-value，而set只是value。map的key不会重复，set的value不会重复。

### 树
由于树本身的结构特征，无法有效的迭代循环代码比较复杂，所以一般遍历都使用的是递归的方式。按照访问结点值和子结点的顺序有下面三种遍历。

- 前序遍历 - 中左右
- 中序遍历 - 左中右
- 后序遍历 - 左右中

每个节点最多拥有左右两个子结点的树就叫做二叉树。

二叉搜索树，也称有序二叉树（Ordered Binary Tree）、排序二叉树（Sorted Binary Tree），是指一颗空树或者具有下列性质的二叉树：

1. 左子树上所有结点的值均小于它的根结点的值
2. 右子树上所有结点的值均小于它的根结点的值
3. 以此类推：左右子树也分别为二叉查找树。

中序遍历的话会得到升序排列的所有结点值。
二叉搜索树的查询、插入、删除都要O(logn)的时间复杂度。

#### 为什么树的面试题解法一般都是递归
- 树的节点的定义就是用递归的方式进行的，树在定义它数据结构和算法特性的时候有重复性（自相似性）。
- 递归的本质就是有规律的重复，而树的结构也是如此，可以不断的拆成子树。

### 递归

递归可以理解为通过函数体来进行的循环，和循环没有明显的边界。

## 递归特性

- 向下进入不同递归层，向上又回到原来一层
- 用参数来进行函数不同层之间的传递变量
- 每一层的环境变量都是一份拷贝，结果通过参数或者全局变量返回

## 递归模版

    def recursion(level,param1,param1,...):
    	# recursion terminator
    	if level > MAX_LEVEL:
    		process_result
    		return
    	
    	# process logic in current level
    	process(level,data...)
    
    	# drill down
    	self.recursion(level+1,p1,..)
    	
    	# reverse the current level status if needed

## 思维要点

1. 不要人肉进行递归（最大误区）
2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
3. 数学归纳法思维

## 分治、回溯

### 分治模版

    def divide_conquer(problem, param1, param2, ...): 
      # recursion terminator 
      if problem is None: 
    	print_result 
    	return 
    
      # prepare data 
      data = prepare_data(problem) 
      subproblems = split_problem(problem, data) 
    
      # conquer subproblems 
      subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
      subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
      subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
      …
    
      # process and generate the final result 
      result = process_result(subresult1, subresult2, subresult3, …)
    	
      # revert the current level states

### 回溯

典型应用：八皇后问题，数独

在每一层尝试所有可能，没有找到解则返回上一层