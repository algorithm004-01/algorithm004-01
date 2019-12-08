# 学习总结

## 数组、链表、跳表、栈

### 数组 Array

在内存中开辟了连续的地址存储数据
时间复杂度 prepend O(1) append O(1) lookup O(1) insert O(n) delete O(n)

### 链表 Linked list

链表不需要连续的内存空间，通过指针将零散的内存块串联起来使用​
时间复杂度 prepend O(1) append O(1) lookup O(n) insert O(1) delete O(1)

常见的链表结构
单链表
双向链表
循环链表
常见的缓存策略
先进先出 FIFO(First In, First out)
最少使用 LFU(Least Frequently Used)
最近最少使用 LRU(Least Recently Used)

### 跳表 Skip list

升维思想，空间换时间
把链表变成二维空间，使用了更多的索引节点
跳表的时间复杂度与红黑树一致，但是实现起来更简单
在并发环境下跳表有另一个优势，红黑树在插入和删除的时候可能需要做 rebalance 操作，可能会涉及到整个树的其他部分，而跳表的操作更局部一些，锁住的节点更少，这样性能会更好一些

## 队列、双端队列、优先队列

### 栈 Stack

从栈的操作特性上来看，栈是一种“操作受限”的线性表，只允许再一端插入和删除数据。栈主要包含连个操作，入栈和出站，也就是在栈顶插入一个数据和从栈顶删除一个数据
先进后出，后进先出
栈的实现
用链表实现的栈，叫链式栈
用数组实现的栈，叫顺序栈
时间复杂度 access O(n) search O(n) insert O(1) delete O(1)

### 队列 Queue

先进先出，后进后出
时间复杂度 search O(n) access O(n) insertion O(1) deletion O(1)

### 双端队列 Deque: Double-End Queue

双端队列可以在队首添加/删除元素，也可以在队尾添加/删除元素在实际应用中，一般使用双端队列替代普通队列​
Queue 和 Stack 的结合体
时间复杂度 access O(n) search O(n) insertion O(1) deletion O(1)

### 优先队列 PriorityQueue

时间复杂度 insert O(1) pop O(logN)

## 心得

1. 在做题之前仔细读题非常重要，先搞清楚题目的意思，免得写了半天代码才发现起点就错了。
2. 先在草稿纸上画下最简单情况的图解，很有助于找出重复部分。
3. 添加辅助指针真的是个非常有用的方法。
