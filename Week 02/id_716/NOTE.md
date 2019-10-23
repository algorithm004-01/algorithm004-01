# NOTE

## 关键部分笔记

#### 哈希表、映射、集合

- Java 中HashMap、Set的实现分析
- 讲解题目：242，49
1. https://leetcode-cn.com/problems/valid-anagram/description/  (done)
2. https://leetcode-cn.com/problems/group-anagrams/ (done)
3. https://leetcode-cn.com/problems/two-sum/description/ (done)
  
#### 树、二叉树、二叉搜索树

- 树的定义和基本特性
- 应用广泛的二叉树
- 树的遍历
- 二叉搜索树及操作，查找、插入、删除
- 树的面试题解法一般都是递归，为什么？
- 讲解题目：树的遍历
1. https://leetcode-cn.com/problems/binary-tree-inorder-traversal/  (done)
2. https://leetcode-cn.com/problems/binary-tree-preorder-traversal/ (done)
3. https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/ (done)
4. https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/  (done)
5. https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/ (done)

#### 范型递归、递归树

- 递归
1. 递归的本质是循环，在汇编层是没有循环的，只能通过不停调用重复代码来实现循环的效果
2. 递归是重复性的进行，在现实中也会有体现
3. 可以借鉴电影盗梦空间来理解递归（向下进入到不同层，向上又回到原来的一层；返回上一层可以携带返回值，来改变上一层的状态；每一层都是新的拷贝，每一层可以修改状态，然后返回）

归去来兮，剥洋葱的感觉

- 递归代码模版：https://shimo.im/docs/DjqqGCT3xqDYwPyY/read
1. 先写递归终止条件
2. 当前层的逻辑处理
3. 陷入到下一层
4. 清理当前层

- 递归的难点和误区
1. 不要人肉递归（最大误区）
2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
3. 数学归纳法思维

- 讲解题目：70，22
1. https://leetcode-cn.com/problems/climbing-stairs/
2. https://leetcode-cn.com/problems/generate-parentheses/
3. https://leetcode-cn.com/problems/invert-binary-tree/description/
4. https://leetcode-cn.com/problems/validate-binary-search-tree
5. https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
6. https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
7. https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
8. https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
9. https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
10. https://leetcode-cn.com/problems/combinations/
11. https://leetcode-cn.com/problems/permutations/
12. https://leetcode-cn.com/problems/permutations-ii/

#### 分治、回溯

- 一种特殊的递归
- 分治：将一个大问题分解为多个子问题，然后merge子问题

- 分治模版
1. 终止条件
2. 准备数据，拆分子问题
3. 处理子问题，处理、合并生成最终结果
4. 清理状态

- 讲解题目：
1. https://leetcode-cn.com/problems/powx-n/
2. https://leetcode-cn.com/problems/subsets/
3. https://leetcode-cn.com/problems/majority-element/description/ （简单、但是高频）
4. https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
5. https://leetcode-cn.com/problems/n-queens/

---

## 总结正文

### 【716-Week 02】

// todo

#### HashMap 总结

// todo

