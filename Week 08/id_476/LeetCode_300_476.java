public class LeetCode_300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LeetCode_300_LongestIncreasingSubsequence().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int lengthOfLIS(int[] nums) {

            if (nums == null || nums.length == 0) return 0;

            // 蜘蛛纸牌
            // 牌堆数
            int cols = 0;
            // dp[i] 存放的是每个牌堆最后一张牌的数字
            int[] dp = new int[nums.length];
            for (int num : nums) {
                // 判断当前牌应该放在哪个牌堆
                int left = 0; int right = cols;
                while (left < right) {
                    // 左中位数
                    int mid = left + (right - left) / 2;
                    if (dp[mid] < num) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                // 未找到合适的牌堆，则新增一堆
                if (left == cols) cols++;
                // 将该牌放到找到的牌堆；如果没找到，由于初始时，最后一堆是空的，因此也只需放到最后一堆（left）即可
                dp[left] = num;

            }
            return cols;
        }
    }
    class Solution1 {
        public int lengthOfLIS(int[] nums) {

            if (nums == null || nums.length == 0) return 0;

            int max = 0;
            // dp[i] 代表位置 i 处的最长升序子串长度
            int[] dp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                dp[i] = 1;
            }
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}