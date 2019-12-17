package medium;

/**
 * @author 潘磊明
 * @date 2019/12/9
 */
public class LongestIncreasingSubsequence {
    /**
     * 时间复杂度：O(n^2)
     * @param nums
     * @return
     */
//    public int lengthOfLIS(int[] nums) {
//        if (nums.length == 0) return 0;
//        int[] dp = new int[nums.length];
//        dp[0] = 1;
//        int max = 1;
//        for (int i = 1; i < nums.length; i++) {
//            int maxval = 0;
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j]) {
//                    maxval = Math.max(maxval, dp[j]);
//                }
//            }
//            dp[i] = maxval + 1;
//            max = Math.max(max, dp[i]);
//        }
//        return max;
//    }

    /**
     * 动态递归 + 二分查找
     * 时间复杂度：O(nlogn)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 1) { return 0; }
        int[] tails = new int[nums.length];
        tails[0] = nums[0]; //init
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tails[end]) {
                end++;
                tails[end] = nums[i];
            } else {
                int left = 0;
                int right = end;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (tails[mid] > nums[i]) right = mid;
                    else if (tails[mid] < nums[i]) left = mid + 1;
                    else {left = mid; break;}
                }
                tails[left] = nums[i];
            }
        }
        return end + 1;
    }
}
