# 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
#
# 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
#
# 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
#
# 
#
# 网格中的障碍物和空位置分别用 1 和 0 来表示。 
#
# 说明：m 和 n 的值均不超过 100。 
#
# 示例 1: 
#
# 输入:
# [
#   [0,0,0],
#   [0,1,0],
#   [0,0,0]
# ]
# 输出: 2
# 解释:
# 3x3 网格的正中间有一个障碍物。
# 从左上角到右下角一共有 2 条不同的路径：
# 1. 向右 -> 向右 -> 向下 -> 向下
# 2. 向下 -> 向下 -> 向右 -> 向右
# 
# Related Topics 数组 动态规划

"""
1 递归 超时
2 dp
https://leetcode.com/problems/unique-paths-ii/discuss/23410/Python-different-solutions-(O(m*n)-O(n)-in-place).
"""


class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        m, n = len(obstacleGrid) - 1, len(obstacleGrid[0]) - 1
        return self.DFS(obstacleGrid, m, n)

    def DFS(self, obstacleGrid, m, n):
        if m == 0 and n == 0:
            return 1 - obstacleGrid[0][0]
        # * 和 and 效果一样
        if m == 0:
            return self.DFS(obstacleGrid, m, n - 1) * (1 - obstacleGrid[0][n])
        if n == 0:
            return self.DFS(obstacleGrid, m - 1, n) and 1 - obstacleGrid[m][0]

        return (self.DFS(obstacleGrid, m - 1, n) + self.DFS(obstacleGrid, m, n - 1)) * (1 - obstacleGrid[m][n])


class Solution2(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        if not obstacleGrid:
            return 0
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        dp = [[0 for _ in range(n)] for _ in range(m)]
        # dp = [[0] * n for _ in range(m)]
        dp[0][0] = 1 - obstacleGrid[0][0]

        for i in range(1, m):
            dp[i][0] = dp[i - 1][0] * (1 - obstacleGrid[i][0])
        for j in range(1, n):
            dp[0][j] = dp[0][j - 1] * (1 - obstacleGrid[0][j])

        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) * (1 - obstacleGrid[i][j])

        return dp[-1][-1]
