/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (49.00%)
 * Likes:    1762
 * Dislikes: 45
 * Total Accepted:    276.9K
 * Total Submissions: 560.6K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 *  [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = grid.clone();
        for(int i=1;i<grid.length;++i){
            dp[i][0] += dp[i-1][0];
        }
        for(int j=1;j<grid[0].length;++j){
            dp[0][j] += dp[0][j-1];
        }
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[i].length;j++){
                dp[i][j] += Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
// @lc code=end
/**
 * 最短路径
 * 1 子问题 
 * 2 状态表述dp[i][j]
 * 3 状态转移方程 dp[][]
 * 当只有横向或者纵向路径的时候
 * dp[i][0] += dp[i-1][0]
 * dp[0][j] += dp[0][j-1]
 * 状态转移方程
 * dp[i][j] += Math.max(dp[i-1][j],dp[i][j-1])
 */
