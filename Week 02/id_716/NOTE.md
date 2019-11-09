# NOTE

## 关键部分笔记

### 哈希表、映射、集合

- Java 中HashMap、Set的实现分析
- 讲解题目：242，49
  
1. <https://leetcode-cn.com/problems/valid-anagram/description/>  (done)
2. <https://leetcode-cn.com/problems/group-anagrams/> (done)
3. <https://leetcode-cn.com/problems/two-sum/description/> (done)
  
#### 树、二叉树、二叉搜索树

- 树的定义和基本特性
- 应用广泛的二叉树
- 树的遍历
- 二叉搜索树及操作，查找、插入、删除
- 树的面试题解法一般都是递归，为什么？
- 讲解题目：树的遍历
  
1. <https://leetcode-cn.com/problems/binary-tree-inorder-traversal/>  (done)
2. <https://leetcode-cn.com/problems/binary-tree-preorder-traversal/> (done)
3. <https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/> (done)
4. <https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/>  (done)
5. <https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/> (done)

### 范型递归、递归树

- 递归
  
1. 递归的本质是循环，在汇编层是没有循环的，只能通过不停调用重复代码来实现循环的效果
2. 递归是重复性的进行，在现实中也会有体现
3. 可以借鉴电影盗梦空间来理解递归（向下进入到不同层，向上又回到原来的一层；返回上一层可以携带返回值，来改变上一层的状态；每一层都是新的拷贝，每一层可以修改状态，然后返回）

归去来兮，剥洋葱的感觉

- 递归代码模版：<https://shimo.im/docs/DjqqGCT3xqDYwPyY/read>
  
1. 先写递归终止条件
2. 当前层的逻辑处理
3. 陷入到下一层
4. 清理当前层

- 递归的难点和误区
  
1. 不要人肉递归（最大误区）
2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
3. 数学归纳法思维

- 讲解题目：70，22
  
1. <https://leetcode-cn.com/problems/climbing-stairs/>  (done)
2. <https://leetcode-cn.com/problems/generate-parentheses/>
3. <https://leetcode-cn.com/problems/invert-binary-tree/description/>  (done)
4. <https://leetcode-cn.com/problems/validate-binary-search-tree>  (done)
5. <https://leetcode-cn.com/problems/maximum-depth-of-binary-tree>
6. <https://leetcode-cn.com/problems/minimum-depth-of-binary-tree>
7. <https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/>
8. <https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/>
9. <https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal>
10. <https://leetcode-cn.com/problems/combinations/>
11. <https://leetcode-cn.com/problems/permutations/>
12. <https://leetcode-cn.com/problems/permutations-ii/>

### 分治、回溯

- 一种特殊的递归
- 分治：将一个大问题分解为多个子问题，然后merge子问题

- 分治模版
  
1. 终止条件  terminator
2. 准备数据，拆分子问题  process current logic, split your big problem
3. 处理子问题，处理、合并生成最终结果 drill down -> sub problems & merge result
4. 清理状态 revert state

- 讲解题目
  
1. <https://leetcode-cn.com/problems/powx-n/>  (done)
2. <https://leetcode-cn.com/problems/subsets/> (done)
3. <https://leetcode-cn.com/problems/majority-element/description/> （简单、但是高频） (done)
4. <https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/>
5. <https://leetcode-cn.com/problems/n-queens/>

---

## 总结正文

### 【716-Week 02】由一般化到特殊化演变的树

这是训练营的第二周，也持续的做了几十道算法题，每道题自己都竭尽全力的去找尽可能多的解法，且每个解法都实现出来。此前一直对树这个数据结构理解的不是很彻底很到位，以及围绕树相关的算法也感觉很飘忽很神秘，所以本周就萌生了全方位总结树这个数据结构以及和它相关的算法。

为什么需要树？当在面临大量的输入数据时，线性表的访问时间就变的很慢了，有没有一种数据结构可以加速访问呢，树就是其中一种，树可以将大部分的操作都优化到 O(logn) 的时间复杂度，可以大大提升效率；此外，我们在日常生活中无时无刻不在使用树，比如想中午吃什么的时候，我们不自觉的构建了一颗决策树，操作系统的文件系统等；（在这篇总结中，不再罗列概念）

#### 树的数学性质

有时候了解更多关于树的数学性质有助于解决很多问题，所有的数学性质是直接可以使用的

1. 高度为 `h` 的二叉树至多有 `2^h` 个叶子结点
2. 高度为 h≥0 的二叉树至少有 `h+1` 个结点
3. 高度不超过 h(≥0) 的二叉树至多有 `2^(h+1)-1` 个结点
4. 含有 n≥1 个结点的二叉树的高度至多为 `n-1`
5. 含有 n≥1 个结点的二叉树的高度至少为 `logn`，因此其高度为 `Ω(logn)`
6. 高度为 h 的满二叉树，共有 `2^(h+1)-1` 个结点
7. 满二叉树共有 `2^h` 个叶子
8. 满二叉树共有 `2^h-1` 个内结点，内结点个数比叶子少1
9. 完全二叉树第 h 层的从左到右第 k 个结点的编号为 `2^h + k - 1`
10. 完全二叉树叶子个数或者和内结点个数相等或者多1
11. 完全二叉树通过本结点的编号可以快速得到父结点、左右孩子的编号；编号为i的父节点为 `i/2`, 左子节点为 `2*i`, 右子节点为 `2*i + 1`（这个性质在堆中得到了很好的应用）
12. etc.

#### 为什么会有那么多特殊化的树

这是本次总结想要好好分析的。

树的一般化定义是：一棵树是一些节点的集合。这个集合可以是空；若非空，一个树由根节点以及0个或多个非空子树组成，每一棵子树都和根有一条有向边所连接；一颗树是N个节点和N-1条边的集合。从树的定义中，我们可以推论出很多树的数学性质，例如上面描述的。

树的演化过程，其实是从一般到特殊化的过程，在演化中出现各种特殊的树，来解决不同种类的问题。但是一颗一般化的树，在一些特殊的场景下，并不能为我们解决很多问题

- 从二叉树开始：在树中如何利用二分查找的思想

二叉树是一颗每个节点最多有两个孩子的树，分别是左孩子和右孩子。可以看出，我们在树的基础上做了限制，二叉树为我们提供了每次二分的可能，也简化了树以及各种操作的实现。在使用这颗二叉树的时候，我们可以尽可能的去构造这颗树，但是怎么解决快速查找的问题，尤其是在有大量数据存在时？如果查找的时间复杂度还不如链表，那就没有意义了。

我们知道在一个排好序的数组中进行二分查找的时间复杂度是 O(logn), 是非常高效的（40亿量级的数据，只需要32次左右的查找）；所以将二分查找的思想应用在二叉树中，就是一颗二叉查找树，它是这么一棵树：在树中的任意一个节点，其左子树中的每个节点，都要小于这个节点的值，其右子树的每个节点，都要大于这个节点的值。可见，二叉查找树在二叉树的基础上又做了限制，更加特殊化了。

为什么二叉查找树的查找效率高？我们首先来分析一颗完全二叉查找树，这是一种比较理想的状态，因为树的高度是 logn, 也是二叉查找树所有形态中高度最小的树；我们试着来分析一下：

```text
// 对于一颗包含 n 个节点完全二叉树
// 1. 除了最后一层外，每一层的节点是上一层节点个数的2倍; 一般的，第一层是1个节点，第二层是2个节点，第三层是4个节点，以此类推
// 2. 最后一层节点的个数在 1 ~ 2^(L-1), 其中 L 表示最大层数
// 综上可知，n 满足
n <= 1 + 2 + 4 + ... + 2^(L-2) + 2^(L-1)
n >= 1 + 2 + 4 + ... + 2^(L-2) + 1

=> log(n+1) <= L <= log(n) + 1
```

可知，L 的最大值是 log(n) + 1, 高度h最大是 log(n); 所以在查找某个元素时，最大查找次数是 log(n), 故而时间复杂度是 O(logn), 很高效；同理，插入、删除操作时间复杂度也是 O(logn)

上面我们说了是一种理想状态，因为数据特点的不同，我们构造出来的二叉查找树可能会退化成链表结构，比如每次都一直插入左子树或一直插入右子树，这个时候查找时间复杂度就是 O(n), 这是不可接受的。那怎么办呢？

问题出在了构建二叉查找树的时候，在插入和删除的时候会影响二叉查找树的形态，所以我们需要控制动态构建的这个二叉查找树，让他保持平衡，以便于更加接近一颗完全二叉查找树，这样就是一个比较好的状态。为了解决二叉查找树的时间复杂度退化问题，保持平衡，我们可以动态的维护一颗平衡二叉查找树（AVL），这个就是我们想要的。

平衡二叉查找树是一颗任何节点的左右子树高度相差不超过1的二叉查找树，可见AVL是对二叉查找树的进一步限制。但是AVL的实现还是比较复杂的，在维护平衡时，涉及到了多种情况和各种旋转操作。

AVL的实现有很多，如红黑树，伸展树，AA树，treap 树等，这些树的工程实现普遍都很复杂，每一个都值得写一篇长长的总结。

对树来说，其实落在工程中的实现是像红黑树这种性能表现比较好的数据结构，通过一步步的分析，我们也知道了为什么不在工程中直接使用一般化的二叉查找树，而是使用AVL。无非是分析各种情况下，给出的这个数据结构和算法的设计，在最好和最坏的情况下有多大差别，我们是否能容忍最坏情况的发生，这个需要根据工程中的实际场景来权衡。数据结构和算法没有哪一个是完美的，只有最合适的，我们要分析实际场景。

- 一个特殊化的完全二叉树：堆

完全二叉树是一个平衡树，所以高度最大是 O(logn)，所以堆具有这个性质；此外，堆规定了每个节点的值必须大于等于（小于等于）其子树中每个节点的值；可见，堆是一颗受限的完全二叉树。

堆适合使用数组来存储。更加详细的分析参考：[堆和堆排序](https://time.geekbang.org/column/article/69913)

- B+Tree：由二叉查找树演变而来的多叉索引树

有这样一个实际应用，我们需要一个数据库，要将数据持久化存储在磁盘上，并且支持：

1. 根据某个值快速查找数据
2. 根据某个区间值来查找数据
3. 希望能够按顺序输出某个区间内的数据，升序和降序

我们可以构建这样一颗平衡二叉查找树，叶子节点存储数据，非叶子节点只存储索引，这样索引和数据就可以分开存储了；但是二叉查找树可以快速查找数据，但是无法进行区间查找和按序输出；我们可以将叶子节点用双向链表串联起来，这样就可以支持区间查找和顺序输出了。

存在另外一个问题，因为数据库有存储大量数据的需求，比如可能是上亿条数据，如果把索引节点都放在内存中是不现实的，我们希望索引不占用太多的内存空间，那只能把一部分索引放在内存，一部分放在磁盘，等需要的时候再把磁盘的索引载入内存（时间换空间的思路，牺牲了一定的时间）磁盘的访问速度远低于内存访问速度；我们知道平衡二叉查找树的查找是 O(logn),采用这种方式后，会带来一个问题，就是需要多次访问磁盘来加载索引文件，会严重降低查找的速度，一次磁盘IO需要10ms左右，对于一个有上亿数据量的数据查找，需要大概20次左右的磁盘IO，就是200ms，所以真的是很慢；

那如何解决平衡二叉查找树带来的磁盘IO过多的问题呢？答案是降低树的高度，树的高度减少了，磁盘需要IO的次数就对应减少了，同时还能更好的利用内存的局部性原理，增加树的度可以减少树的高度，比如每个树的度最大是1000时；这样就形成了一颗m叉的平衡查找树。这正是B+树的核心，也是众多存储引擎使用的数据结构。

当然，B+树在存储引擎的实现要复杂很多，要考虑的点也有很多，专门的探讨放在后续的总结中。

通过分析各种类型的树及其操作，很清楚的知道了他们的由来、特性、适用的场景以及它能解决的问题，而这个也是我们学习数据结构和算法最核心的地方；在理解了这些的基础上，然后用代码去实现出来并不断优化工程代码。

---

// todo 位运算的常用操作 <https://www.zhihu.com/question/38206659>

### HashMap 总结

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
![hashmap](https://img-blog.csdn.net/20170317181650025?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvanVzdGxvdmV5b3Vf/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

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
