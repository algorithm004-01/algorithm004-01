# 学习总结
## 1、哈希表 
哈希表（Hash table），也叫散列表，是根据关键码值（Key value）而直接进行访问的数据结构。 它通过把关键码值映射到表中一个位置来访问记录，以加快查找的
速度。 这个映射函数叫作散列函数（Hash Function）存放记录的数组叫作哈希表（或散列表)

### 1.1 应用场景
用来实现MAP、SET，主要优势在于快速(O(1))寻找某个元素。

## 2、二叉树
链表查询速度比较慢，因此出现了跳表的数据结构.本质上要加速的话，在于升维，二维的数据结构就是树和图，而且也非常适合人的认知，生活中很多问题都是树状状态，如：递归状态树也是树形结构、棋盘状态等也是树状机构。
> 树和图的差别最关键是有没有环

> Linked List 是特殊化的 Tree，Tree 是特殊化的 Graph


### 2.1、二叉树的遍历
- 前序（Pre-order）：根-左-右
- 中序（In-order）：左-根-右
- 后序（Post-order）：左-右

### 2.2、二叉搜索数
二叉搜索树，查找时间复杂度是O(logN),是指一棵空树或者具有下列性质的二叉树： 
1. 左子树上所有结点的值均小于它的根结点的值； 
2. 右子树上所有结点的值均大于它的根结点的值； 
3. 以此类推：左、右子树也分别为二叉查找树。 （这就是重复性！）

> 中序遍历后得到的结果是升序的。

为什么树的面试题解法一般都是递归，原因是： 
1. 节点的定义本来就是递归的
2. 重复性（自相似性）

## 3、递归
递归本质就是循环，在汇编语言里其实没有递归循环机器码，都是goto。递归的循环是通过函数体来实现。

> 盗梦空间的例子，每一层梦境就是一层递归
- 向下进入到不同梦境中；向上又回到原来一层
- 通过声音回到上一层
- 每一层的环境和周 围的人都是一份拷贝 
    
    主角等几个人穿越不同层级的梦境（发生和携带变化

### 3.1、递归模版
```
function recur(level, param) { 
  // terminator,递归终结条件 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  } 
  // process current logic，处理当前层逻辑 
  process(level, param); 
  // drill down ，下探到下一层
  recur( level: level + 1, newParam); 
  // restore current status ，清理当前层
  
```
### 3.2、思维要点
1. 不要人肉进行递归（最大误区）
2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
3. 数学归纳法

### 3.3、分治代码模版
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
...
# process and generate the final result 
  result = process_result(subresult1, subresult2, subresult3, …) 
  
  # revert the current level state
```
多了一步合并子结果的操作

## 4、算法基本思想总结
### 4.1 递归
直接或间接地调用自身的算法称为递归算法，包含范围比较广，其主要是一种编程技巧。

### 4.2 分治法
其思想精髓就是分而治之 ，将原问题划分成K个规模较小，并且结构与原问题相似的子问题，递归地解决这些子问题，然后再合并其结果，就得到原问题的解。

案例：Fibonacci数列，阶乘，二分法搜索、MapReduce

### 4.3 动态规划法
动态规划过程是：依据当前（阶段）状态，採取对应的决策，引起状态的转移。

与分治法最大的区别是：适合于用动态规划法求解的问题，经分解后得到的子问题往往不是互相独立的。

其特点是：“一个模型三个特征”
> “多阶段决策最优解模型”，最优子结构、无后效性和重复子问题

典型样例：最长公共子序列、背包问题

### 4.4 贪心算法
贪心算法总是做出对当前看来是最好的选择，但是当前最好并不意味着整体最好。因此贪心算法不能保证找到的解是最优解，但在某些情况下能够是最优解的近似解，甚至是最优解。

典型样例：霍夫曼编码（Huffman Coding）、钱币找零问题

### 4.5 回溯法
回溯的处理思想，有点类似枚举搜索。为了有规律地枚举所有可能的解，避免遗漏和重复，我们把问题求解的过程分为多个阶段。每个阶段，我们都会面对一个岔路口，我们先随意选一条路走，当发现这条路走不通的时候（不符合期望的解），就回退到上一个岔路口，另选一种走法继续走。

典型样例：正则表达式、八皇后问题



  

