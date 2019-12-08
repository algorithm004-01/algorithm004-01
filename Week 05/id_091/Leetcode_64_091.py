class Solution:
    def minPathSum(self, grid: [[int]]) -> int:
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if i == j == 0:
                    continue
                elif i == 0:
                    grid[i][j] = grid[i][j - 1] + grid[i][j]
                elif j == 0:
                    grid[i][j] = grid[i - 1][j] + grid[i][j]
                else:
                    grid[i][j] = min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j]
        return grid[-1][-1]


def minPathSum(dp):
    """
        1. dp问题: dp[i][j] += min(dp[i-1][j], dp[i][j-1])
    """
    m, n = len(dp), len(dp[0])
    for i in range(m):
        for j in range(n):
            if i - 1 >= 0 and j - 1 >= 0:
                dp[i][j] += min(dp[i - 1][j], dp[i][j - 1])
            elif i - 1 >= 0:
                dp[i][j] += dp[i - 1][j]
            elif j - 1 >= 0:
                dp[i][j] += dp[i][j - 1]

    return dp[m - 1][n - 1]


print(minPathSum([[1, 3, 1], [1, 5, 1], [4, 2, 1]]))
