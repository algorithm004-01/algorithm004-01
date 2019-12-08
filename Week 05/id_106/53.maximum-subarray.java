import java.util.Arrays;

/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (44.79%)
 * Likes:    5466
 * Dislikes: 227
 * Total Accepted:    682.8K
 * Total Submissions: 1.5M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = nums.clone();//deep copy
        for(int i=1; i< nums.length;++i){
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
        }
        Arrays.sort(dp);
        return dp[dp.length - 1];
    }
}
// @lc code=end
/**
 * dp
 * 1 子问题 从后到前，取到现在位置最大的和与当前数字的最大值
 * 2 状态数组定义 sum[i]
 * 3 递推方程 sum[i] = Max(sum[i-1]+nums[i], nums[i]) 
 * 
 * 因为如果当前数字前面所有数的和加上当前数后反而更小，说明前面包含负数，如此相当去滑动滤波器窗口将整个数组遍历一遍，并将和存到新数组中，最后取该新数组中最大的数即可
 */
