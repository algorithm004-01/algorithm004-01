# NOTE

## 数组

数组中的每项属于泛型单元，可以放入任意 type 的元素。计算机内部分配地址段，使用内存管理器访问元素。

| method    | big O |
| --------- | ----- |
| preappend | O(1)  |
| append    | O(1)  |
| lookup    | O(1)  |
| insert    | O(n)  |
| delete    | O(n)  |

### 例题

#### 1. move zeros

一级数组，利用坐标变换

#### 2. contain most water

双指针，从左右边界向中间收敛

#### 3. 爬楼梯

找出重复单元

#### 4. 3 sum

双指针，排序数组，左右下标向中间移动。与#2 相似。

## 链表

| method    | big O |
| --------- | ----- |
| preappend | O(1)  |
| append    | O(1)  |
| delete    | O(1)  |
| insert    | O(1)  |
| lookup    | O(n)  |

## 跳表

目的：提高链表 lookup 效率

优化思想：

1. 空间换时间
2. 升维

建立多级索引，在 k 级建立 $\frac{n}{2^{k}}$ 个结点，利用索引进行 lookup。
