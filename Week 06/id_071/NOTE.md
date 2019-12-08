# NOTE

> Trie & UnionFind

##### Trie 单词查找树 或 键树 树形结构 空间换时间

    典型应用是用于统计和排序大量的字符串，用于文本词频统计
    优点是：最大限度的减少无谓的字符串比较，查询效率比哈希表高
    

```
graph TD
/-->|B| B
/-->|S| S
B-->|C|BC
B-->|D|BD
BC-->|E|BCE
BD-->|F|BDF
S-->|H|SH
S-->|E|SE
SH-->|E|SHE
```


    二叉树的层次遍历 dfs bfs(水波纹)
    二叉搜索树 子树的关系  升序序列
    
##### Unionfind  disjoint set 

    makeSet(s)

    unionSet(x,y)

    find(x)

****


> Search

##### 初级搜索

    1. 朴素搜索
    2. 优化方式 不重复(fabonacci) 剪枝(生成括号问题)
    3. 搜索方向  

        DFS(depth)    递归 / 先入先出的 栈
        BFS(breadth)  先入后出的 队列 

##### 高级搜索

    剪枝
        爬楼梯 => fib 
        括号生成 (DP)
        

    双向搜索
    

    启发式搜索 A*算法 优先队列
    
    

****

> AVL Tree & Red black Tree

    Tree
    Binary search Tree
    AVL tree
    Red black tree
    B+ tree
    
##### 保证性能

    保证二维维度 => 左右子树结点平衡
    平衡二叉树 balanced
    
##### AVL Tree 平衡二叉搜索树

    引入平衡因子( 左子树的高度 减去 它的右子树的高度 ) balance factor = {-1, 0, 1}
    通过旋转操作
        左旋
        右旋
        左右旋
        右左旋
        
    不足：结点需要存储额外信息，且调整次数频繁
    
##### Red Black Tree 近似平衡的二叉搜索树

    确保任何一个结点的 左右子树的高度差 小于 两倍
    

    1.每个结点要么红色，要么黑色
    2.根节点是黑色
    3.每个叶结点(nil结点 空结点) 是黑色的
    4.不能有相邻的两个红色结点
    5.从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点
    
    

对比 | AVL Tree | Red Black Tree 
---|---|---
lookups | faster | 
insert  |        | faster
removal |        | faster


