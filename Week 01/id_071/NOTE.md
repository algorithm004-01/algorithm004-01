# NOTE

### 数组、链表、队列、栈都是线性表结构。


    线性表 linear list
    
    数据排成像一条线一样的结构。每个线性表上的数据最多只有前和后两个方向。

> 数组 array 内存管理


    数组 ：是一种线性表数据结构，它用一组连续的内存空间来存储一组具有相同类型的数据。

    数组 最大的特点就是支持随机访问，但插入、删除操作比较低效。平均情况实际复杂度为O(n)。
    
    var arr = [3]int{1,2,3}
    arr := [3]int{2,3,4}
    mul := [2][3]int{{1,2,3},{4,5,6}}
    
> 链表 linked list  LRU Cache

##### 单链表
    
    next
    
##### 双向链表
    
    next
    previous
    
##### 循环链表

    尾指针(Tail) 指向 头指针 (Head)

> 跳表 skip list Redis

    通过添加 索引 来实现空间换时间的方式，提高查询速度。


> 栈 stack


    最近相关性
    先进后出
    
> 对列 queue


    先进先出

> 双端对列 deque Double-End Queue 


    头部和尾部都可以进行 push/pop 操作


> 优先队列 priority queue 

    按照 优先级取出
    插入操作 O(1)
    查找操作 O(logn)
    

### 思维方式


> 1、升维（一维 到 二维 到多维）


> 2、空间换时间

    
> 3、双指针 就是利用两个指针去遍历数组。一般来说，遍历数组采用的是单指针（index）去遍历，两个指针一般是在有序数组中使用，一个放首，一个放尾，同时向中间遍历，直到两个指针相交，完成遍历。时间复杂度也是O(n)。


    两数之和满足某条件
        先对数组排序，再采用两个指针，分别从前和后往中间遍历，front增大，tail减小，通过对条件的判断，可以在O(n)内遍历，而非使用双重循环。
    in place交换
        一个指针正常遍历，另一个指针去找可以用来交换的元素。


action | array | linked list | skip list 
---|--- |--- |---
prepend | O(1) | O(1) | O(1)
append | O(1) | O(1) | O(1)
lookup | O(1) | O(n) | O(logn)
insert | O(n) | O(1) | O(1)
delete | O(1) | O(1) | O(1)


[双指针](https://linzhenglearn.github.io/2017/03/29/TwoPointer/#remove-duplicates-from-sorted-array)
