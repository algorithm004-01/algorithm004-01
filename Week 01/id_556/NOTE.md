## Week1-学习总结

### 1. 用 add first 或 add last 这套新的 API 改写 Deque 的代码

```java
Deque<String> deque = new LinkedList<String>();
deque.addFirst("a");
// deque.offerFirst("a");
deque.addFirst("b");
deque.addFirst("c");
System.out.println(deque);

String str = deque.peekFirst();
System.out.println(str);
System.out.println(deque);

while (deque.size() > 0) {
    System.out.println(deque.removeFirst());
    // System.out.println(deque.pollFirst());
}
System.out.println(deque);
```

### 2. 分析 Queue 和 Priority Queue 的源码 （JDK8）

```java
package java.util;
// 队列是一个FIFO的数据结构, Java中的实现继承了Collection
/* BlockingQueue接口：不是立即从队列中添加或者删除元素，线程执行操作阻塞，直到有空间或者元素可用，实现了阻塞接口的类如下：
 * ArrayBlockingQueue ：一个由数组支持的有界队列。
 * LinkedBlockingQueue ：一个由链接节点支持的可选有界队列。
 * PriorityBlockingQueue ：一个由优先级堆支持的无界优先级队列。
 */　
// LinkedList实现了java.util.Queue接口和java.util.AbstractQueue接口, 没有实现阻塞接口，PriorityQueue 和 ConcurrentLinkedQueue也不阻塞
/* <p>This interface is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @see java.util.Collection
 * @see LinkedList
 * @see PriorityQueue
 * @see java.util.concurrent.LinkedBlockingQueue
 * @see java.util.concurrent.BlockingQueue
 * @see java.util.concurrent.ArrayBlockingQueue
 * @see java.util.concurrent.LinkedBlockingQueue
 * @see java.util.concurrent.PriorityBlockingQueue
 * @since 1.5
 * @author Doug Lea
 * @param <E> the type of elements held in this collection
 */
public interface Queue<E> extends Collection<E> {
    // 增加一个元索。如果队列已满，则抛出一个IllegalStateException异常
    boolean add(E e);
    // 添加一个元素并返回true。如果队列已满，则返回false
    boolean offer(E e);
    // 移除并返回队列头部的元素。如果队列为空，则抛出一个NoSuchElementException异常
    E remove();
    // 移除并返问队列头部的元素。如果队列为空，则返回null
    E poll();
    // 返回队列头部的元素。如果队列为空，则抛出一个NoSuchElementException异常
    E element();
    // 返回队列头部的元素。如果队列为空，则返回null
    E peek();
}
```

```java
package java.util;
// 继承AbstractQueue，而AbstractQueue继承AbstractCollection，实现Queue接口
public class PriorityQueue<E> extends AbstractQueue<E> {
	// 内部使用堆实现，每次取堆顶元素
    transient Object[] queue; // non-private to simplify nested class access
    
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    // 主要构造函数：initialCapacity 为初始堆大小，一般来说，为了避免扩容，或者空间浪费，要选择合适的值，默认值为 DEFAULT_INITIAL_CAPACITY = 11
    public PriorityQueue(int initialCapacity, Comparator<? super E> comparator){
        ...
    }
    // 添加元素
    public boolean add(E e) {
        return offer(e);
    }
    // 调用的是offer
    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        // 主要是记录修改次数，实际上是为了防止在遍历的时候更改数据造成不一致，会抛出ConcurrentModificationException 异常
        modCount++;
        int i = size;
        // 检查是否需要扩容，queue就是真实数据
        if (i >= queue.length)
            grow(i + 1);
        size = i + 1;
        if (i == 0)
            queue[0] = e;
        else
        // 使用经典的siftUp上移最后添加的元素，保证堆还是有序的
        siftUp(i, e);
        return true;
    }
	// 删除元素
	public E poll() {
        if (size == 0)
            return null;
        int s = --size;
        modCount++;
        E result = (E) queue[0];
        E x = (E) queue[s];
        queue[s] = null;
        if (s != 0)
    		// 使用 siftDown，首先将最后一个元素移到堆顶，再调整堆
            siftDown(0, x);
        return result;
    }
    // 获取元素
    // 也可以使用父类AbstractQueue的element()方法
    public E peek() {
    	// 直接返回数组的第一个值
        return (size == 0) ? null : (E) queue[0];
    }
}
```

### 3. 学习笔记

#### Week1-4-数组，链表，跳表

- 数组：插入/删除平均复杂度 O(n)，查找O(1) （随机存取）。对Java ArrayList进行插入操作，涉及arraycopy，效率偏低
- 单链表：`node --> next`，prepend/append复杂度O(1)，插入/删除复杂度 O(1) （指针修改的2次操作），查找O(n)。
- 双向链表 (Java中默认的)（应用于实现LRU cache）：`prev <-- node --> next`，插入/删除复杂度O(1)，查找复杂度O(n)
- 循环链表：`tail-->head`
- 跳表（skip list，应用于Redis）：为克服链表访问的复杂度O(n)，采用升维+空间换时间策略进行加速：加索引：一维-->二维
  - 一级索引：指向next+1，跨越2个元素
  - 二级索引：跨越4个元素
  - 多级索引：log2(n)级索引
  - 最终达到增加/删除log(n)的时间复杂度，但维护成本较高，因为要更新索引，空间复杂度为O(n)，但比同为O(n)的简单链表要大

> 很多算法靠自己想出来是不可能的，需要去学习前人的总结，所以没有什么不好意思的。

#### Week1-5-栈，队列

- Stack: FILO，增加删除O(1)，查询（需要遍历）O(n)
- Queue: FIFO，增加删除O(1)，查询O(n)
- Deque: Double-end queue, 增加删除O(1)，查询O(n)
- Priority Queue：插入O(1)，取出O(logn)，按优先级取出，为了保持有序性，可以用heap/bst/treap实现

> 每种数据结构在不同编程语言都可能由不同底层来实现，甚至由多个其他数据结构实现，比如用两个栈实现队列

> 一维数组的坐标变换，i/j嵌套遍历，双指针夹逼，枚举中间找左右边界等套路代码，需要非常熟练