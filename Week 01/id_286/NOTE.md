# 学习总结

### 解题并提升兴趣

* 第一遍听老师讲，听的比较费劲的地方，暂停思考明白
* 第二遍听老师讲，买一个小白板动手画思路，同时记录老师描述的关键解题思路和信息。
* 两遍听课结束之后，动手写代码和看评论
  * 明白思路，自己写，不明白思路，直接看题解
  * 编写的过程从暴力开始，一点点优化，最后找出一个稍微好一点的解法多次复习记忆
  * leetcode-cn到leetcode国际站，很关键，国外牛人代码很精妙。
* 通过解题过程提升兴趣
  * 解题思路
  * 性能优化
  * 自己的代码和别人的比较，以及国际站的牛人代码如何千锤百年

### 源码分析

* Queue

  ```java
  public interface Queue<E> extends Collection<E> {
      // 队尾添加元素，满了就抛出异常
      boolean add(E e);
  
      // 队尾添加元素，满了返回false
      boolean offer(E e);
  
      // 出队，队空抛异常
      E remove();
  
    	// 出队，队空返回null
      E poll();
  
      // 查看队头，队空抛异常
      E element();
  
      // 查看队头，队空返回null
      E peek();
  }
  ```

* PriorityQueue

  * 分析有难度，暂未分析

  ### Deque最新api使用

* addFirst和addLast

  ```java
  public static void main(String[] args) {
    Deque<Integer> deque = new LinkedList<>();
  
    // 队尾添加
    deque.add(31);
    deque.add(32);
    deque.add(33);
  
    // 队头添加
    deque.addFirst(11);
    deque.addFirst(12);
  
    // 队尾添加
    deque.addLast(91);
    deque.addLast(92);
  
    System.out.println(deque);
  }
  
  // console
  [12, 11, 31, 32, 33, 91, 92]
  ```

  

