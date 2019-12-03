# 哈希表、映射、集合的实现与特性
## 1. 哈希表 (Hash table) /散列表
- 时间复杂度（此处插入课件中的时间复杂度图表）
### 定义
    通过关键码值(Key value) 直接进行访问的数据结构
    即任何一个对象传入会映射成一个 int 的下标
    映射函数称为散列函数（Hash Function）/哈希函数，存放记录的数组称作哈希表
- 好的哈希函数能让数据尽可能地分散，避免过多地哈希碰撞（Hash Collisions）
- 为了避免碰撞，在同一个位置会拉一个链表
- 在没有哈希碰撞的情况下，哈希函数的增删查询时间复杂度为O(1) ,存在哈希碰撞，且链表堆积较长时，哈希函数的查询就成了O(n)
- 同一个位置一个元素为完美哈希
- 高级语言（）及各种库已经集成了相关的库
    Hash table java 10
    
...
## 2. 映射 Map (Dict)
    Key-value 对 ，key 不重复
**API(java)：**
- new HashMap() /new TreeSet() [TreeSet是使用二叉搜索树实现的
- new HashMap() / new TreeMap() 
- map.set(key, value) 
-  map.get(key)  
-  map.has(key)  
-  map.size()  
-  map.clear() 

## 3. 集合 Set (set、list)
    不重复元素集合（单个元素）
**API(java):**
- new HashSet() / new TreeSet()  
- set.add(value)  
- set.delete(value)  
- set.hash(value)
# 工程实现
- 用户信息表
- 缓存 LRU Caches
- 键值对 Redis
HashMap 小总结
## 实战题目
- 242 有效字母异位词
    字母个数一样但出现位置不一样
    - 暴力解题法：
    直接 sort 然后看 sorted_str 是否相等
    hash,map --> 统计每个字符的频次
- 49 字母异位词分组
- 1 两数之和
    - 暴力求解
    - 数组变形 tuple
    - 使用哈希表 ：枚举 a 找 target - a 是否也在数组里面
    - 将整个数组放在哈希里面，外层复杂度O(n)，内层哈希表O(1)
## 算法题面试流程
1. clarification
与面试官过一遍题目，明确模糊或不理解的地方
2. possible solutions --> optimal(time&space)
阐述可能的解决办法，分析时间空间复杂度
3. code
编码
4. test cases
实现测试
# 树、二叉树、二叉搜索树的实现与特性
## 定义与结构
- 二维，当链表的next指针指向多个节点时，就成了树
根节点(Root)，左子树 ，右子树，父节点(Parent Node)，子节点（Child Node）
- 树与图最根本的区别为是否有环
    - 链表Linked List 为特殊的树Tree
    - 树Tree 为特殊的图Graph
- 斐波那契数列 求解
暴力解法，最终扩散成树的状态
- 遍历树
写循环相对麻烦，写递归简单
## 二叉搜索树
    也称有序二叉树 Ordered Binary Tree , 排序二叉树 Sorted Binary Tree
**定义**
1. 左子树上所有结点的值均小于它的根结点的值；
2. 右子树上所有结点的值均大于它的根结点的值；
3. 以此类推：左、右子树也分别为二叉查找树。
## 常见操作 均为O(logn)
- 查询 （与二分搜索的时间复杂度一致
- 插入新节点（查找的过程中如果没找到，应在没找到的这个位置插入
- 创建(create) 不断调用插入即可
- 删除
    1. 如果为叶子节点，直接删除即可；
    2. 如果为关键节点
        - 使用左侧小于它的数据中最大值替代，删除关键结点，同时对后面的节点进行挪动
        - 或使用右侧大于它的数据中的最小值（一般采用此方案），删除关键结点，同时对后面的节点进行挪动
- 特殊情况
    - 仅有右节点（及退化为链表），此时复杂度为O(n)
# 二叉树的遍历
## 前中后序遍历
## leetcode 题目

# 递归的实现、特性、
## 理论部分
    树的面试题解法一般是递归
### 递归的本质是循环
- 循环体调用自身
- 类比《盗梦空间》
    - 向下进入不同梦境，向上回到上一层
    - 每层之间相互独立
    - 可以穿越梦境的主角类似于参数
    - 简单递归形式
        - 求阶乘 n!
        - n! = 1*2*3*4*5...*n
        - 代码实现
        def Factorial(n): if n <= 1: return 1 return 1​ n* Factorial(n -1 )​​​
    - 递归栈
- 递归注意点
  1. 不要人肉递归（画递归图辅助理解，入门可使用，进阶需抛弃，直接看函数）
  2. 找最近重复子问题
  3. 数学归纳法
    1 成立、2 成立 ，同时可证明n成立 n+成立
  4. 机械化记忆递归代码模板
## 算法题
- 爬楼梯
- 找最近重复性
- 思考到三级台阶时，考虑重复性问题，否则陷入人肉递归
    f(3)=f(1)+f(2)
    f(n)=f(n-1)+f(n-2)
    mutual exclusive | complete exhaustive
    括号生成
    https://leetcode-cn.com/problems/generate-parentheses/

# 分治 Divide & Conque
    本质就是递归，找重复性，递归为多个子问题
-   分治代码模板
    泛型递归模板(类似)
    回溯 Backtracking

-   leecode 22 生成括号
    - 暴力回溯
建立完六层，最后发现不可行，去掉，再回到前一层
分治、回溯习题
leecode 50 Pow(x,n) **高频**
    - 暴力法：
for 循环n 次，得到x的n次方
时间复杂度为O(n)
    - 分治
- 递归模板：
  1. terminator 终结条件
  2. process(split your big problem)
  3. drill down (subproblems),merge (subresult)
  4. reserve states
- pow(x,n)
    - subproblem : subresult = pow(x,n/2)
    - merge:
判断奇偶，进行处理（考虑负数问题，若负数，取其绝对值进行判断
if n % 2 ==1: result = subresult * subresult *xelse result = ​​​ subresult * subresult
时间复杂度 O(logn)
    - 快速幂法
    - 牛顿迭代
- leetcode 78.子集
写过排列组合再看此题


