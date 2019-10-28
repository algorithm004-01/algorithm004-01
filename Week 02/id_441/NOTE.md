# NOTE
物理存储的存储结构：
顺序，链式，索引，散列

## 哈希，映射，集合

## 哈希表

哈希表（散列表），是一种（key Value）结构，是根据key，通过散列函数F(key),来访问内存存储位置的数据结构。但是，对于不同的key值，F(key)的输出有可能是一样的，这样的现象叫做冲突（Collosion）.这些不同的key值叫做***同义词***。
处理冲突一般有：
1. 开放定址法
2. 单独链表法
3. 双散列
4. 再散列
5. 建立公共溢出区域

## 时间复杂度
哈希表（散列表），是一种（key Value）结构，

redis是一种典型的应用场景

### 哈希碰撞

key通过哈希算法比如ASCII码加到一起再mod9等
不同的key通过哈希算法得到相同的值，称之为哈希碰撞。
哈希碰撞在工程上的通用解决方法是：增加维度，比如说相同的内存地址存储多个数。在改内存中拉出来一个链表用来存储哈希碰撞产生的多余的数据。这种解决方式叫做拉链式。

### 时间复杂度

如果在没有哈希碰撞的情况下(完美哈希)，查询，添加，删除的时间复杂度是O(1)的。但是有哈希碰撞的情况下(即：哈希算法选的不好或者哈希的size过于小的情况，哈希表会退化成为链表；但是在现在的硬件和算法情况下这种情况还是比较小的)，需要遍历整个链表来查询诗句，这个时候的时间复杂度就是O(n)的。在通常情况下，哈希算法是要保证分散的。所以哈希表的平均时间复杂度是O(1).

### 应用场景

1. Map：key-value对，key不重复.
2. Set：不重复元素的集合

### Java中的Set和Map

1. HashMap
这里是Java中的Map的源码[Java Set](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Set.html)。api中的Put和Get需要特地注意一下是在嗯么实现的。

2. Set
这里是Java中的Set的源码[Java Map](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Map.html)。
Java的Set是在HashMap的基础上实现的。

### js中的Set和Map

1. Map
js中的Map和Set是在es6中裁出现的。Map相对于Object来讲，Map会比Object更哈希化。Map的key可以使任意的变量类型，而Object的key必须是String的类型（即使不是String类型也会调用Object.toString()来使其String化）。

2. Set
Set和Map一样也是在es6中出现的。Set对象是值的集合。并且Set中的每个元素只会出现一次。但是对于NaN来说NaN在Set中会被认为是一样的值（因为实际中NaN!==NaN）。
在js中Set有以下几个方法：
add,clear,delete,entreis,forEach,has,keys,values.

### Python中的dict和Set

1. dict

2. Set

## 树，图

链表是特殊化的树，树有两个next指针
树是特殊化的图，没有环的图就是树。
树的特点：

1. 每个节点只有有限个子节点或者无节点

2. 没有父节点的节点叫做根节点

3. 每一个非根节点有且只有一个父节点

4. 除了根节点之外，每个子节点可以飞微多个不相交的子树

5. 树里面没有环路

### 树节点的定义

1. python

```python
class TreeNode:
    def __init__(self,val):
        self.val = val
        self.left,self.right = None,None
```

2.Java

```java
public class TreeNode {
    public init val;
    public TreeNode left, right;
    public TreeNode(init val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
```

3.c++

```c++
struct TreeNode{
    init val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(init x):val(x),left(NULL),right(NULL){}
}
```

### 树的问题的一般解决思路

树问题的一般解决思路是使用递归的方式来解决。有以下几个原因：

1. 在运用递归的时候，***递归树***能更好的帮助分析算法复杂度。

2. 递归可以把一个大型复杂的问题转化成与原问题相似的规模小的问题；即子问题需要与原问题为同样的事情，且更加简单。而树节点的每个子树可以类比为子问题，整个树可以类比为原问题。所以从本省特性来讲递归和树是比较符合的。

3. 递归需要有边界情况，前进段和递归返回段，而因为树每个节点只有有限个子节点或者无节点，所以是有边界情况的，前进段的，递归返回段的。

4. 递归一般用于解决：1）数据的定义是按递归定义的（Fibonacci函数）；2）问题的解法按递归算法实现（Hanoi问题）；3）数据的结构形式是按递归定义的。（二叉树，广义表等，这类数据结构本身固有递归特性）。

5. 从工程角度，可读程度和维护程度来讲，在树的遍历情况下，递归比循环更加容易读懂并且可维护性更高。

## 二叉树

### 二叉树遍历

1. 前序遍历（pre-order）:根-左-右

2. 中序遍历（in-order）: 左-根-右

3. 后序遍历（Post-order）:左-右-根

### 二叉搜索树

也称有序二叉树，空树也是二叉搜索树。特点是：左子树***所有节点**的值<根节点的值<右子树***所有节点***的值。以此类推出来的一个数据结构，同事左右子树也叫二叉搜索树。

### 二叉搜索树常见操作

查询和操作的时间复杂度都是O(log(N))的。
对于二叉搜索树因为是有序的所以查找的时候每次都会筛掉一半的节点。时间复杂度是O(log(2N))
对于增加节点的话，增加的位置就是查找要增加的节点，查不到的位置。
对于删除操作，如果是子树的根节点，一般是要拿一个节点来填充'删除的节点'的位置，这个节点的选择有两种方式：1）紧邻着'要删除的节点'但是要小于'删除的节点'的节点；2）刚刚大于'删除的节点'的节点（右子树里面最小的节点，右子树里面的最左节点）。一般是使用第二种方式来填充删除掉的节点。
特殊情况：只有右子树，就是链表就是O(N)的时间复杂度。解决办法的话可以配平。

## 递归

节点性，重复性的问题。
递归本质上就是循环，只不过是循环函数体来进行循环，即调用自身。
特点：

1. 每次进入下一层级，向上可以返回上一层，有对称性

2. 通过函数的参数可以进行不同层次之间的传递

3. 每层的执行环境是不一样的，但是参数是有关联的

简单的递归比如斐波那契数列。

### 递归的代码模板

+ python

```python

def recursion(level,param1,param2,...):

    #recursion terminator 递归终结条件
    #写递归的时候一定注意先写递归的终结条件
    if level>MAX_LEVEL:
        process_result
        return

    # process logic in current level
    # 处理当前层的代码逻辑
    process(level, data...)

    # drill down
    # 下探到下一层去
    # level代表是第几层
    self.recursion(level+1,p1,...)

    # reverse the current level status if needed
    # 清理当前层次，

```

+ Java

```Java

public void recur(int level, int param) {
    // terminator
    if(level > MAX_LEVEL){
        // return process result
        return;
    }

    // process current logic
    process(level, param);

    // drill down
    recur(level:level+1, newParam);

    //restore current status
}

```

### 递归的思维要点

1. 不要人肉进行递归（这是最大的思维误区）（避免写递归树，避免画递归状态，直接看着函数写就好了）

2. 找到最近最简的方法，将其拆解成可重复解决的问题（重复子问题）

3. 数学归纳法要熟练运用

## 分治，回溯

分治回溯是特殊的递归。
本质就是找重复性，分解问题，组合子问题的结果
重复性有最近重复性和最优重复性。而最优重复性就是动态规划。
回溯，在每一层进行试错，八皇后问题和数组问题用的比较多。
[括号问题](https://leetcode-cn.com/problems/generate-parentheses/)

### 代码模板

比递归多一步，这一步在drill down 和 revert state中间，一般是用来处理合并drill down的子结果的。

```Python

def divide_conquer(problem, param1, parm2):
    #recursion terminator
    # 子问题结束
    if problem is None:
        print_result
        return
    # prepare data
    # 处理当前逻辑
    data = prepare_data(problem)
    subproblems = split_problem(problem,data)
    # conquer subproblems
    subresult1 = self.divide_conquer(subproblems[0],p1,...)
    subresult2 = self.divide_conquer(subproblems[1],p1,...)
    subresult3 = self.divide_conquer(subproblems[2],p1,...)
    ...
    # process and genrate the final result
    result = process_result(subresult1,subresult2,subresult3,...)
    # revert the current level states

```
