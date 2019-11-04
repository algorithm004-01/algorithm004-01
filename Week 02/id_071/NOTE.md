# NOTE

> 哈希表、映射、集合


    m := map[]int{}
    mp := make(map[]int,1,10)


****

> 树、图、二叉树、二叉搜索树


### 概念

    //树
    type Node struct {
        data  interface{}
        left  *Node
        right *Node
    }
    
    //二叉树
    type BinaryTree struct {
        root *Node
    }
    
    //二叉搜索树
    type BST struct {
        *BinaryTree
        compareFunc func( v,nodeV interface{} )int
    }
    
    type TreeNode struct{
        Val   int
        Left  *TreeNode
        Right *TreeNode
    }

    叶子节点 ： 没有子节点的节点
    
    
### 二叉树


```
graph TD
A((A root)) --> B
A --> C
B --> D{D}
B --> E{E}
C --> F{F}
C --> G{G}
```

##### 二叉树的遍历

    
    pre  前序遍历  根节点 左 右    A->B->D->E->C->F->G
    in   中序遍历  左 根节点 右    D->B->E->A->F->C->G
    post 后序遍历  左 右 根节点    D->E->B->F->G->C->A
    
##### 二叉搜索树


    1、左子树上所有的节点 都小于 根节点
    2、右子树上所有的节点 都大于 根节点

### 链表 树 图

    
    链表是一维的数据结构
    拥有两个或多个 next指针的 链表 就是树
    树结构中 有 环的 就是图

***

> 递归 通过函数体调用自身的 循环操作


##### 递归代码模板

    func recursion(level,params1,params2,...){
        
        if level > MAX_LEVEL {
            process_result
            return
        }

        process(level,data,...)

        recursion(level+1,p1,p2,...)

        // reverse the current level status if need
    }

***

> 分治 回溯   最近重复性问题



### divide/conquer 分而治之

    1、Divide 分解问题
    2、Conquer 组合子问题
    3、Merge 合并

##### 分治代码模板

    func divide_conquer(problem,params1,params2,...){
        //
        if problem is nil {
            print_result
            break
        }

        data := prepare_data(problem)
        subproblems := split_problem(problem,data)

        subresult1 := divide_conquer(subproblems[0],p1,...)
        subresult2 := divide_conquer(subproblems[1],p2,...)
        subresult3 := divide_conquer(subproblems[2],p3,...)

        result := process_result(subresult1,subresult2,subresult3,...)
    }
    
##### 应用

    利用分治算法求一组数据的逆序对个数
    二分法搜索
    排序（合并排序、快速排序）
    汉诺塔
    

### backtracking 回溯  深度优先搜索（Depth-First Search）


##### 回溯用来解决广义的搜索问题，也就是从一组可能的解中，选择出一个满足要求的解。


##### 应用


    深度优先搜索
    八皇后
    0-1背包问题