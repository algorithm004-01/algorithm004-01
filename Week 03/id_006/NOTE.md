## 学习总结
### 本周学习收获
- 深度、广度优先搜索
- 贪心法：应用时需要能证明应用贪心法可以求的最优解，比如「兑换硬币」这个问题就无法使用贪心法求解
- 二分查找：基于有序、可通过索引直接访问的数据，可以利用二分法一次排除掉一半的备选项，加快搜索速度

### 代码技巧
- 二维数组坐标周围的八个节点偏移变换：new int[][]{{-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}}，可以利用当前坐标加上该二维数组中的偏移量来获得周边节点

### 二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
```java
public class FindNotOrderIndex {
    public int notOrderIndex(int[] data) {
        int lo = 0;
        int hi = data.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            // 中间元素大于最后一个元素，说明[mid, data.length)是有序的，排除掉
            if (data[mid] < data[data.length - 1]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        FindNotOrderIndex findNotOrderIndex = new FindNotOrderIndex();
        System.out.println(findNotOrderIndex.notOrderIndex(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
}
```
