# 【701-week2】第二周学习总结

## 第五课

### 哈希表

> 哈希表（Hash table），也叫散列表，是根据关键码值（Key value）而直接进行访问的数据结构。它通过把关键码值映射到表中一个位置来访问记录，以加快查找的 速度。这个映射函数叫作散列函数（Hash Function），存放记录的数组 叫作哈希表（或散列表）。

时间复杂度平均为：O(1)，最坏情况为 O(n)

工程实践

- 电话号码簿
- 用户信息表
- 缓存（LRU）
- 键值对存储（Redis）

### 映射

> key-value 对集合，其中 key 不能重复

时间复杂度平均为：O(n)

### 集合

> 不重复元素的集合

时间复杂度平均为：O(n)

## 第六课

### 树

> 链表是特殊化的树，树是特殊化的图

### 二叉树

遍历：

- 前序：根-左-右
- 中序：左-根-右
- 后序：左-右-根

### 二叉搜索树

二叉搜索树，也称二叉搜索树、有序二叉树（Ordered Binary Tree）、 排序二叉树（Sorted Binary Tree），是指一棵空树或者具有下列性质的二叉树：
 
1. 左子树上 **所有结点** 的值均小于它的根结点的值； 
2. 右子树上 **所有结点** 的值均大于它的根结点的值； 
3. 以此类推：左、右子树也分别为二叉查找树。（这就是重复性！）

<div align="center">

![BSTSearch.png](images/BSTSearch.png)

</div>

复杂度分析：
    - 查询/插入：Log(N)

## 第七课

### 泛型递归和树的遍历

思维要点：

- 不要人肉递归（最大误区）
- 找到最近最简方法，将其拆解成可重复解决的子问题（重复子问题）
- 数学归纳法思维

C# 代码模板

```C#
private void recursion(int level, int param)
{
    // terminator
    if (level > MAX_LEVEL){
        return;
    } 

    //process current logic
    process(level, param)

    // drill down
    recursion(level+1, newParam);

    //restore current status
}
```


## 第八课

### 分治（递归状态树）

> 将任务进行递归式分解，并在每次递归中解决当前子问题

代码模板

```python
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
    subresult3 = self.divide_conquer(subproblems[2], p1, ...)   ...  
    
    # process and generate the final result   
    result = process_result(subresult1, subresult2, subresult3, …)    

    # revert the current level states
```

### 回溯

回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问 题的答案。

回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况：

- 找到一个可能存在的正确的答案；
- 在尝试了所有可能的分步方法后宣告该问题没有答案。

在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。



