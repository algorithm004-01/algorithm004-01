# 学习总结
## 位运算
关于位运算的应用，起初是在HashMap的源码中学习到的。JDK开发大叔们为了提高性能，使用了2 ^ n作为容器的大小，利用位运算的特性在取模时，可以高效的完成计算。

## 布隆过滤器和LRU缓存
### 布隆过滤器
利用n次hash算法之后，在哈希桶中设置标志位。在缓存的使用场景中，用于判定一个数据在不在缓存中，假设哈希桶的标志位都为1，那么数据可能存在于缓存中，否则一定不在缓存中需要去DB中获取。

### LRU缓存
最近最少使用淘汰机制，利用链表来维护最近最少使用的特征，利用哈希表来达到O(1)复杂度的读取。在Java中，有一个现成的LRU实现类LinkedHashMap，override其removeEldestEntry方法设定淘汰条件即可。

## 排序
归并排序和快速排序都是利用分治思想来实现O(nlogn)的排序算法。
### 冒泡排序实现
```java
public class BubbleSort implements SortFunction {

//    @Override
//    public void sort(int[] data) {
//        for (int i = 0; i < data.length; i++) {
//            for (int j = 0; j < data.length - i - 1; j++) {
//                if (data[j] > data[j + 1]) {
//                    swap(data, j, j + 1);
//                }
//            }
//        }
//    }


    /**
     * 优化1，如果没有发生交换，说明所有数据都是有序状态，提前终止外层循环
     * @param data
     */
//    @Override
//    public void sort(int[] data) {
//        for (int i = 0; i < data.length; i++) {
//            boolean flag = false;
//            for (int j = 0; j < data.length - i - 1; j++) {
//                if (data[j] > data[j + 1]) {
//                    swap(data, j, j + 1);
//                    flag = true;
//                }
//            }
//            if (!flag) {
//                break;
//            }
//        }
//    }

    /**
     * 优化2，每次记录最后一次交换的位置，可以让内层循环提前结束
     * @param data
     */
    @Override
    public void sort(int[] data) {
        int lastExchange = 0;
        int k = data.length - 1;
        for (int i = 0; i < data.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < k; j++) {
                if (data[j] > data[j + 1]) {
                    SortUtils.swap(data, j, j + 1);
                    flag = true;
                    lastExchange = j;
                }
            }
            k = lastExchange;
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = SortUtils.generateRandomArray(10, 1, 10);
        System.out.println(Arrays.toString(data));
        SortUtils.testSort(data, new BubbleSort());
    }
}
```

### 插入排序
插入排序可以用于在小数据量时的排序，其效率甚至高于快速排序和归并排序。
```java
package com.mrglint.algorithm.sort;

import java.util.Arrays;

/**
 * @author luhuancheng
 * @since 2019-11-30 10:19
 */
public class InsertSort implements SortFunction {

//    @Override
//    public void sort(int[] data) {
//        // i表示要插入的元素
//        for (int i = 1; i < data.length; i++) {
//            int insertValue = data[i];
//            int j;
//            // j表示第一个要比较的元素
//            for (j = i - 1; j >= 0; j--) {
//                if (insertValue < data[j]) {
//                    data[j + 1] = data[j];
//                } else {
//                    break;
//                }
//            }
//            // 此时分两种情况：
//            // 1. j < 0 说明前面没有元素可以比较了，data[0] = insertValue;
//            // 2. data[j] <= insertValue 说明此时的data[j]在正确的位置，data[j + 1] 就是要插入的位置
//            data[j + 1] = insertValue;
//        }
//    }

    @Override
    public void sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            // 要插入的位置
            int insertIndex;
            // 要插入的值
            int insertValue = data[i];
            // 当前一个元素大于要插入的值时，将前一个元素后移一个位置
            for (insertIndex = i; insertIndex > 0 && data[insertIndex - 1] > insertValue; insertIndex--) {
                data[insertIndex] = data[insertIndex - 1];
            }
            // 移动到第一个元素时、或者 data[insertIndex - 1] <= insertValue, 要插入的位置找到
            data[insertIndex] = insertValue;
        }
    }

    public static void main(String[] args) {
        int[] data = SortUtils.generateNearlyOrderArray(10000, 100);
        SortUtils.compareSort(data, Arrays.asList(new SelectSort(), new InsertSort()));
    }
}

```

### 选择排序
```java
package com.mrglint.algorithm.sort;

/**
 * @author luhuancheng
 * @since 2019-11-29 22:46
 */
public class SelectSort implements SortFunction {

    @Override
    public void sort(int[] data) {

        for (int i = 0; i < data.length; i++) {
            // 寻找[i, data.length)中的最小值索引位置；初始化为i
            int minIndex = i;
            // 从[i + 1, data.length)中寻找最小值索引位置
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        // 1w : 51ms
        // 10w : 4541ms
        // O(n ^ 2)
        int[] data = SortUtils.generateRandomArray(100000, 1, 100000);
        SortUtils.testSort(data, new SelectSort());
    }
}

```
