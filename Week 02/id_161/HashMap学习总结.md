# HashMap笔记
## JDK1.8注释翻译+自我理解
* HashMap和HashTable相比，除了线程不安全和允许null key值外，大致相同。HashMap不保证插入的顺序性，也不保证当前顺序今后不变。

* HashMap在假设哈希函数良好的情况下，提供常数级时间复杂度的get和put基本操作。遍历集合依赖于HashMap实例的capacity(也就是bucket的数目)，所以如果对遍历操作表现要求较高，不要把初始capacity值设置太高。

* HashMap实例有两个参数影响它的性能表现：初始capacity值和load factor。初始capacity值表示刚创建时hashtable的bucket数。load factor表示在自动扩容之前，最多允许hashtable有多满。当元素个数大于capacity和load factor乘积时，hashtable触发rehash，内部结构重建，buckets扩大两倍

* 默认load factor=0.75提供了时间花费和空间成本之间较好的平衡。升高load factor会降低空间成本，但提高操作时间花费。在设置初始capacity值时，应该考虑hashmap内期望放入多少元素，已最小化rehash操作。如果初始capacity值乘以load factor大于最大entity数，则不会发生rehash。
* 如果需要存储很多映射关系在一个HashMap实例内，创建实例时，设置足够大的capacity将更高效的存储这些映射关系。注意使用hashcode()结果相同的key无论在任何hash表结构内都低效率，减轻这种影响可以使用Key实现Comparable接口。
* HashMap不是同步的容器，需要使用synchronize锁住整个对象实例
* HashMap的迭代器具有“快速失败”功能，如果再迭代器创建后，map实例发生变动，除非是由iterator自身remove方法，将抛出ConcurrentModificationException。因此，由于变动，迭代器将发生快速失败，避免了返回错误结果。
* 迭代器的快速失败表现在并发修改后并不能保证一定会出现，这是一种尽最大努力的机制，并不完全可靠，所以不能依赖此来写程序，而只适合于检测错误情况

## 核心方法  V get(Object key)

* 首先对key进行hash函数运算，具体为(key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16)，即对key进行hashCode运算，得到的Int结果右移16位与原结果进行异运算。

* 得到的hash结果与buckets个数n-1进行且运算，具体为(n - 1) & hash。由于n默认是16，15二进制是1111，且运算后得到hash结果的低四位结果，这个结果即buckets的index。

* 检查buckets[index]是否为null，若不为null，检查buckets[index]存储的key与传入key是否相等(==或equals)，若相等则返回，若不相等，判断buckets[index]是树结构还是链表，遍历找到key相等的节点返回或返回null。


## 核心方法 V put(K key, V value)
* 通过hash函数计算的结果与capacity-1进行且运算，得到buckets的index，若buckets[index]为空，则直接赋值，若不为空，首先查看首元素是否key相等，若不相等，再判断是否是树结构，若是则将value放在树结构内合适的位置，若是链表，则遍历查找是否存在key相等的value，若有则替换，否则在链表尾部追加新value节点。若节点数过多，则将链表转化为树结构。插入完成后，检查size，若超过threshold则resize()扩容，扩容后buckets数为原先2倍。
> threshold初始值为capacity，后期为capacity * loadFactor