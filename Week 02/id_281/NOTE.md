### 第二周学习总结

* hash表具有O(1)的查找时间复杂度，在遍历时间复杂度为O(n)时，可以考虑用hash表来代替遍历查找。
* hash表存在hash碰撞的情况，采用链表来处理，根据性能可改为红黑树实现。
  

#### 切题四件套回顾
* clarification
* possible solutions --> optimal(time&space)
* code
* test case

#### 遍历树
* 前序遍历
* 中序遍历
* 后序遍历

### 递归模板
```python
def recursion(level, param1, param2,...):
    # recursion terminator
    if level > MAX_LEVEL:
        process_result
        return

    # process logic in current level
    process(level, data, ...)

    #dirll down
    self.recursion(level + 1, p1, ...)

    # reverse the current level status if needed
```

#### 思维要点
* 不要进行人肉递归 （最大误区）
* 找到最近最简方法，将其拆解成可重复解决的子问题
* 数学归纳法思维


### 分治模板
```python
def divide_conquer(problem, parma1, param2, ...):
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
    subresult3 = self.divide_conquer(subproblems[0], p1, ...)
    ...

    result = process_result(subresult1, subresult2, subresult2, ...)

    # revert the current level status

```

### 回溯

* 回溯法采用的是错思想，尝试分步去解决一个问题。在分步解决问题的过程中，当通过尝试发现现有分步的答案不能得到有效的正确的解答时，它将取消上一步或者上几步的计算，在通过其他的可能的分步解答再次尝试寻找问题的答案。

* 回溯法通常采用递归的方法来实现。



