# 动态规划笔记
# 分治+回溯+递归+动态规划
## 递归(recursive)代码模板
  1. 递归终止条件
  2. 处理当前层逻辑
  3. 下探到下一层 drill down
  4. 恢复当前层状态
## 分治
  自相似性（将大问题分解成相似的小问题，解决问题后将结果聚合在一起）
### 分治代码模板
  1. 递归终止条件
  2. split 拆分
  3. 调用递归函数，每个子问题都进行调用
  4. subresult 合并结果
  5. 恢复当前层状态
## 思维感悟
  **人肉递归低效**
  **找最近最简法，将其拆分为可重复解决的问题**
  **数学归纳法**
  斐波那契状态数
## 动态规划 Dynamic Programming （动态递归）
  - http://wikipedia.moesalih.com/Dynamic_programming
  - 最优子结构
  - 动态规划与递归或分治无根本上的区别（有无最优子结构）
共性：找重复子问题
差异：最优子结构、中途可淘汰次优解（将指数级复杂度降到多项式级别）
### 实战例题
**斐波那契数列 Fibonacci  sequence**
傻递归 （指数级时间复杂度）
> int fib (int n){ 
  if (n <= 0){
  return 0;
  ​​​ }
  else if (n == 1){ 
  return 1; ​​}
  else { return fib (n - 1) + fib(n-2);
  ​​}
  ​}
 > 
**简化代码**
- 一，简洁，使用表达式书写（未改变时间复杂度）
> JAVAint fib(int b)​{ return n<=1 ? n:fib(n-1)+fib(n-2);​​}
> 
- 改变时间复杂度，加入缓存（可存放至数组，python 可用 LRU cache）
**记忆化搜索(加缓存)**
> 
int fib (int n, int [] memo) { if (n <= 0) { return 0; ​​} else if (n == 1) { return 1; ​​} else if (memo [n] == 0){ memo [n] = fib (n - 1) + fib (n - 2); ​​} return memo[n];​​​}
- 简化上述代码
> int fib (int n, int [] memo) { if (n <= 1) { return n; ​​} ​​if (memo [n] == 0){ ​#若值没有被计算过 memo [n] = fib (n - 1) + fib (n - 2); ​​} return memo[n];​​​}

  

