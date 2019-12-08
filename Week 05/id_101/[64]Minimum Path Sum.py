#Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path. 
#
# Note: You can only move either down or right at any point in time. 
#
# Example: 
#
# 
#Input:
#[
#  [1,3,1],
#  [1,5,1],
#  [4,2,1]
#]
#Output: 7
#Explanation: Because the path 1→3→1→1→1 minimizes the sum.
# 
# Related Topics Array Dynamic Programming



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def minPathSum(self, dp):
        """
        :type dp: List[List[int]]
        :rtype: int
        """
        '''
        dp[i][j] is min sum till row i, col j
        dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
        
        use rolling array to reduce space complexity O(n)
        dp[j] = min(dp[j], dp[j-1]) + grid[i][j]
        ---OR---
        modify on original given input array to reduce space complexity to O(1)
        '''
        m, n = len(dp), len(dp[0])
        for i in range(m):
            for j in range(n):
                if i-1 >= 0 and j-1 >= 0:
                    dp[i][j] += min(dp[i-1][j], dp[i][j-1])
                elif i-1 >= 0:
                    dp[i][j] += dp[i-1][j]
                elif j-1 >= 0:
                    dp[i][j] += dp[i][j-1]
        return dp[m-1][n-1]

    def minPathSumII(self, grid):
        '''
        rolling array
        :type grid: List[List[int]]
        :rtype: int
        '''
        m, n = len(dp), len(dp[0])
        dp = [0] * n
        dp[0] = grid[0][0]
        for i in range(1, n):
            dp[i] = dp[i-1] + grid[0][i]

        for i in range(1, m):
            dp[0] += grid[i][0]
            for j in range(1, n):
                dp[j] = min(dp[j-1], dp[j]) + grid[i][j]
        return dp[-1]


        
#leetcode submit region end(Prohibit modification and deletion)
