# 学习总结-Queue的源码分析

## Java版本1.8

## 主要方法

- boolean add(E e)
> 在队列头部插入元素
> 大于最大容量时，会抛出异常

- boolean offer(E e)
> 插入一个元素到队列中，失败时返回fals

- E remove()
> 返回并移除队列的头部元素

- E poll()
> 返回并移除队列的头部元素，队列为空时返回null

- E element()
> 返回队列头部的元素

- E peek()
> 查看队尾元素，当不取出元素
> 若队列为空则返回Null

# Deque接口

## 双端队列

## 主要方法

- add(E e) 将新元素添加到队列的尾端（当不超过队列的容量时）

- addFirst(E e) 将新元素添加到队列的头部

- addLast(E e) 将新元素添加到队列的尾部

- contains(Object o) 双端队列是否含有对象o

- descendingIterator() 倒叙返回队列的迭代器

- element() 返回队列的头部元素

- getFirst() 获取头部元素

- getLast() 获取尾部元素

- iterator() 迭代队列

- offer(E e) 将新元素插入到队列尾部

- offerFirst(E e) 将新元素添加到队列的头部

- offerLast(E e) 将新元素添加到队列的尾部

- peek() 返回队列的头部元素

- peekFirst() 获取头部元素

- peekLast() 获取尾部元素

- pool() 返回并移除队列的头部元素

- poolFirst() 获取并移除头部元素

- poolLast() 获取并移除尾部元素

- pop() 将一个元素出栈

- push(E e) 讲一个元素压入栈

- remove() 移除队列的头部元素

- remove(Object o) 移除队列中第一个o

- removeFirst() 移除队列的头部元素

- removeFirstOccurrence(Object o) 移除队列中第一个o

- removeLast() 移除队列的尾部元素

- removeLastOccurrence(Object o) 移除队列中最后一个o

- size() 获取队伍元素个数