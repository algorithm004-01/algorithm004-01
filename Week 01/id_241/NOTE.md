### 粗略笔记
+ 数组

内存管理器分配一块连续的内存地址

+ ArrayList

基于数组实现，且是非并发安全的(对于内部结构的修改)，通常需要外部对象同步。如果无法外部同步，则需要
```
List list = Collections.synchronizedList(new ArrayList(...));
```
其`iterators`与`listIterator`如果在创建后，修改了其内部结构(除了 iterator 自己的 remove 与 add 方法)，其返回是快速失败的。
快速失败在非同步下，不能得到保证，所以应用只能用于调试而不能依靠快速失败异常。

transient : 只能修饰变量，不被序列化(反序列化后，无法获得访问)。

O(1) : size isEmpty get set iterator listIterator
O(n) : add (and others)




  

