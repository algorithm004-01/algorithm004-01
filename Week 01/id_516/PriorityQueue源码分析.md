## PriorityQueue

> 基于**优先级堆**的无限优先级队列。队列中的元素是基于自然排序(Comparable)或是基于构造参数传来的(Comparator)，优先级队列不允许有空元素，优先级队列不允许插入不可比较(non-comparable)对象，如果传入会导致ClassCastException。
>
> 关于其具体的排序，队列的头是最小的元素。如果最小值有多个，堆会放这些元素之一,(ties are broken arbitrarily) 关系会任意破坏。队列的数据检索操作是poll ，remove，peek，element （取元素头）。
>
> 优先级队列是无限的，但有个内部容量管理数组的大小用作于存储元素到队列。容量至少为队列的大小。当元素加到优先级队列中。容量他会自动增加。每次增加细节不是指定的。
>
> ...
>
> 此实现并非线程安全的，如果想要使用线程安全的请使用{@link java.util.concurrent.PriorityBlockingQueue}
>
> 
>
> 此实现：提供了O(log(n))的排队(offer,add)和出队(poll,remove)方法
>
> O(n) remove(Object) 和 contains(Object)
>
> O(1)的数据操作方法 peek,element,size 



### 使用

```java
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Person> pq = new PriorityQueue<>();
        pq.add(new Person(170,"x170"));
        pq.add(new Person(180,"x180"));
        pq.offer(new Person(190,"x190"));
        pq.offer(new Person(200,"x200"));

        pq.forEach(i-> System.out.println(i));

        System.out.println("peek = " + pq.peek());
        System.out.println("element = " + pq.element());
        System.out.println("size = " + pq.size());
        System.out.println("poll = " + pq.poll());
        System.out.println("remove = " + pq.remove());

        pq.forEach(i-> System.out.println(i));

        System.out.println("=========================");
      	// 如果传入Comparator 则Person类不需要实现Comparable接口
        PriorityQueue<Person> pq2 = new PriorityQueue<>(Comparator.comparing(a -> a.name));
        pq2.add(new Person(170,"d170"));
        pq2.add(new Person(180,"c180"));
        pq2.offer(new Person(190,"b190"));
        pq2.offer(new Person(200,"a200"));

        pq2.forEach(i-> System.out.println(i));
    }
    @Data
    @AllArgsConstructor
    static class Person implements Comparable<Person>{
        private Integer height;
        private String name;

        @Override
        public int compareTo(Person o) {
            if(this.height == o.height)
                return 0;
            else if(this.height > o.height)
                return 1;
            else
                return -1;
        }
    }

}
```

### 如何实现？

> 优先级队列意味着 **平衡二叉堆**，queue[n]的俩个子节点是 queue[2n + 1]和queue[2n + 2]。优先级队列使用compator来排序，或是使用元素的自然排序，如果compartor是空： 对于每一个在堆中的节点 n 他的每个子孙 d 都满足 n <= d 即最小堆。 如果队列不为空，元素最小值在queue[0].



#### add offer 核心

```java
   	/**
   	 * 大致思路就是将元素插入最后一位，不断比较他和父亲节点，如果他小那么就往上不断做siftUp
   	 */ 
		public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        modCount++;
        int i = size;
        if (i >= queue.length)
            grow(i + 1);
        size = i + 1;
        if (i == 0)
            queue[0] = e;
        else
            siftUp(i, e);
        return true;
    }

		// k > 0
		private void siftUp(int k, E x) {
        if (comparator != null)
            siftUpUsingComparator(k, x);
        else
            siftUpComparable(k, x);
    }

    @SuppressWarnings("unchecked")
    private void siftUpUsingComparator(int k, E x) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if (comparator.compare(x, (E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = x;
    }

    private void siftUpComparable(int k, E x) {
     		// same code
    }
```



####  poll，remove 核心

```java
   	/**
   	 * 大致思路就是将第一个元素移出后，最后一个元素补到第一个元素位,如果不符合最小堆比对做siftDown
   	 * 一直比较的是左子节点
   	 */
		public E poll() {
        if (size == 0)
            return null;
        int s = --size;
        modCount++;
        E result = (E) queue[0];
        E x = (E) queue[s];
        queue[s] = null;
        if (s != 0)
            siftDown(0, x);
        return result;
    }

		private void siftDown(int k, E x) {
        if (comparator != null)
            siftDownUsingComparator(k, x);
        else
            siftDownComparable(k, x);
    }
		
    @SuppressWarnings("unchecked")
    private void siftDownComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>)x;
        int half = size >>> 1;        // loop while a non-leaf  
      	// size / 2 < ele then ele is non-leaf
        while (k < half) {
            int child = (k << 1) + 1; // **assume left child is least**
            Object c = queue[child];
            int right = child + 1;
            // 这行的意义是什么？ 右节点存在 并且 左节点大于右节点，那么左节点应该为右节点值
          	// 因为这个循环只是一直比较左边的孩子节点与父亲节点的大小，所以如果不进行此操作会导致堆不成立
            if (right < size &&
                ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
                c = queue[child = right];
          	// 与左子节点比较 如果已经小了那么就不需要再进行变动了
            if (key.compareTo((E) c) <= 0)
                break;
            queue[k] = c;
            k = child;
        }
        queue[k] = key;
    }


		private E removeAt(int i) {
        // assert i >= 0 && i < size;
        modCount++;
        int s = --size;
        if (s == i) // removed last element
            queue[i] = null;
        else {
            E moved = (E) queue[s];
            queue[s] = null;
            siftDown(i, moved);
            if (queue[i] == moved) {
                siftUp(i, moved);
                if (queue[i] != moved)
                    return moved;
            }
        }
        return null;
    }
```





#### 查询方法

```java
    public E peek() {
        return (size == 0) ? null : (E) queue[0];
    }

    private int indexOf(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++)
                if (o.equals(queue[i]))
                    return i;
        }
        return -1;
    }
```

####  其他方法 



```java
    // 找到所有非叶子节点 从后往前全部左排序 最后能够形成一个最小堆
    private void heapify() {
        for (int i = (size >>> 1) - 1; i >= 0; i--)
            siftDown(i, (E) queue[i]);
    }


    /**
     * The maximum size of array to allocate.
     * Some VMs reserve some header words in an array.
     * Attempts to allocate larger arrays may result in
     * OutOfMemoryError: Requested array size exceeds VM limit
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private void grow(int minCapacity) {
        int oldCapacity = queue.length;
        // Double size if small; else grow by 50%
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                         (oldCapacity + 2) :
                                         (oldCapacity >> 1));
        // overflow-conscious code
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        queue = Arrays.copyOf(queue, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }
```