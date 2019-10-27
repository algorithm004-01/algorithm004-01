# NOTE

实战题目 / 课后作业

    https://leetcode-cn.com/problems/valid-anagram/description/
    https://leetcode-cn.com/problems/group-anagrams/
    https://leetcode-cn.com/problems/two-sum/description/

参考链接

    养成收藏精选代码的习惯（示例） https://shimo.im/docs/R6g9WJV89QkHrDhr/read


[二叉搜索树 Demo](https://visualgo.net/zh/bst)

中序遍历是递增的

## 树

没有环的图

树的递归
由于树的特性，关于树的问题就可以分解为求解树的左右子树的子问题。而递归就是把问题分解为求解子问题的一种方法，树刚好符合这个特性。使用递归也更加简单，更容易理解

## 二叉树

## 二叉搜索树

1. 查询 log(n)
2. 插入 log(n)

树的遍历：是由根结点定义

前序遍历， 中序遍历， 后序遍历

实战题目 / 课后作业

https://leetcode-cn.com/problems/binary-tree-inorder-traversal/

递归要使用缓存，存储中间值，还是很快的，可以简单看成和 for 性能一样

https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/ 广度优先遍历

1. 官方题解

## [递归代码模板](https://shimo.im/docs/DjqqGCT3xqDYwPyY/read)

递归-循环

1. 递归终结条件
2. 处理当前层逻辑
3. 下探到下一层
4. 清理当前层

3个思维要点：

1. 不要人肉进行递归(最大误区)
2. 找到最近最简的方法，将其拆解为可以解决的子问题（最近重复子问题）
3. 数学归纳法的思维

Python 代码模板

```python
def recursion(level, param1, param2, ...):
    # recursion terminator
    if level > MAX_LEVEL:
       process_result
       return

    # process logic in current level
    process(level, data...)

    # drill down
    self.recursion(level + 1, p1, ...)

    # reverse the current level status if needed
```

Java 代码模板

```java
public void recur(int level, int param) {

  // terminator
  if (level > MAX_LEVEL) {
    // process result
    return;
  }

  // process current logic
  process(level, param);

  // drill down
  recur( level: level + 1, newParam);

  // restore current status

}
```

实战题目

https://leetcode-cn.com/problems/climbing-stairs/
https://leetcode-cn.com/problems/generate-parentheses/

- 左括号，不要超过总数
- 左括号 > 右个数

https://leetcode-cn.com/problems/invert-binary-tree
https://leetcode-cn.com/problems/validate-binary-search-tree
https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/

每日一课

[如何优雅地计算斐波那契数列](https://time.geekbang.org/dailylesson/detail/100028406)

课后作业

https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
https://leetcode-cn.com/problems/combinations/
https://leetcode-cn.com/problems/permutations/
https://leetcode-cn.com/problems/permutations-ii/

## 分治，回溯

找重复性

[分治代码模板](https://shimo.im/docs/3xvghYh3JJPKwdvt)

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
  subresult3 = self.divide_conquer(subproblems[2], p1, ...)

  # process and generate the final result
  result = process_result(subresult1, subresult2, subresult3, …)

  # revert the current level states
```

[括号生成问题](https://leetcode-cn.com/problems/generate-parentheses/)

预习题目

    https://leetcode-cn.com/problems/powx-n/
    https://leetcode-cn.com/problems/subsets/

参考链接

    [牛顿迭代法原理](http://www.matrix67.com/blog/archives/361)
    [牛顿迭代法代码](http://www.voidcn.com/article/p-eudisdmk-zm.html)

实战题目

    https://leetcode-cn.com/problems/majority-element/description/ （简单、但是高频）
    https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
    https://leetcode-cn.com/problems/n-queens/
