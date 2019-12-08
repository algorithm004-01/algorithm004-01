## 第二周学习总结

### 1.Hash Table
#### 1.1 哈希碰撞解决
  - 拉链式解决冲突   => 链表(或退化为O(n)的时间复杂度)
  

> 应用：ST BOOST 区块链

> 平均查询O(1)  

#### 1.2 JavaScript中的Hash Map
> JavaScript 的对象（Object），本质上是键值对的集合（Hash 结构），但是传统上只能用字符串当作键。这给它的使用带来了很大的限制。
>为了解决这个问题，ES6 提供了 Map 数据结构。
- [es6中Set 和 Map的使用](http://es6.ruanyifeng.com/#docs/set-map)
- javascript中hashMap应用，以two sum题为例 
``` 
var twoSum = function(nums, target) {
    let map = new Map();
    for (let i = 0; i < nums.length; i++) {
        let complement = target - nums[i];
        if (map.has(complement)) {
            return [map.get(complement), i];
        }
        map.set(nums[i], i);
    }
    throw new Error("No two sum solution");
};
```
---

### 2.树
#### 2.1树 是没有环的图
链表->树->图
- 生活中的树：
    - alpha go  
    - 下棋 
    - 人生状态 
    - 游戏发展 科技树

#### 2.2 树的面试题解法一般都是递归，为什么？

- [递归的概念-知乎](https://www.zhihu.com/question/20507130)

![Image text](https://pic3.zhimg.com/80/1f818b686dc5482cbb8343d8caf65dac_hd.jpg)
- 树本身是没有后继，本身的数据结构决定
- 注意：递归不一定会影响效率

#### 2.3 树的常见操作
- 查询
log2n 类似于二分查找
- 删除
 在叶子上直接删除 在其他位置的必须找到替换节点

- 遍历

  - preorder traversal 先序遍历
根左右

  - inorder traversal 中序遍历
左根右

  - postorder traversal 后续遍历
左右根



### 3 递归
#### 3.1 范型递归 树的递归
- 不要人肉递归
- 找到最近最简单方法，将其拆解成可重复解决的问题（重复子问题）
- 数学归纳法思维

     [递归代码模板](https://shimo.im/docs/DjqqGCT3xqDYwPyY/read)
  
#### 3.2 复杂递归： 分治 回溯
-重复性：
    - 最近重复性（分治、回溯）
    - 最优重复性 （动态规划）
    
   [分治代码模板](https://shimo.im/docs/3xvghYh3JJPKwdvt/read)
    
   [括号生成问题](https://leetcode-cn.com/problems/generate-parentheses/)


