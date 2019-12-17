/**
 * java 13 new api Deque
 * @author hemiao
 * @date 2019-10-20 18:00
 */
public class NewDeque {

  public static void main(String[] args) {

    Deque<String> deque = new LinkedList<String>();
    deque.addFirst("a");
    deque.addFirst("b");
    deque.addFirst("c");

    System.out.println(deque);

    String str = deque.peekFirst();
    System.out.println(str);
    System.out.println(deque);

    while (deque.size() > 0) {
      System.out.println(deque.pollFirst());
    }
    System.out.println(deque);

  }

}


Queue 队列源码分析
 特性
  1.通常但不一定是先进先出(FIFO)
  2.不允许插入null，因为null已经作为poll方法的返回值，表示当前队列为空

 add()  添加元素
  1.成功返回true,失败返回异常
  2.IllegalStateException：队列容量已满时添加元素，抛出异常
  3.ClassCastException：添加的元素与队列的指定的类型不匹配时，抛出异常
  4.IllegalArgumentException：添加元素中含有非法参数时，抛出异常
  5.NullPointerException：添加的元素为null时，抛出异常

 offer()  添加元素
  1.成功返回true
  2.ClassCastException：添加的元素与队列的指定的类型不匹配时，抛出异常
  3.IllegalArgumentException：添加元素中含有非法参数时，抛出异常
  4.NullPointerException：添加的元素为null时，抛出异常

 remove()  删除头元素
  1.成功返回删除的元素，失败返回异常
  2.NoSuchElementException：当队列为空时，弹出元素，抛出异常

 poll()  删除头元素
  1.成功返回删除的元素，当队列为空时，弹出null

 element()  检索头元素
  1.成功返回删除的元素，失败返回异常
  2.NoSuchElementException：当队列为空时，弹出元素，抛出异常

 peek()  检索头元素
  1.成功返回删除的元素，失败返回null


PriorityQueue 优先队列源码分析
 特性
  1.基于优先级取出，默认为自然顺序如输入：53214，输出：12345
  2.线程不安全，如考虑线程安全，使用PriorityBlockingQueue类
  3.可自定义排序规则，使用带Comparator类的构造器即可
 
 comparator()  指定优先级，根据元素中的属性进行排序的比较器 
 
 add()/offer()  添加元素
  1.成功返回true,失败抛异常
  2.NullPointerException：添加的元素为null时，抛出异常
  3.IllegalArgumentException：添加元素中含有非法参数时，抛出异常，即添加的元素与队列中的元素不能比较的时候

 poll()  弹出元素
  1.成功返回删除的元素，当队列为空时，弹出null
  
 peek()  检索头元素
  1.成功返回删除的元素，失败返回null
  
 remove/removeEq/removeAll  删除指定元素/集合中的元素

 clear()  清空元素
 
 size()  队列长度
 
 contains​(Object o) 是否包含指定元素
  

学习总结

    中心思想：升维思想空间换时间
	最大误区：刷题只刷一遍
	
	1.数组、链表、跳表
		空间复杂度
			数组：插入和删除是O(n)
			链表: 查询时O(n)
			跳表: O(logn)

		实现
			查看Java 源码
	    
		题目解析
			前后指针，i,j双指针重点，需会默写
			左右边界，i,j双指针，j==list.length()-1重点，需会默写
			
	2.栈、队列、优先队列、双端队列
		空间复杂度
			栈：先入后出；添加、删除皆为O(1)
			队列：先入先出；添加、删除皆为O(1)
			双端队列:两端都可以进出的队列；添加、删除皆为O(1)
			优先队列：按照元素优先级取出；添加为O(1),删除为O(logn)
			
		实现
			查看Java源码