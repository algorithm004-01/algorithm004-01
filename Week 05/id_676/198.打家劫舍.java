/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

 /*
 *思路：动态规划：
 *分治（分解为子问题）
 *状态数组：a[i] 0...i 能偷到的max value a[n-1]，但是这样不能表示这个房子偷与不偷得状态，所以可以加一维来表示此状态，a[i][0,1] 0:表示不偷，1:表示偷
 *DP方程 a[i][0] = Max(a[i - 1][0],a[i - 1][1])  a[i][1] = a[i - 1][0] + nums[i]
 *简化状态定义
 *a[i] 0...i 且第i天必偷得max value  max(a)
 *DP方程：a[i] = max(a[i - 1] , a[i - 2] + nums[i]);
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0]; 
        for (int i = 1;i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
// @lc code=end

class SolutionOne {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0]; 
        dp[1] = Math.max(nums[0], nums[1]);
        int max = Math.max(dp[0], dp[1]);
        for (int i = 2;i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

//方法同one，只是每一步只需要前两个状态值，所以可以只用两个变量，不用另开数组
class SolutionTwo{
    public int rob(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}