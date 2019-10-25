# NOTE

## 关键部分笔记

#### 哈希表、映射、集合

- Java 中HashMap、Set的实现分析
- 讲解题目：242，49
1. https://leetcode-cn.com/problems/valid-anagram/description/  (done)
2. https://leetcode-cn.com/problems/group-anagrams/ (done)
3. https://leetcode-cn.com/problems/two-sum/description/ (done)
  
#### 树、二叉树、二叉搜索树

- 树的定义和基本特性
- 应用广泛的二叉树
- 树的遍历
- 二叉搜索树及操作，查找、插入、删除
- 树的面试题解法一般都是递归，为什么？
- 讲解题目：树的遍历
1. https://leetcode-cn.com/problems/binary-tree-inorder-traversal/  (done)
2. https://leetcode-cn.com/problems/binary-tree-preorder-traversal/ (done)
3. https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/ (done)
4. https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/  (done)
5. https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/ (done)

#### 范型递归、递归树

- 递归
1. 递归的本质是循环，在汇编层是没有循环的，只能通过不停调用重复代码来实现循环的效果
2. 递归是重复性的进行，在现实中也会有体现
3. 可以借鉴电影盗梦空间来理解递归（向下进入到不同层，向上又回到原来的一层；返回上一层可以携带返回值，来改变上一层的状态；每一层都是新的拷贝，每一层可以修改状态，然后返回）

归去来兮，剥洋葱的感觉

- 递归代码模版：https://shimo.im/docs/DjqqGCT3xqDYwPyY/read
1. 先写递归终止条件
2. 当前层的逻辑处理
3. 陷入到下一层
4. 清理当前层

- 递归的难点和误区
1. 不要人肉递归（最大误区）
2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
3. 数学归纳法思维

- 讲解题目：70，22
1. https://leetcode-cn.com/problems/climbing-stairs/  (done)
2. https://leetcode-cn.com/problems/generate-parentheses/
3. https://leetcode-cn.com/problems/invert-binary-tree/description/  (done)
4. https://leetcode-cn.com/problems/validate-binary-search-tree
5. https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
6. https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
7. https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
8. https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
9. https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
10. https://leetcode-cn.com/problems/combinations/
11. https://leetcode-cn.com/problems/permutations/
12. https://leetcode-cn.com/problems/permutations-ii/

#### 分治、回溯

- 一种特殊的递归
- 分治：将一个大问题分解为多个子问题，然后merge子问题

- 分治模版
1. 终止条件
2. 准备数据，拆分子问题
3. 处理子问题，处理、合并生成最终结果
4. 清理状态

- 讲解题目：
1. https://leetcode-cn.com/problems/powx-n/
2. https://leetcode-cn.com/problems/subsets/
3. https://leetcode-cn.com/problems/majority-element/description/ （简单、但是高频）
4. https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
5. https://leetcode-cn.com/problems/n-queens/

---

## 总结正文

### 【716-Week 02】

// todo 写一篇关于树的总结，以持续优化的思想

#### HashMap 总结

Java 中的 `HashMap` 是散列表的实现，有必要 review 一下一个工业级的散列表实现要考量的 Key Point:

1. 散列表的三个基本元素：key、散列函数、value, key 通过散列函数计算得到 value 存储的位置
2. 设计散列函数
3. 控制散列表的装载因子，初始大小和动态扩容策略
4. 有效解决散列冲突
5. 对一个工业级散列表的实现要遵守几点：首先支持快速查询、删除、插入等操作；其次，内存占用要合理，不要过多浪费内存；最后，性能稳定，极端情况下，散列表的性能也不能退化到无法接受

总之，我们在结合使用场景和具体业务数据考虑设计散列表实现时，要抓住上面的 key point；接下来，从这几个点来验证一下 Java 中的 `HashMap` 实现

- `HashMap` 的散列函数设计

散列函数的设计要点是：首先，不能复杂，太复杂的散列函数也会影响程序性能；其次，散列函数计算后得出的值要尽可能随机和均匀。

```java
static final int hash(Object key) {
    int h;
    // 先取对象 key 的 hashCode
    // 最后返回 h ^ (h >>> 16)，将hashCode的高16位移到低16位，然后做异或，保证了很好的随机性，位运算本身是很高效的
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}

// 在插入元素时计算key要插入的元素位置
// 通过 (n - 1) & hash 来计算位置，n 代表数组的 capacity，hash & (n - 1) 相当于 hash % n, 也就是除留余数法
if ((p = tab[i = (n - 1) & hash]) == null)
    tab[i] = newNode(hash, key, value, null);


// Object 的 hashCode 返回的是 int
public native int hashCode();
```

可见，HashMap 的散列函数设计分为两步，先对 key 求hash值，然后再根据 HashMap 的节点(本质是一个数组)容量来计算数组中的位置；求 key hash值的方式简单高效，位移后异或随机且高效，所以总体非常符合散列函数的设计要求。（ 注：A % B = A & (B - 1) ）

- 控制散列表的装载因子，初始大小和动态扩容策略

HashMap 的实现底层用了数组，数组有容量范围的；装载因子表示了空槽位的多少，计算方式为：`已经使用的槽位数/散列表的总长度`。
从装载因子我们可以得出一些结论：当装载因子越大，散列表里的元素就越多，空闲位置就越少，散列冲突的概率就越大，会导致整个插入和查找的时间变长，最糟糕的情况会退化成链表的查找和插入时间复杂度，这是不可忍受的。这个时候就需要进行动态扩容策略来调整装载因子，让他不会太大；

但是当装载因子太小时，会导致浪费内存空间，所以保证装载因子在一个合理的值是比较重要的。

```java
/**
 * The default initial capacity - MUST be a power of two.
 */
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
// 初始容量大小为16，如果没指定的话

/**
 * The load factor used when none specified in constructor.
 */
static final float DEFAULT_LOAD_FACTOR = 0.75f;
// 装载因子默认是 0.75

// 从 Node 的定义来看，HashMap 采用的是链表法存储元素
static class Node<K,V> implements Map.Entry<K,V> {
    final int hash;
    final K key;
    V value;
    // 指向下一个和当前元素有相同位置索引的元素
    Node<K,V> next;
    // ... 省略了部分代码
}
final Node<K,V>[] resize() {
    // .... 省略了部分代码
    threshold = newThr;
    // 新的容量的计算策略是如果初始为0，就用默认的16大小，如果大于16小于2^30，每次扩容就double size
    // 这里使用新的容量申请了一个新的数组
    @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
    table = newTab;
    // 老数组如果有元素的话，需要做copy且重新计算索引位置
    if (oldTab != null) {
        // 遍历老数组
        for (int j = 0; j < oldCap; ++j) {
            Node<K,V> e;
            // 不等于null表示元素是一个存在的合法元素，需要copy
            if ((e = oldTab[j]) != null) {
                oldTab[j] = null;
                // 如果当前元素没有后继元素，计算新的位置
                if (e.next == null)
                    newTab[e.hash & (newCap - 1)] = e;
                else if (e instanceof TreeNode) 
                    // 如果是树节点类型，这里是红黑树，将树中的节点做分裂，因为容量变化，所以节点计算出的位置索引也会发生变化
                    ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                else { // preserve order
                    Node<K,V> loHead = null, loTail = null;
                    Node<K,V> hiHead = null, hiTail = null;
                    Node<K,V> next;
                    // 查找链表中的每一个元素，来计算他们新的位置
                    do {
                        next = e.next;
                        if ((e.hash & oldCap) == 0) {
                            if (loTail == null)
                                loHead = e;
                            else
                                loTail.next = e;
                            loTail = e;
                        }
                        else {
                            if (hiTail == null)
                                hiHead = e;
                            else
                                hiTail.next = e;
                            hiTail = e;
                        }
                    } while ((e = next) != null);
                    if (loTail != null) {
                        loTail.next = null;
                        // 使用原来的位置
                        newTab[j] = loHead;
                    }
                    if (hiTail != null) {
                        hiTail.next = null;
                        // 使用+oldCap的位置
                        newTab[j + oldCap] = hiHead;
                    }
                    // 这里的位置计算有个数学上的技巧，扩容后新元素的位置要么在原来的位置，要么在原来的值+oldCap的位置
                }
            }
        }
    }
}    

// 启动扩容的地方，当元素个数大于阈值的时候会触发
// 其中 threshold = Capacity * 装载因子，一切就联系起来了
if (++size > threshold)
    resize();
```

从源代码分析可见，工业级散列表的实现还是比较复杂的，但是原理和思想才是最重要的：
1. 首先分配一个初始容量，当然也可以通过构造函数来指定，固定一个装载因子，计算出触发扩容的阈值
2. 在每次插入时，判断元素数量是否到达阈值，到了就触发扩容策略
3. 扩容策略是在原来的基础上double，如果没有指定或者为0就使用默认初始容量16
4. 扩容的过程就是新申请一个更大容量（原来的2倍）的数组，将老数据copy过去，重点是位置索引的重新计算，然后是否老数组
5. HashMap 的实现使用了链表法，后面会分析到，还会涉及到红黑树的分裂，这个过程就比较复杂了

- 有效解决散列冲突

无论设计的多么好的散列函数，都会发生散列冲突，当冲突的时候就必须解决散列冲突，常见的方法有：开放寻址法和链表法。

HashMap 采用的方式是链表法

```java
/**
 * The table, initialized on first use, and resized as
 * necessary. When allocated, length is always a power of two.
 * (We also tolerate length zero in some operations to allow
 * bootstrapping mechanics that are currently not needed.)
 */
// 使用数组来存放 Node
transient Node<K,V>[] table;

// 从 Node 的定义来看，HashMap 采用的是链表法存储元素
static class Node<K,V> implements Map.Entry<K,V> {
    final int hash;
    final K key;  // 存放Key
    V value;  // 存放 Value
    // 指向下一个和当前元素有相同位置索引的元素
    Node<K,V> next;
    // ... 省略了部分代码
}
```

盗用一张图，就是这样的
![](https://img-blog.csdn.net/20170317181650025?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvanVzdGxvdmV5b3Vf/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

但是，当某个位置的链表过长时，会造成查找和插入的时间复杂度增加，HashMap 在这里做了一个优化，当链表长度超过某个值时，就将链表转换成红黑树，当红黑树的元素个数小于某个值时，会转成链表.

```java
/**
 * The bin count threshold for using a tree rather than list for a
 * bin.  Bins are converted to trees when adding an element to a
 * bin with at least this many nodes. The value must be greater
 * than 2 and should be at least 8 to mesh with assumptions in
 * tree removal about conversion back to plain bins upon
 * shrinkage.
 */
static final int TREEIFY_THRESHOLD = 8;

/**
 * The bin count threshold for untreeifying a (split) bin during a
 * resize operation. Should be less than TREEIFY_THRESHOLD, and at
 * most 6 to mesh with shrinkage detection under removal.
 */
static final int UNTREEIFY_THRESHOLD = 6;
```

所以在插入、查找、删除等操作时，HashMap 可以提供比较高的效率，基本都是 O(1) 的时间复杂度。这得以于 HashMap 在各方面的优化：

1. 对散列函数的优化，使用自定义的hash函数重新计算hash，计算hash的时候使用位操作，效率更高
2. 对扩容策略的优化，扩容带来散列冲突概率的降低
3. 对散列冲突的优化，当链表性能下降时，转成红黑树，红黑树加速了查找、插入的速度
4. etc.

还可以参考：

- [Map 综述（一）：彻头彻尾理解 HashMap](https://blog.csdn.net/justloveyou_/article/details/62893086)
- [Map 综述（二）：彻头彻尾理解 LinkedHashMap](https://blog.csdn.net/justloveyou_/article/details/71713781)
