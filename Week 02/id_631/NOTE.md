# 第二周学习总结

1.哈希表
哈希表是由Hash函数将各种类型的键映射为数值，从而可以直接在数组(内存)连续存储位置随机访问的数据结构。好的哈希函数能够减少哈希冲突。处理哈希冲突一般有拉链表法和开放寻址法。java HashMap使用的是拉链表法，将拥有相同哈希值的数据保存在一个链表中，当链表长度超过TREEIFY_THRESHOLD时，会使用红黑树代替链表来储存数据。从而避免链表很长时，导致哈希表的查询时间复杂度从O(1)退化为O(n)。

哈希表插入，查询，删除的平均时间复杂度O(1)，最差时间复杂度O(n)，最差空间复杂度O(n)。

1.1 集合：Java HashSet是由HashMap实现。集合是不能存放重复的元素的数据结构。

2.树
树是一种二维数据结构。可以当成是有向无环图。

术语
父亲节点：一个节点含有子节点，则这个节点称为其子节点的父节点
儿子节点：一个节点含有的子树的根节点称为该节点的子节点
兄弟节点：拥有相同父亲节点的节点。
深度：root节点为第一层，每次到达下一个子节点，深度+1。

树和图的区别：有方向(从根到叶子)，有没有环, 算是一种特殊的图。

链表是特殊化的树，树是特殊化的图。

2.1 二叉树：儿子节点只有两个的树。

二叉树的节点的Java定义
```
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
```
2.2 二叉搜索树bst Binary Search Tree
定义：一棵空树，或者具有以下性质的二叉树：若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值

查询插入和删除的平均时间复杂度是log(n)，最差时间复杂度O(n)

遍历：
前序遍历：root -> left -> right
中序遍历：left -> root -> right
后续遍历：left -> right -> root

因此，前序遍历第一个值是根节点的值；后续遍历最后一个是根节点值。

3.递归，分治，回溯
3.1 递归
解决递归问题的四步模板：
    1. 递归终结条件    
    2. 处理当前层逻辑
    3. 下探到下一层
    4. 清理当前层。

解题思维要点
    1.不要人肉进行递归（不要画递归状态树，直接写函数）
    2.找到最近最简的方法，将其拆解成可重复解决的问题（重复子问题）
    3.数学归纳法思维

3.2分治法
重点是找重复性以及分解问题
分治法代码模板:
```
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
```
分治法解决问题的5步模板:
    1.递归终结条件
    2.分解子问题
    3.解决子问题
    4.处理子问题的答案，得到当前结果
    5.清理当前层状态

3.3回溯法

回溯法：一种选优搜索法，按选优条件向前搜索，以达到目标。但当探索到某一步时，发现原先选择并不优或达不到目标，就退回一步重新选择，这种走不通就退回再走的技术为回溯法，而满足回溯条件的某个状态的点称为“回溯点”。

典型例题: 8皇后问题