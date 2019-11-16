# 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
#
# 说明：每次只能向下或者向右移动一步。 
#
# 示例: 
#
# 输入:
# [
#   [1,3,1],
#  [1,5,1],
#  [4,2,1]
# ]
# 输出: 7
# 解释: 因为路径 1→3→1→1→1 的总和最小。
# 
# Related Topics 数组 动态规划

"""
1、 暴力递归 超时
2、 DP O(m*n) 额外空间O(m*n)
3、 DP 优化 O(m*n) 不使用额外空间
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m, n = len(grid) - 1, len(grid[0]) - 1
        return self.calculate(grid, m, n)

    def calculate(self, grid, m, n):
        if m == 0:
            return sum(grid[0][:n + 1])
        if n == 0:
            return sum([i[0] for i in grid[:m + 1]])
        return grid[m][n] + min(self.calculate(grid, m - 1, n), self.calculate(grid, m, n - 1))


class Solution2(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        """
        DP:
        a. 重复性 problem(i, j) = grid(i,j) + min(sub(i - 1, j),sub(i, j - 1))
        b. 定义状态数组 f[i, j]
        c. DP方程 dp[i, j] = grid[i,j] + min(dp[i - 1, j],dp[i, j - 1])
        """
        m, n = len(grid), len(grid[0])
        dp = [[0 for _ in range(n)] for _ in range(m)]
        for i in range(1, n):
            dp[0][i] = dp[0][i - 1] + grid[0][i]
        for i in range(1, m):
            dp[i][0] = dp[i - 1][0] + grid[i][0]
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
        return dp[-1][-1]


class Solution3(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m, n = len(grid), len(grid[0])
        for i in range(1, n):
            grid[0][i] += grid[0][i - 1]
        for i in range(1, m):
            grid[i][0] += grid[i - 1][0]
        for i in range(1, m):
            for j in range(1, n):
                grid[i][j] += min(grid[i - 1][j], grid[i][j - 1])
        return grid[-1][-1]
