# NOTE

## 【716-Week 01】学习总结

本周总结标题：【716-Week 01】学会渐进式的优化思路

总结可以从两部分来做：关于算法本身新的认识和算法所涉及到的更加底层的知识（如OS层面的，编译原理层面的，或者Linux的代码实现中也会用到的东西等）
列一下这周可以做总结的地方

1. OS 内存管理的内存分配方式以及内存是如何管理的
2. 对 JDK 中使用数组的数据结构做个汇总，并逐一分析
3. JDK 的 System.arraycopy 为何高效

## 关键部分笔记

blabla...

---

## 总结正文

#### 【716-Week 01】学会渐进式的优化方法

俗话说，罗马不是一天建成的；所以，好的代码也不是一次就写出来的。结合之前的工作经验和本周对数十道算法题的代码编写，渐进式优化的思维和做事方法让我有了更深一步的体会。

大概介绍一下我写算法题解的方式：对每一道题连着做3天，每一次都尽量将知道的解法全部写一遍，大致如下：
1. 第一遍在 Leetcode 上写，提交得到反馈
2. 第二遍在 IDE 里写，使用 Java
3. 第三遍在 IDE 里写，使用 Golang
4. 老师课程中的例子使用 Java 编写后提交，练习题使用 Golang 编写后提交

渐进式优化的方式，是老师课程中“授之以渔”的方法；

--- 

#### 改写代码

使用add first或add last这套新的API改写Deque的代码

```java
import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();

        // add element to stack
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        // check the first element
        String peekFirst = deque.peekFirst();
        System.out.println(peekFirst);
        assert peekFirst.equals("c");
        System.out.println(deque);

        // pop
        while (deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }
}
```

#### Queue 和 Priority Queue 源码分析

##### Queue 源码分析

`Queue` 的实现比较多



##### Priority Queue 源码分析

`java.util.PriorityQueue` 是优先级队列的实现，底层依赖的核心数据结构是二叉堆，支持插入元素、删除元素、peek、poll、查找等核心功能；现从以下几点进行分析：

1. 使用的数据结构介绍
2. 容量增长策略
3. 核心API及分析（插入，删除，修改，查找/检查）

###### 1. 使用的数据结构介绍

`PriorityQueue` 使用了二叉堆，堆是一个完全二叉树，且每个节点大于（或者小于）他的左右子节点。完全二叉树这种数据结构非常适合使用数组来存储，从 `PriorityQueue` 源码中也得到证实，使用了 `transient Object[] queue;` 作为存储元素的容器；所有对 `PriorityQueue` 的操作其实都是对这个二叉堆的操作，下面我们会分析各种操作的具体方法和复杂度。

使用数组存储时，位置在n的节点，他的两个自己点的位置分别为：`2*n+1`和`2*(n+1)`

###### 2. 容量增长策略

```
public PriorityQueue();
public PriorityQueue(int initialCapacity);
public PriorityQueue(int initialCapacity, Comparator<? super E> comparator);
...
```
`PriorityQueue` 提供了数个构造方法，可以指定初始容量，如果不指定，默认是11；同时还可以指定 Comparator 接口，这个我们先忽略，这个只是用于比较两个对象的大小。

`PriorityQueue` 是使用数组存储的，那么容量是一个很关键的问题，分析可知，`PriorityQueue` 通过 `grow` 函数进行扩容，策略是：当前容量小于64时，每次增加2；当前容量大于64时，每次增长50%；扩容的过程是：计算新的容量 -> 申请新的数组 -> copy到新数组。

###### 3. 核心API及分析（插入，删除，修改，查找/检查）

- 插入操作 add/offer

```java
public boolean offer(E e) {
    // null 检查，直接抛出运行时异常
    if (e == null)
        throw new NullPointerException();
    modCount++;
    int i = size;
    // 判断数组容量，否则就扩容
    if (i >= queue.length)
        grow(i + 1);
    // 底层数组容量+1   
    size = i + 1;
    // 如果是第一个元素，放在第一个即可
    if (i == 0)
        queue[0] = e;
    // 不是第一个元素，进行堆化过程，以满足堆的特性
    else
        siftUp(i, e);
    return true;
}

// 堆化的插入过程, 这个过程是一个从下往上找的过程，直到堆顶或者中途结束
private void siftUpComparable(int k, E x) {
    Comparable<? super E> key = (Comparable<? super E>) x;
    while (k > 0) {
        // 找到位置k的父节点的位置, (k - 1) >>> 1 是无符号右移操作，相当于 (k - 1) / 2
        int parent = (k - 1) >>> 1;
        // 暂存父节点位置的元素
        Object e = queue[parent];
        // 和父节点位置的元素比较一下，如果要插入的元素小于父节点，就退出
        if (key.compareTo((E) e) >= 0)
            break;
        // 否则，把父节点下移
        queue[k] = e;
        // 继续往上找
        k = parent;
    }
    // 找到了合适的插入位置，就把要插入的元素放进去
    queue[k] = key;
}
```

时间复杂度分析，核心操作是插入堆化，每次查找就除2，可以简单评估出 2 ^ k = n, 最大查找次数 k = logn, 所以时间复杂度是 O(logn); 由于整个过程中并没有占用额外空间，空间复杂度是 O(1)

- 删除操作 remove/removeEq

```java
// 定位指定元素，找到位置并返回
private int indexOf(Object o) {
    if (o != null) {
        for (int i = 0; i < size; i++)
            if (o.equals(queue[i]))
                return i;
    }
    return -1;
}

// 这个删除的核心方法，删除指定位置的元素，删除后需要堆化，这个过程会有些复杂
private E removeAt(int i) {
    // assert i >= 0 && i < size;
    modCount++;
    int s = --size;
    // 如果是删除最后一个元素，直接删掉
    if (s == i) // removed last element
        queue[i] = null;
    else {
        // 取最后一个元素暂存，并删除最后一个元素
        E moved = (E) queue[s];
        queue[s] = null;
        // 进行删除的堆化过程，以满足堆的特性，主要是将最后一个元素插入到合适位置
        siftDown(i, moved);
        // 这里的意思是，如果删除的是叶子节点，就走插入堆化的流程，可参考上面的分析
        if (queue[i] == moved) {
            siftUp(i, moved);
            if (queue[i] != moved)
                return moved;
        }
    }
    return null;
}
// 这个是从上到下的堆化过程，其中 k 是要删除的位置，x 是要插入的元素
private void siftDownComparable(int k, E x) {
    Comparable<? super E> key = (Comparable<? super E>)x;
    // 为什么取一半? 主要是因为n个节点的堆，他的叶子节点的个数是 n/2, 如果是叶子节点的删除，只需要做
    // 从下到上的堆化过程即可，走插入流程；非叶子节点先进行从上到下的堆化
    int half = size >>> 1;        // loop while a non-leaf
    while (k < half) {
        int child = (k << 1) + 1; // assume left child is least
        Object c = queue[child];
        int right = child + 1;
        // 左右节点比较，如果右节点大就使用右节点
        if (right < size &&
            ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
            c = queue[child = right];
        // 如果要移动的左右节点小于要插入的数据就终止
        if (key.compareTo((E) c) <= 0)
            break;
        // 把较大的子节点移动到父节点的位置
        queue[k] = c;
        // 继续向下移动
        k = child;
    }
    // 插入到合适的位置
    queue[k] = key;
}
```

梳理下删除的流程就是：
1. 先找到删除元素的位置，不存在，就退出了
2. 取最后一个元素当作初始需要移动的数据，将这个元素插入到合适的位置（为什么是最后一个元素，我想是这样操作起来是最方便的把，不然，要保证是完全二叉树还是挺麻烦的）
3. 如果删除的元素是非叶子节点，就从他的子节点里找合适的节点往上移动，同时还要和取出来的最后一个元素比较，谁大谁就留在那个位置，就这样一直比较下去，直到叶子节点或者中途退出
4. 如果删除的是叶子节点，或者取出的最后一个元素比删除的元素的子节点都大（还需要看是不是比删除元素的父节点也大，所以需要向上做堆化），就需要做一个从下向上的插入堆化过程

- poll peek contains

这些操作都比较简单：
poll: 取堆顶元素，然后做一个从上到下的堆化过程，可以参考 remove 的 `siftDownComparable` 流程，时间复杂度O(logn)
peek: 取数组第一个元素返回即可，时间复杂度O(1)
contains: 遍历数组一遍，找是否有相等的元素，时间复杂度O(n)

到此 `PriorityQueue` 的核心功能基本分析完成。
