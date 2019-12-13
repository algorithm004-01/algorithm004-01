// 2. 二分搜索
// 此解法比较巧妙，作为扩展视野即可，关键还是要理解动态规划解法
// 将 nums 里的数据非为k堆，需要满足：
//   1. 每堆需要从大到小
//   2. 取 nums 里的一个新元素时，在已有的堆中找合适的放置位置，有的话放最左边的堆，如果没有开一个新的堆
public int lengthOfLIS(int[] nums) {
    // 存放每个堆的堆顶元素，会构成一个有序的数组
    int[] top = new int[nums.length];
    // 堆的数量
    int piles = 0;

    for (int item : nums) {
        // 在堆中找合适的放置位置
        // 在多个堆中应用二分查找：找第一个大于等于 item 的元素
        int lo = 0, hi = piles;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (top[mid] > item) {
                hi = mid;
            } else if (top[mid] < item) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        if (lo == piles) piles++;
        top[lo] = item;
    }

    return piles;
}
