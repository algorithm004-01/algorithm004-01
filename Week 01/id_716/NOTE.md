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

#### 【716-Week 01】关于复杂度分析和渐进式优化

这是训练营第一周，很想总结一下有关算法复杂度分析和解决问题时的渐进式优化思路。一直都认为思路和方法是很重要的，所以要更好的掌握复杂度分析和渐进式优化。

我们需要知道为什么要复杂度分析，因为在程序未写出来之前是没有办法运行的，如果都到了程序写出来之后才能验证快不快，着实浪费时间和精力，所以在编程之前就粗略估计时空开销，这个过程就是复杂度分析。

复杂度分析的一些关键点：

- 复杂度分析的一般规则，也是一些简单的规则

1. 一般有限次操作的时间复杂度是 O(1), 有限次操作是指随着数据量的增加，操作次数不增加
2. 一般单次 for 循环的时间复杂度是 O(n), 表示和数据量的线性关系
3. 一般嵌套 m 次 for 循环的时间复杂度是 O(n^m)
4. 一般树的高度的时间复杂度是 O(logn)
5. 一般对于二叉查找树的二分查找时间复杂度是 O(logn)
6. 一般对于一个堆，弹出堆顶元素后，重新堆化的时间复杂度是 O(logn)

- 复杂度分析的组合方式

1. 嵌套的多层循环，时间复杂度和嵌套层数m有关系，一般是 O(n^m), 如冒泡排序O(n^2)
2. 有时算法是分多步完成的，例如 Topk 问题可以分解为：新建k个元素的堆；然后遍历 n - k 个元素插入堆中；调整堆；时间复杂度的组合就是：O(k) + O(n-k) * O(logk) = O(n*logk)。需要根据具体算法分清楚是加还是乘

```
// 表示成公式
如果 T1(N) = O(f(n)), T2(N) = O(g(n)), 那么
a. T1(N) + T2(N) = max(O(f(n)), O(g(n)))
b. T1(N) * T2(N) = O(f(n)*g(n))

如果 T(N) 是一个k次多项式，则 T(N) = O(N^k)
```

- 复杂度分析的递归求解

递归的分析方法相对来讲要复杂一些，需要先找出终止条件、子问题和递归式，然后可以使用一些数学分析方法来求解。

```
// 二分查找的例子
int binarySearch(int[] arr, int low, int hight, int target) {
    if (low > hight) return -1;
    int mid = low + (hight - low) >> 1;
    if (arr[mid] == target) return mid;
    if (arr[mid] > target) {
        return binarySearch(arr, low, mid - 1, target);
    } else {
        return binarySearch(arr, mid + 1, hight, target);
    }
}

// 下面是分析
T(n) = O(f(n)), f(n) 用来表示数据量是 n 时的复杂度公式（或者叫操作次数等），那么 f(1) = 1 (可以理解为 1 是常量级的)；
从代码可知，每次递归查找会将数据量减半，所以有 f(n) = f(n/2) + 1, 依次递推则有：
f(n) = f(n/2) + 1
f(n/2) = f(n/4) + 1
...
f(n/2^(m-1)) = f(n/2^m) + 1
左右分别相加得到，f(n) = f(n/2^m) + m (总共有m次递归调用)
当 n/2^m = 1 时，f(n/2^m) = 1, 达到常量级，可求出解；所以 m = logn
f(n) = 1 + logn, 所以 T(n) = O(logn)，二分查找的时间复杂度是 O(logn)
```

递归求解需要根据算法进行一步步的分析，得出递推式，进行详细推导。此外，还可以使用主定理来分析递归。

- 均摊分析

摊还分析，又叫平摊分析，是一种特殊情况下的复杂度分析方法。暂时请参考[这里](https://time.geekbang.org/column/article/40447)

- 例子：归并排序的复杂度分析

```
// 归并排序复杂度分析
int mergeSort(int[] arr, int low, int high) {
    if (low >= high) return;
    int mid = low + (hight - low) >> 1;

    mergeSort(arr, low, mid)
    mergeSort(arr, mid + 1, high)
    merge(arr, low, mid, high)
}
// 合并函数, 将两个有序数组合并为一个有序数组
void merge(A[p...r], A[p...q], A[q+1...r]) {
  var i := p，j := q+1，k := 0 // 初始化变量 i, j, k
  var tmp := new array[0...r-p] // 申请一个大小跟 A[p...r] 一样的临时数组
  while i<=q AND j<=r do {
    if A[i] <= A[j] {
      tmp[k++] = A[i++] // i++ 等于 i:=i+1
    } else {
      tmp[k++] = A[j++]
    }
  }
  
  // 判断哪个子数组中有剩余的数据
  var start := i，end := q
  if j<=r then start := j, end:=r
  
  // 将剩余的数据拷贝到临时数组 tmp
  while start <= end do {
    tmp[k++] = A[start++]
  }
  
  // 将 tmp 中的数组拷贝回 A[p...r]
  for i:=0 to r-p do {
    A[p+i] = tmp[i]
  }
}

// 下面是分析
1. 当n=1时，mergeSort 计算次数是1， f(1) = 1
2. 归并排序，当n较大时，第一步递归左半部分，第二步递归右半部分，第三步merge两个有序数组为1个, merge 的时间复杂度是 O(n)
可知 f(n) = f(n/2) + f(n/2) + n 
 = 2f(n/2) + n 
 = 2(2f(n/4) + n/2) + n = 4f(n/4) + 2n
 = ...
 = 2^k * f(n/2^k) + k * n

 当 n/2^k = 1 时，可求解，所以 k = logn, 带入 f(n) = n + logn * n
 所以归并排序的时间复杂度是 O(nlogn)
```

复杂度分析需要多多练习，需要掌握复杂度分析的一般规则、组合规则、递归求解规则等，其中递归求解是比较复杂的分析方法。

参考：
1. [十分钟搞定时间复杂度（算法的时间复杂度）](https://www.jianshu.com/p/f4cca5ce055a)
2. [拜托，面试别再问我时间复杂度了](https://www.itcodemonkey.com/article/10271.html)
3. [复杂度分析](https://amberwest.github.io/2018/09/27/%E5%A4%8D%E6%9D%82%E5%BA%A6%E5%88%86%E6%9E%90/)

10.24 补充 关于斐波那契递归实现的复杂度分析

分析一下使用朴素递归的方式的时间复杂度，代码如下
```
func climbStairs(n int) int {
    if n <= 2 { return n }
    return climbStairs(n - 1) + climbStairs(n - 2)
}

// 简单的分析方法
// 可以将递归调用转成一个调用树，树的深度是n，每个非叶子有两个节点，而树中的每个节点都需要计算一次，叶子节点的上限是 2^n,
// 所以时间复杂度可以粗略的得出为 O(2^n), 这个是不精确的一个上限

// 更加严谨的分析方法
// 从代码实现可知，T(n) = O(1) + T(n-1) + T(n-2), 其中O(1)是加法操作，为常量级别
// 斐波那契数列是可以求出通项的，使用数学的方式进行分析，这个对数学有一定要求，详细看 参考1
```

朴素递归可以使用尾递归进行优化


参考：
1. [几种斐波那契数列项算法的复杂度分析](https://blog.mottomo.moe/categories/Tech/Coding/zh/2019-04-07-Fibonacci-Implementations/)

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

`PriorityQueue` 是使用数组存储的，那么容量是一个很关键的问题，分析可知，`PriorityQueue` 通过 `grow` 函数进行扩容，策略是：当前容量小于64时，每次翻倍；当前容量大于64时，每次增长50%；扩容的过程是：计算新的容量 -> 申请新的数组 -> copy到新数组。

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
