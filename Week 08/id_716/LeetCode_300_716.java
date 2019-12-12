import java.util.Arrays;

public class LeetCode_300_716 {
    // dp
    public int lengthOfLIS1(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        
        int maxLIS = 1;
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLIS = Math.max(maxLIS, dp[i]);
                }
            }
        }
        
        return maxLIS;
    }
    
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
}