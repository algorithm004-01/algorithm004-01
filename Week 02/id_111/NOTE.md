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

  

