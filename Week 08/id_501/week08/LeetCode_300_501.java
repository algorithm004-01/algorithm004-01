package homework.week08;

/**
 * 300. 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence
 * @author: sintang
 * @date: 2019-12-08
 */
public class LeetCode_300_501 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxResult = 1;
        for (int i = 0; i < dp.length; i++) {
            int maxVal = 0;
            for(int j = 0;j<i;j++){
                if(nums[i] > nums[j]){
                    maxVal = Math.max(maxVal,dp[j]);
                }
            }
            dp[i] = maxVal + 1;
            maxResult = Math.max(maxResult,dp[i]);
        }
        return maxResult;
    }
}
