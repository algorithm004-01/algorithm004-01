# 学习总结
## 本周学习收获
> 首先说一下感受，本周感觉到吃(wu)力(li)的地方:一开始从「括号生成」问题着手递归代码的实践，并没有任何理解上的问题。但是当问题上升到组合、子集这些分治、回溯的算法思想时就跟不上了。看到讨论群别人娴熟的基本功，我知道一定要跨过这一个区分API接线侠和「软件工程师」的分水岭。加油~~把这一部分的思想捋顺畅，再把习题全部拿下！
### 知识点
- 哈希表
    - 底层使用数组存储
    - 哈希冲突处理方法
        - 拉链法（Java中HashMap使用的方式，在冲突剧烈的情况会转换为红黑树，实现O(logn)的查找速度
        - 开放地址法（Java中ThreadLocal使用的方式，使用场景倾向于哈希冲突较少的场景）
- 集合，底层是一个Map的存储，使用一个全局的指针变量来占位Map中的value。
- 二叉树
    - 二叉搜索树
        - 遍历方式
            - 前序遍历（前根遍历的叫法有助于记忆，即先遍历根节点）
            - 中序遍历（同理：中根遍历），遍历节点呈现有序状态
            - 后序遍历（同理：后根遍历）
        - 局限性，在最差的情况可能会退化为链表结构，因此有了AVL树、红黑树这些更高级的结构来保证时间复杂度的优化
- 算法思想
    - 递归
    - 分治
    - 回溯
以上算法思想的本质，都是寻找重复性。将大问题拆解为子问题进行解决。涉及到子结果如何合并、大问题如何拆分这些知识只能通过大量的练习来获得的「隐性知识」。很多我没能靠自己做出来，还要再练习练习~~

## HashMap的总结
1. HashMap使用数组来作为底层的存储
2. 为了完成位与运算来计算取模、在扩容时避免重新hash，底层的数组长度为2 ^ n，由函数tableSizeFor来保证实例化时传入的长度符合要求
3. hash函数利用hashCode()与位移运算实现
4. 处理哈希冲突时，采用拉链法，并且利用红黑树来优化查找时间复杂度（达到O(logn))
5. 在扩容底层数组时，采用2倍大小扩容。并且避免了重新hash的过程

## 关键函数
### 减少哈希碰撞
#### hash函数
```java
static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}
```

#### 取模方式
```java
(n - 1) & hash
```
- n为HashMap数组长度，且长度为2的n次方。假设数组长度为512，即2 ^ 9；二进制表示形式为1000000000,那么n - 1的二进制表示形式为0111111111
- hash为key经过hash函数计算之后的值，使用公式「(h = key.hashCode()) ^ (h >>> 16)」计算，由于取模方式只会取低位的值，因此通过该公式可以混合原始哈希码的高位和低位，以此来加大低位的随机性（通过移位操作和异或计算）

#### 设定数组长度为2的n次方大小
返回大于输入参数且最近的2的整数次幂数值
```java
static final int tableSizeFor(int cap) {
    // 保证转换后的值大于等于cap，如1000（即十进制的8）1000 - 1 = 0111
    int n = cap - 1;
    n |= n >>> 1;
    n |= n >>> 2;
    n |= n >>> 4;
    n |= n >>> 8;
    n |= n >>> 16;
    // 经过以上的移位操作和或运算之后，原值（即cap）最高位及最高位之后都被置为1，通过 n + 1之后，将得到一个最接近cap的且为2 ^ n的数值
    return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
}
```

### 写入数据
```java
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
    Node<K,V>[] tab; Node<K,V> p; int n, i;
    // 第一次写入数据时，table为null，调用resize()初始化
    if ((tab = table) == null || (n = tab.length) == 0)
        n = (tab = resize()).length;
    // 可以学习这种写法「(p = tab[i = (n - 1) & hash])」，在if判断时，顺便给变量赋值，在之后的分支中可以操作变量
    if ((p = tab[i = (n - 1) & hash]) == null)
        // 该hash桶没有放置数据，说明这个key没有hash冲突，直接放入
        tab[i] = newNode(hash, key, value, null);
    else {
        Node<K,V> e; K k;
        // 当key的hash值相等，且key相等，那么说明需要替换值。这也是为什么类在覆写hashCode方法的情况，同样需要覆写equals方法的原因
        if (p.hash == hash &&
            ((k = p.key) == key || (key != null && key.equals(k))))
            e = p;
        else if (p instanceof TreeNode)
            // 树结构来处理哈希冲突
            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
        else {
            // 链表来处理哈希冲突
            for (int binCount = 0; ; ++binCount) {
                if ((e = p.next) == null) {
                    // 遍历到了链表最后一个节点，直接链接到链表尾部
                    p.next = newNode(hash, key, value, null);
                    // 达到树化（通过树结构来处理hash冲突，实现O(logn)的时间复杂度来查询）
                    // 由于binCount由0开始计数，因此这里使用TREEIFY_THRESHOLD - 1来作为上限
                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                        treeifyBin(tab, hash);
                    // 跳出循环，此时e为null，说明key在之前未放入HashMap中
                    break;
                }
                // 在hash桶链表中找到了put(key, value)中key的位置，跳出循环，此时e不为null，说明此时key已经在之前放入HashMap中
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    break;
                p = e;
            }
        }
        // e不为null时，此前key已经放入HashMap中
        if (e != null) { // existing mapping for key
            V oldValue = e.value;
            // 如果onlyIfAbsent为false、或者之前的value值为null时，才更新value
            if (!onlyIfAbsent || oldValue == null)
                e.value = value;
            // LinkedHashMap的回调函数
            afterNodeAccess(e);
            return oldValue;
        }
    }
    ++modCount;
    // 如果增加key之后，达到扩容上限，那么调用resize()执行扩容
    if (++size > threshold)
        resize();
    // LinkedHashMap的回调函数
    afterNodeInsertion(evict);
    return null;
}
```
### 初始化或者扩容散列表
```java
final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;
    int oldCap = (oldTab == null) ? 0 : oldTab.length;
    int oldThr = threshold;
    int newCap, newThr = 0;
    if (oldCap > 0) {
        // 当容量达到上限时，不进行扩容
        if (oldCap >= MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return oldTab;
        }
        // 双倍扩容，并同时增大下一次容量上限
        else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                 oldCap >= DEFAULT_INITIAL_CAPACITY)
            newThr = oldThr << 1; // double threshold
    }
    // 如果之前的容量上限大于0，则初始化哈希表的大小为「上一次的容量上限」，如果实例化时，通过构造函数指定了哈希表大小时，将使用threshold来初始化哈希表容量
    else if (oldThr > 0) // initial capacity was placed in threshold
        newCap = oldThr;
    // 初始化为默认值，空参构造器实例化时
    else {               // zero initial threshold signifies using defaults
        newCap = DEFAULT_INITIAL_CAPACITY;
        newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
    }
    // 某些特殊情况？
    if (newThr == 0) {
        float ft = (float)newCap * loadFactor;
        newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                  (int)ft : Integer.MAX_VALUE);
    }
    threshold = newThr;
    @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
    table = newTab;
    // 可以看到，以上的逻辑就是为了计算出newCap值的大小（即新哈希表容量）和newThr的大小（即达到扩容的阈值）
    // 计算逻辑：
    // 1. 如果哈希表已经达到容量最大值，则不进行扩容；如果未达到最大值，那么双倍扩容（通过位移计算 oldCapacity << 1来计算)
    // 2. 如果实例化时指定了容量，那么初始化容量为大于且最接近指定的容量大小，且为2 ^ n的值（即tableSizeFor函数转换而来），之所以设置为2 ^ n的容量大小，是为了扩容后，无需对已有的key进行重新hash，原理是？
    // 3. 如果实例化时未指定容量大小，那么使用默认的扩容阈值和默认的容量大小

    // 如果原哈希表中有值，则需要搬移数据到新的哈希表中
    if (oldTab != null) {
        for (int j = 0; j < oldCap; ++j) {
            Node<K,V> e;
            // 遍历hash桶，e = oldTab[j]
            if ((e = oldTab[j]) != null) {
                oldTab[j] = null;
                // 如果旧的hash桶中，存在key且该桶下未出现hash冲突，则直接「取模新hash表长度」计算hash，放入新hash桶中
                if (e.next == null)
                    newTab[e.hash & (newCap - 1)] = e;
                else if (e instanceof TreeNode)
                    // 树化的处理方式
                    ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                else { // preserve order
                    // 如果旧的hash桶中，存在hash冲突，那么遍历链表。根据「e.hash & oldCap」是否等于0来判断扩容后的hash值与新hash桶取模后的值是否相等。以此来将旧链表分为两个链表。
                    // 1. 如果 「e.hash & oldCap == 0」说明e.hash在newCap最高位的值为0，那么「e.hash & (newCap - 1)」之后的值不变，因此在hash桶中的位置不变，仍为j；
                    // 2. 如果 「e.hash & oldCap != 0」说明e.hash在newCap最高位的值为1，那么「e.hash & (newCap - 1)」之后的值为j + oldCap。通过这两步，避免了在处理链表中的元素需要重新构造链表
                    Node<K,V> loHead = null, loTail = null;
                    Node<K,V> hiHead = null, hiTail = null;
                    Node<K,V> next;
                    do {
                        next = e.next;
                        // 1. 在新的hash桶中位置与旧的hash桶中位置一致的元素，构成一个新的链表
                        if ((e.hash & oldCap) == 0) {
                            if (loTail == null)
                                loHead = e;
                            else
                                loTail.next = e;
                            loTail = e;
                        }
                        else {
                        // 2. 在新的hash桶中位置要相对旧的hash桶中位置向右需要偏移oldCap个位置的元素，构成一个新的链表
                            if (hiTail == null)
                                hiHead = e;
                            else
                                hiTail.next = e;
                            hiTail = e;
                        }
                    } while ((e = next) != null);
                    // 分别放到新的hash桶对应的位置上
                    if (loTail != null) {
                        loTail.next = null;
                        newTab[j] = loHead;
                    }
                    if (hiTail != null) {
                        hiTail.next = null;
                        newTab[j + oldCap] = hiHead;
                    }
                }
            }
        }
    }
    return newTab;
}
```

### 读取数据
```java
final Node<K,V> getNode(int hash, Object key) {
    Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
    // 桶不为空，且key对应的位置不为空
    if ((tab = table) != null && (n = tab.length) > 0 &&
        (first = tab[(n - 1) & hash]) != null) {
        if (first.hash == hash && // always check first node
            ((k = first.key) == key || (key != null && key.equals(k))))
            // 如果在hash桶位置第一个元素找到对应的key，直接返回
            return first;
        if ((e = first.next) != null) {
            // 如果第一个元素与要读取的key不相等，那么遍历hash桶中，另外的元素
            if (first instanceof TreeNode)
                // 在树中查找与key相等的元素
                return ((TreeNode<K,V>)first).getTreeNode(hash, key);
            do {
                // 在链表中查找与key相等的元素
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    return e;
            } while ((e = e.next) != null);
        }
    }
    // 不存在对应的key
    return null;
}
```

### 删除数据
```java
/**
* 同样的分三种情况处理：1. 处于hash桶第一个位置；2. hash桶元素以链表方式组织；3. hash桶元素以树方式组织；
* 分别对这三种情况进行查找、之后删除元素；维护modCount、size变量，并回调函数afterNodeRemoval（LinkedHashMap实现）
*/
final Node<K,V> removeNode(int hash, Object key, Object value,
                               boolean matchValue, boolean movable) {
    Node<K,V>[] tab; Node<K,V> p; int n, index;
    if ((tab = table) != null && (n = tab.length) > 0 &&
        (p = tab[index = (n - 1) & hash]) != null) {
        Node<K,V> node = null, e; K k; V v;
        if (p.hash == hash &&
            ((k = p.key) == key || (key != null && key.equals(k))))
            node = p;
        else if ((e = p.next) != null) {
            if (p instanceof TreeNode)
                node = ((TreeNode<K,V>)p).getTreeNode(hash, key);
            else {
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key ||
                         (key != null && key.equals(k)))) {
                        node = e;
                        break;
                    }
                    p = e;
                } while ((e = e.next) != null);
            }
        }
        if (node != null && (!matchValue || (v = node.value) == value ||
                             (value != null && value.equals(v)))) {
            if (node instanceof TreeNode)
                ((TreeNode<K,V>)node).removeTreeNode(this, tab, movable);
            else if (node == p)
                tab[index] = node.next;
            else
                p.next = node.next;
            ++modCount;
            --size;
            afterNodeRemoval(node);
            return node;
        }
    }
    return null;
}
```
