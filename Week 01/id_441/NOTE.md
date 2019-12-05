# NOTE

## 数据结构和算法第一周的学习内容

算法和数据结构解答题目的时候的两个思维：
1. 做题不要只做一遍（五毒神掌）
2. 升维，空间换时间

## 数组

数组是典型的线性结构，数组在内存中的存在方式是一段连续的内存空间。

### 数组的访问

因为是一段连续的内存空间，所以只要有数组的第一个元素的地址，就可以通过内存的寻址公式：a[i]_address = base_address + i * data_type_size，以O(1)的时间复杂度来访问数组中的任意一个元素。所以无论数组的长度是1还是一万还是一百万，访问数组中任意元素的时间复杂度都是O(1).

### 数组的操作
因为数组是一段连续的内存空间，所以对数组的任意元素的操作都会影响到整个数组的空间。比如往数组中添加一个元素时，最好的情况是往数组最后添加这个时候数组的时间复杂度是O(1)；如果往数组第一个位置添加元素的话，数组后面所有的元素都需要在内存中后移一位，所以这个时候的时间复杂度是O(n)；删除的话时间复杂度也是O(n);所以对数组的操作的时间复杂度是O(n)，这也是数组这一类型的缺陷所在。

### js中的数组

js中的数组被称之为类型化数组，是一种类似数组的**对象**。js数组的长度和元素类型都是非固定的（非固定的元素类型可以理解成为泛型），js数组的length属性是可以随时改变的，在内存中也不一定是连续的内存空间，所以js的数组是非密集型的。在js中的类型数组是[TypedArray](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/TypedArray),它提供了8个类型，可以用来创造相关的类型数组。

### java中的数组

java中的数组是普通数组，需要处理边界情况，也就是当数组的size不够的时候需要扩容，一般是扩两倍原size的大小。

## 链表

链表是非连续非顺序的存储结构。访问的时间复杂度是O(n)，操作的时间复杂度是O(1)。

### js中单链表的实现

```js

class Node {
  constructor (element) {
    this.element = element
    this.next = null
  }
}

class LinkedList {
  constructor () {
    this.head = new Node('head')
  }
  // 根据value查找节点
  findByValue (item) {
    let currentNode = this.head.next
    while (currentNode !== null && currentNode.element !== item) {
      currentNode = currentNode.next
    }
    console.log(currentNode)
    return currentNode === null ? -1 : currentNode
  } 
  
  // 根据index查找节点，下标从0开始
  findByIndex (index) {
    let currentNode = this.head.next
    let pos = 0
    while (currentNode !== null && pos !== index) {
      currentNode = currentNode.next
      pos++
    }
    console.log(currentNode)
    return currentNode === null ? -1 : currentNode
  }

  // 向链表末尾追加节点
  append(newElement) {
    const newNode = new Node(newElement)
    let currentNode = this.head
    while(currentNode.next) {
      currentNode = currentNode.next
    }
    currentNode.next = newNode
  }
  
  // 指定元素向后插入
  insert (newElement, element) {
    const currentNode = this.findByValue(element)
    if (currentNode === -1) {
      console.log('未找到插入位置')
      return
    }
    const newNode = new Node(newElement)
    newNode.next = currentNode.next
    currentNode.next = newNode
  } 
  
  // 查找前一个
  findPrev (item) {
    let currentNode = this.head
    while (currentNode.next !== null && currentNode.next.element !== item) {
      currentNode = currentNode.next
    }
    if (currentNode.next === null) {
      return -1
    }
    return currentNode
  } 
  
  // 根据值删除
  remove (item) {
    const prevNode = this.findPrev(item)
    if (prevNode === -1) {
      console.log('未找到元素')
      return
    }
    prevNode.next = prevNode.next.next
  }
  
  // 遍历显示所有节点
  display () {
    let currentNode = this.head.next // 忽略头指针的值
    while (currentNode !== null) {
      console.log(currentNode.element)
      currentNode = currentNode.next
    }
  }
}
```


## 栈和队列

### stack

栈是一种先进后出的数据结构（FILO），添加和删除的操作都是O(1)，查询的的时间复杂度是O(n)

### queue

队列是一种先进先出（FIFO）的数据结构，添加和删除操作是O(1)，查询的的时间复杂度是O(n)

### 双端队列

deque：double-end queue，是在简单队列的基础上，头和尾都可以pop和push。插入和删除都是O(1)的操作，查询是O(n)操作的。现实中通常使用deque而不是queue。

### 优先队列

priority Queue是优先队列，是按照优先级取出的数据结构，插入操作是O(1)，因为是优先级取出，所以取出操作的优先级是O(logN)。实现较为复杂和多样性，比如：heap的实现方式，bst，AVL，treap。优先级的规则通过comparator函数来定义。

### Java中的实现

1. stack
stack在java中是一个类。方法有push，pop。[stack的实现](http://developer.classpath.org/doc/java/util/Stack-source.html)

2. queue
[queue的实现](http://fuseyism.com/classpath/doc/java/util/Queue-source.html),queue在Java中是一个interface。实现方式有很多种，比如：ArrayDeque,ConcurrentLinkedDeque(并发式链表实现的双端队列),LinkedBlickingDeque(单线程实现的双端队列)，non-blocking,LinkedList.常用方法有add，remove，（offer，poll，这两个方法在异常的时候会有返回值，而add，remove会抛出异常）

3. deque
deque在Java中比queue多了几个api比如：addLast，addFirst,等。

4. priority
priorit在Java中是class。[priority的源码](https://docs.oracle.com/javase/10/docs/api/java/util/PriorityQueue.html)


