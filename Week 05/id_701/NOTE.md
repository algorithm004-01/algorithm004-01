# 【701-week5】第五周学习总结

### 递归

```python
def recur(level:int, param:int):
    # terminator
    if level > MAX_LEVEL:
        # process result
        return
    
    # process current logic
    process(level, param)

    # drill down
    recur(level+1, newParam)

    # restore curret status
```

### 分治

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
    …  
    
    # process and generate the final result   
    result = process_result(subresult1, subresult2, subresult3, …)     
    
    # revert the current level state
```

注意事项：

- 避免人肉递归低效、很累
- 找到最近最简方法，将其拆解成可重复解决的问题
- 数学归纳法思维（抵制人肉递归的诱惑）

> 本质：寻找重复性 —> 计算机指令

### 动态规划

关键点：

- 动态规划 和 递归或者分治 没有根本上的区别（关键看有无最优的子结构） 
- 共性：找到重复子问题 
- 差异性：最优子结构、中途可以淘汰次优解

#### 字符串问题