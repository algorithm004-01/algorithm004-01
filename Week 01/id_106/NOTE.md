# NOTE
### 20191014-1020第一周学习总结
**一、主要内容**
1.学习了数组，链表，栈，队列，双端队列的给基本数据结构预期基本原理
2.通过练习题目加深了对上述数据结构的理解与使用熟练度；同时，通过题目的练习了解了一些常用解题思路与代码处理方式。

**二、代码改写**
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();
        deque.addFirst("a");
        deque.addLast("b");
        deque.addLast("c");
        System.out.println(deque);

        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while ( deque.size() > 0){
            System.out.println(deque.removeFirst());//pop
        }
        System.out.println(deque);
    }
    //output
    /*
    [a, b, c]
    a
    [a, b, c]
    a
    b
    c
    []
    */

**三、关于java PriorityQueue的源码分析**
java中PriorityQueue由平衡二进制堆实现(balanced binary heap)
堆(heap)是一种有数组实现的二叉树数据结构，通过堆属性来排列元素，分为最大堆与最小堆两种类型。所谓最大堆指的就是父节点大于所有的子节点；最小堆是指父节点小于所有子节点。根据api描述，PriorityQueue类型为最小堆，queue[0]位置将会保存最小的元素。

_1.add方法_
add方法内部直接调用offer方法，其中先判断插入元素是否为null，长度是否超出等类似操作之后，执行主要的siftUp(index,e)方法将元素加入。

	private void siftUp(int k, E x) {
        if (comparator != null)
            siftUpUsingComparator(k, x);//使用Comparator
        else
            siftUpComparable(k, x);//使用Comparable
    }

	private void siftUpComparable(int k, E x) {
	    Comparable<? super E> key = (Comparable<? super E>) x;
	    while (k > 0) {
	        int parent = (k - 1) >>> 1;//取要insert元素的索引位置的上一层元素索引，即当前节点的父节点索引
	        Object e = queue[parent];
	        if (key.compareTo((E) e) >= 0)//判断插入值是否不小于父节点的值
	            break;
	        queue[k] = e;//插入值不父节点的值小，向上移动一层
	        k = parent;
	    }
	    queue[k] = key;
	}

通过此方法add保证了队列中queue[0]为最小节点，但没有按照优先级进行严格排序。

_2.poll出列方法_
前将最小的第一个元素出列，后面的元素进行重排序。

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
    排序方法如下：

    private void siftDownComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>)x;
        int half = size >>> 1;        // loop while a non-leaf
        while (k < half) {
            int child = (k << 1) + 1; // 获取左子的索引，假设坐姿左子最小
            Object c = queue[child];//获取左子的值
            int right = child + 1;//获取右子的key
            if (right < size &&
                ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
                c = queue[child = right];//如果左子的值大于右子，取两者最小
            if (key.compareTo((E) c) <= 0)
                break;//判断当前元素是否小于最小子
            queue[k] = c;//如果不是，将最小子放置在当前元素
            k = child;//将下表替换为左子下标，继续便利，直到叶子节点的上一层
        }
        queue[k] = key;
    }
    
可以看出，当第一个元素出队列之后，对剩下的元素进行再排序，挑选出最小的元素排在数组第一个位置。

以上是对add和poll的简要分析，还有些没有看完，如有错误请老师和同学们指出，欢迎大家交流。

