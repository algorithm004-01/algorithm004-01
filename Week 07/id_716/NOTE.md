# NOTE

## 题目

- <https://leetcode-cn.com/problems/number-of-1-bits/>
- <https://leetcode-cn.com/problems/power-of-two/>
- <https://leetcode-cn.com/problems/reverse-bits/>
- <https://leetcode-cn.com/problems/n-queens/description/>
- <https://leetcode-cn.com/problems/n-queens-ii/description/>
- <https://leetcode-cn.com/problems/counting-bits/description/>
- <https://leetcode-cn.com/problems/relative-sort-array/>
- <https://leetcode-cn.com/problems/valid-anagram/>
- <https://leetcode-cn.com/problems/design-a-leaderboard/>
- <https://leetcode-cn.com/problems/merge-intervals/>
- <https://leetcode-cn.com/problems/reverse-pairs/>

## 总结：各大经典排序算法分析及实现

本周是训练营的第 7 周，主要对排序算法做些总结，理清楚排序算法的分析、代码实现和工业级排序算法需要考虑的指标，甚至于可以分析一下 java（或者 golang）中排序算法是如何实现的。

排序在日常开发中经常用到，而往往我们都是使用库函数中的排序函数，大部分人可能不知道它的具体实现是如何的，它的效率怎么样，什么数据量的情况下它会有好的表现，什么数据量下它会变的更糟，它会占用多大的额外空间，比较或者移动数据的次数是多少等等。

### 如何分析一个排序算法

想要知道一个排序算法是否适合应用场景，就需要知道如何分析和评价一个排序算法。可以从以下几点进行考察：

- 复杂度分析（包括时间和空间）

需要同时考虑时间复杂度和空间复杂度，对与时间复杂度要从至少三个维度进行分析：最好、最坏和平均复杂度分析，以及各自情况下对应的数据特点是怎么样的。因为不同有序度的数据，对排序算法的性能表现是有影响的。比如冒泡排序，在接近有序的数据下，可能会提前结束循环，复杂度可能会接近 O(n)

- 考虑在特定数据规模下的细粒度分析，把复杂度的常数项、系数、阶数也做分析

实际的软件开发中，我们排序的可能是 10 个、100 个、1000 个这样规模很小的数据，所以，在对同一阶时间复杂度的排序算法性能对比的时候，我们就要把系数、常数、低阶也考虑进来

- 是否是原地排序算法（原地排序说明是否会使用很多的额外空间）
- 是否是稳定的排序算法（稳定排序说明如果待排序的序列中存在值相等的元素，经过排序之后，相等元素之间原有的先后顺序不变）
- 排序过程中比较、交换/移动数据的次数

### 常见的排序算法

常见的排序算法有：

1. 初级：冒泡排序、选择排序、插入排序、希尔排序
2. 高级：快速排序、归并排序、堆排序
3. 特殊：计数排序、桶排序、基数排序

- 冒泡排序 Bubble Sort

```java
public class BubbleSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (arr.length <= 1) return;

        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;  // 标识概论次的标中是否有数据交换
            for (int j = 0; j < arr.length - i - 1; j++) {  // 边界 arr.length - i - 1
                if (arr[j] > arr[j + 1]) {  // 大数往后移动
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    flag = true;
                }
            }
            // flag 还是 false 的话，说明没有数据交换，表明已经有序，就退出
            if (!flag) break;
        }
    }
}
```

冒泡排序的核心思想是每一轮的比较，找到一个最大的值放在数组的后面，总共需要进行 `arr.length` 的轮次。重点有两个：

1. 冒泡排序有可能是可以提前终止的，在每次比较时后一个数较小的话，就会做一次交换，如果在轮次没结束之前，且没有进行数据交换，那么就说明数组已经完全有序，就可以直接退出了
2. 比较的条件和范围，条件是 `arr[j]` 大于 `arr[j + 1]`, j 的范围是从 `0` 到 `arr.length - i - 1`, 因为最后的 `i + 1` 个数已经有序了

以上两点是写冒泡排序需要注意的。

分析：最好情况时间复杂度是 O(n), 最坏是 O(n^2), 平均是 O(n^2), 是原地排序算法，空间复杂度 O(1), 是稳定的排序算法。

- 插入排序

```java
```

- 希尔排序
- 选择排序
- 快速排序
- 归并排序
- 堆排序

Java 中的排序函数
Golang 中的排序函数
