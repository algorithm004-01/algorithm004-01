# Queue源码分析

> ```java
> * A collection designed for holding elements prior to processing.
> * Besides basic {@link java.util.Collection Collection} operations,
> * queues provide additional insertion, extraction, and inspection
> * operations.  Each of these methods exists in two forms: one throws
> * an exception if the operation fails, the other returns a special
> * value (either {@code null} or {@code false}, depending on the
> * operation).  The latter form of the insert operation is designed
> * specifically for use with capacity-restricted {@code Queue}
> * implementations; in most implementations, insert operations cannot
> * fail.
>   
>   一个设计为先保有元素后加工的集合。除了基础的Collection的操作，队列提供了额外的插入、提取和检查操作。这些方法每一个都保有两种形式，一种抛出异常，另一种返回特殊的值。后者的插入操作是为了给那些容量右限制的队列实现类。在大多数实现中，插入操作都不会失败。
>    * <table BORDER CELLPADDING=3 CELLSPACING=1>
>  * <caption>Summary of Queue methods</caption>
>  *  <tr>
>  *    <td></td>
>  *    <td ALIGN=CENTER><em>Throws exception</em></td>
>  *    <td ALIGN=CENTER><em>Returns special value</em></td>
>  *  </tr>
>  *  <tr>
>  *    <td><b>Insert</b></td>
>  *    <td>{@link Queue#add add(e)}</td>
>  *    <td>{@link Queue#offer offer(e)}</td>
>  *  </tr>
>  *  <tr>
>  *    <td><b>Remove</b></td>
>  *    <td>{@link Queue#remove remove()}</td>
>  *    <td>{@link Queue#poll poll()}</td>
>  *  </tr>
>  *  <tr>
>  *    <td><b>Examine</b></td>
>  *    <td>{@link Queue#element element()}</td>
>  *    <td>{@link Queue#peek peek()}</td>
>  *  </tr>
>  * </table>
>   
>   queues 一般来说（但不是必须的）是以一种FIFO先进先出的模式。例外中有如下：优先级队列（Priority Queues 他的顺序是通过比较器，或是元素的自然顺序），LIFO （Last in fisrt out）队列如Stack，但不管你是如何排列，remove，poll方法都是移出头节点。若是FIFO队列，所有元素都是插入到最后一个元素，其他的队列可能会有不同的规则。每个实现必须指定他的顺序属性。
>   方法offer在能插入元素时插入元素，否则将返回false。这个方法与集合的add方法有不同之处。add方法如果插入不进元素会抛出异常。offer方法被设计当错误是正常的。
>   remove和poll方法都会返回头元素。这俩方法唯一的区别是在于当队列位空的情况下，remove会抛出异常，而poll方法返回空
>   element和peek都会返回头元素，但不会移出。
>   Queue不回定义并发编程的方法
>   Queue一般不允许插入null元素。而LinkedList可以插入空。poll方法的相关性
>   
> ```

## add

> ```java
> boolean add(E e);
> ```
>
> 向队列中插入具体的元素，如果没有违反容量的限制那么立马返回true如果没有空间则抛出IllegalStateException





## offer

> ```java
> boolean offer(E e);
> ```
>
> 向队列中插入具体的元素，如果没有违反容量的限制。当你想要使用容量限制的队列时，建议你使用add方法。



## remove

>```java
>E remove();
>```
>
>检索并且移出队列头元素，这个方法不同于poll，这个当队列为空时会抛出异常NoSuchElementException

## poll

> ```java
> E poll();
> ```
>
> 检索并且移出队列头元素，如果队列为空，则返回Null

## element

> ```java
> E element();
> ```
>
> 检索但不移出队列的头。这个方法不同于peek，当队列为空时会抛出异常。

## peek

> ```java
> E peek();
> ```
>
> 检索但不移出队列的头。如果队列为空则返回null。

