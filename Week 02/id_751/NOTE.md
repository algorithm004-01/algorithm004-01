# NOTE
HashMap
 存储结构
 
  内部包含了一个 Entry 类型的数组 table。
 
    transient Entry[] table;
 Entry 存储着键值对。它包含了四个字段，从 next 字段我们可以看出 Entry 是一个链表。即数组中的每个位置被当成一个桶，一个桶存放一个链表。HashMap 使用拉链法来解决冲突，同一个链表中存放哈希值和散列桶取模运算结果相同的 Entry。
 
 
 
     static class Entry<K,V> implements Map.Entry<K,V> {
         final K key;
         V value;
         Entry<K,V> next;
         int hash;
 
     Entry(int h, K k, V v, Entry<K,V> n) {
         value = v;
         next = n;
         key = k;
         hash = h;
     }
 
     public final K getKey() {
         return key;
     }
 
     public final V getValue() {
         return value;
     }
 
     public final V setValue(V newValue) {
         V oldValue = value;
         value = newValue;
         return oldValue;
     }
 
     public final boolean equals(Object o) {
         if (!(o instanceof Map.Entry))
             return false;
         Map.Entry e = (Map.Entry)o;
         Object k1 = getKey();
         Object k2 = e.getKey();
         if (k1 == k2 || (k1 != null && k1.equals(k2))) {
             Object v1 = getValue();
             Object v2 = e.getValue();
             if (v1 == v2 || (v1 != null && v1.equals(v2)))
                 return true;
         }
         return false;
     }
 
     public final int hashCode() {
         return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
     }
 
     public final String toString() {
         return getKey() + "=" + getValue();
     }
 }
 
 
 put操作
    
    public V put(K key, V value) {
        if (table == EMPTY_TABLE) {
            inflateTable(threshold);
        }
        // 键为 null 单独处理
        if (key == null)
            return putForNullKey(value);
        int hash = hash(key);
        // 确定桶下标
        int i = indexFor(hash, table.length);
        // 先找出是否已经存在键为 key 的键值对，如果存在的话就更新这个键值对的值为 value
        for (Entry<K,V> e = table[i]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }
        modCount++;
        // 插入新键值对
        addEntry(hash, key, value, i);
        return null;
    }
    
   HashMap 允许插入键为 null 的键值对。但是因为无法调用 null 的 hashCode() 方法，也就无法确定该键值对的桶下标，只能通过强制指定一个桶下标来存放。HashMap 使用第 0 个桶存放键为 null 的键值对。

    private V putForNullKey(V value) {
        for (Entry<K,V> e = table[0]; e != null; e = e.next) {
            if (e.key == null) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }
        modCount++;
        addEntry(0, null, value, 0);
        return null;
    }
    
   使用链表的头插法，也就是新的键值对插在链表的头部，而不是链表的尾部。
   
    void addEntry(int hash, K key, V value, int bucketIndex) {
        if ((size >= threshold) && (null != table[bucketIndex])) {
            resize(2 * table.length);
            hash = (null != key) ? hash(key) : 0;
            bucketIndex = indexFor(hash, table.length);
        }
    
        createEntry(hash, key, value, bucketIndex);
    }
    
    void createEntry(int hash, K key, V value, int bucketIndex) {
        Entry<K,V> e = table[bucketIndex];
        // 头插法，链表头部指向新的键值对
        table[bucketIndex] = new Entry<>(hash, key, value, e);
        size++;
    }
    
    
    Entry(int h, K k, V v, Entry<K,V> n) {
        value = v;
        next = n;
        key = k;
        hash = h;
    }
    
 确定桶下标

    int hash = hash(key);
    int i = indexFor(hash, table.length);
    
   计算 hash 值
   
    final int hash(Object k) {
        int h = hashSeed;
        if (0 != h && k instanceof String) {
            return sun.misc.Hashing.stringHash32((String) k);
        }
    
        h ^= k.hashCode();
    
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
    
    public final int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }
    
  扩容-基本原理
   设 HashMap 的 table 长度为 M，需要存储的键值对数量为 N，如果哈希函数满足均匀性的要求，那么每条链表的长度大约为 N/M，因此平均查找次数的复杂度为 O(N/M)。
 
   为了让查找的成本降低，应该尽可能使得 N/M 尽可能小，因此需要保证 M 尽可能大，也就是说 table 要尽可能大。HashMap 采用动态扩容来根据当前的 N 值来调整 M 值，使得空间效率和时间效率都能得到保证。
 
   和扩容相关的参数主要有：capacity、size、threshold 和 load_factor。
 
     参数	含义
     capacity	table 的容量大小，默认为 16。需要注意的是 capacity 必须保证为 2 的 n 次方。
     size	键值对数量。
     threshold	size 的临界值，当 size 大于等于 threshold 就必须进行扩容操作。
     loadFactor	装载因子，table 能够使用的比例，threshold = (int)(newCapacity * loadFactor)。
 
     static final int DEFAULT_INITIAL_CAPACITY = 16;
     
     static final int MAXIMUM_CAPACITY = 1 << 30;
     
     static final float DEFAULT_LOAD_FACTOR = 0.75f;
     
     transient Entry[] table;
     
     transient int size;
     
     int threshold;
     
     final float loadFactor;
 
    transient int modCount;
   从下面的添加元素代码中可以看出，当需要扩容时，令 capacity 为原来的两倍。
 
     void addEntry(int hash, K key, V value, int bucketIndex) {
         Entry<K,V> e = table[bucketIndex];
         table[bucketIndex] = new Entry<>(hash, key, value, e);
         if (size++ >= threshold)
             resize(2 * table.length);
     }
   扩容使用 resize() 实现，需要注意的是，扩容操作同样需要把 oldTable 的所有键值对重新插入 newTable 中，因此这一步是很费时的。
 
     void resize(int newCapacity) {
         Entry[] oldTable = table;
         int oldCapacity = oldTable.length;
         if (oldCapacity == MAXIMUM_CAPACITY) {
             threshold = Integer.MAX_VALUE;
             return;
         }
         Entry[] newTable = new Entry[newCapacity];
         transfer(newTable);
         table = newTable;
         threshold = (int)(newCapacity * loadFactor);
     }
     
     void transfer(Entry[] newTable) {
         Entry[] src = table;
         int newCapacity = newTable.length;
         for (int j = 0; j < src.length; j++) {
             Entry<K,V> e = src[j];
             if (e != null) {
                 src[j] = null;
                 do {
                     Entry<K,V> next = e.next;
                     int i = indexFor(e.hash, newCapacity);
                     e.next = newTable[i];
                     newTable[i] = e;
                     e = next;
                 } while (e != null);
             }
         }
     }
     
     
  扩容-重新计算桶下标
   在进行扩容时，需要把键值对重新计算桶下标，从而放到对应的桶上。在前面提到，HashMap 使用 hash%capacity 来确定桶下标。HashMap capacity 为 2 的 n 次方这一特点能够极大降低重新计算桶下标操作的复杂度。
 
   假设原数组长度 capacity 为 16，扩容之后 new capacity 为 32：
 git
     capacity     : 00010000
     new capacity : 00100000
     
   对于一个 Key，它的哈希值 hash 在第 5 位：
 
     为 0，那么 hash%00010000 = hash%00100000，桶位置和原来一致；
     为 1，hash%00010000 = hash%00100000 + 16，桶位置是原位置 + 16
   
  
