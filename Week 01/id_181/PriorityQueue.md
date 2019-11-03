## PriorityQueue 优先队列

> 优先级队列的元素按照其自然顺序进行排序，或者根据构造队列时提供的 Comparator 进行排序
> PriorityQueue 是一个无界队列，但是初始的容量(实际是一个Object[])，随着不断向优先级队列添加元素，其容量会自动扩容，无需指定容量增加策略的细节。

参考文献：

[《Java源码分析》：PriorityQueue - wojiushimogui的博客 - CSDN博客](https://blog.csdn.net/u010412719/article/details/52355557)
[Source for java.util.PriorityQueue (GNU Classpath 0.99.1-pre Documentation)](http://fuseyism.com/classpath/doc/java/util/PriorityQueue-source.html#line.231)