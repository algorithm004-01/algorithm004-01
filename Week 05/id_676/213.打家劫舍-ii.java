import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

/*
*思路：动态规划DP
*分治（分解成子问题）
*状态数组：a[i][0,1] 0代表不偷，1代表偷 max value a[i - 1]
*DP方程：a[i][0] = Max(a[i - 1][1],a[i - 1][0])    a[i][1] = a[i - 1][0] + nums[i]
*该问题同198题，区别在于房屋是环状的，需要将问题分解为2种情况：第一个房屋不偷（2~n） 第一个房屋偷（1~n-1）
*简化状态为一维
*a[i] 0....i且第i家一定偷 max value max(a)
*a[i] = Max(a[i - 1],a[i - 2] + nums[i]) 
*/

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)  return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return nums[0] > nums[1]? nums[0] : nums[1];
        int len = nums.length;
        return Math.max(helper(0, len - 2, nums),helper(1, len - 1, nums));
    }

    private int helper(int start, int end, int[] nums) {
        int[] newNums = Arrays.copyOfRange(nums, start, end + 1);   //将数组从start ~ end拷贝到新数组中
        int[][] dp = new int[newNums.length][2];
        dp[0][0] = 0;
        dp[0][1] = newNums[0];
        for (int i = 1; i < newNums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + newNums[i];
        }
        return Math.max(dp[newNums.length - 1][0], dp[newNums.length - 1][1]);
    }
}
// @lc code=end

class SolutionOne {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)  return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return nums[0] > nums[1]? nums[0] : nums[1];
        int len = nums.length;
        return Math.max(helper(0, len - 2, nums),helper(1, len - 1, nums));
    }

    private int helper(int start, int end, int[] nums) {
        int[] newNums = Arrays.copyOfRange(nums,start, end + 1);
        int[] dp = new int[newNums.length];
        dp[0]= newNums[0];
        dp[1] = Math.max(newNums[0], newNums[1]);
        int max = Math.max(dp[0],dp[1]);
        for (int i = 2; i < newNums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + newNums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

class SolutionTwo {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)  return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return nums[0] > nums[1]? nums[0] : nums[1];
        int len = nums.length;
        return Math.max(helper(0, len - 2, nums),helper(1, len - 1, nums));
    }
        public int helper(int start, int end, int[] nums) {
            int[] newNums = Arrays.copyOfRange(nums, start, end + 1);
            int prevMax = 0;
            int currMax = 0;
            for (int x : newNums) {
                int temp = currMax;
                currMax = Math.max(prevMax + x, currMax);
                prevMax = temp;
            }
            return currMax;
        }
}