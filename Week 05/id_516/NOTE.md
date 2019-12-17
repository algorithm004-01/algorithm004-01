## 笔记

> 分治回溯+ 递归 +动态规划
>
> 分治： 变成子问题 
>
> 本质没有非常大的区别 都是 寻找重复性 
>
> 动态规划
>
> 2. "Simplifying a complicated problem by breaking it down into simpler sub-problems" (in a recursive manner) 把指数级变成了 多项式级别
>
> 3. Divide & Conquer + Optimal substructure 
>
> 动态规划和递归或分治没有根本上的区别(关键在有无最优的子结构)
>
> 共性：找到重复子问题
>
> 差异性：最优子结构、中途可以淘汰次优解



### 模板

#### 递归代码模板

```java
public void recur(int level,int param) {
  // terminator
  if (level > MAX_LEVEL) {
    return ;
  }
  // process current logic
  process(level,param);
  
  // drill down 
  recur(level + 1,newParam);
  
  // restore current status
}
```



#### 分治

```python
def divide_conquer(problem,param1,param2,...):
  # problem terminator 终
  if problem is None:
    print_result
    return
  # prepare data 治
  data = prepare_data(problem)
  sub_problems = split_problem(problem,data)
  
  # conquer subproblems 分
  sub_result1 = self.divide_conquer(sub_problems[0],param1,param2,...)
  sub_result2 = self.divide_conquer(sub_problems[1],param1,param2,...)
  ...
  
  # process and generate the final result 合并
  result = process_result(sub_result1,sub_result2,...)
  
  # revert the current level status 复原 
  
```



#### 动态规划模板

```java
// 待总结 for 循环
```



### 动态规划

1. 分治（找子问题）
2. 状态数组定义
3. 写DP方程

> 1. 分治（找子问题）max_sum(i) = Max(max_sum(i - 1),0) + a[i]
> 2. 状态数组定义： f[i]
> 3. DP方程 f[i] = Max(f[i - 1],0) + a[i]



fib (实际上并非动态规划)

> 1. 分治找子问题 f(n) = f(n - 1) + f(n - 2)
> 2. 状态数组定义 f[i]
> 3. DP 方程 f[i] = f[i - 1] + f[i - 2]



Count the paths

> 1. 分治找子问题 count(i,j) = count(i+1,j) + count(i,j+1)
> 2. 状态数组定义 ```counts[i][j]```
> 3. 



coin change dp

> 1.分治（子问题） 





打家劫舍

> 1. 分治（子问题） max_sum(i) = max_sum(i - 2) + a[i]
>
> 2. 状态数组定义 f[i]
> 3. dp方程 f[i] = f[i - 2] + a[i]





### 总结



这周出差比较忙，所以学习这块并没有非常用心。