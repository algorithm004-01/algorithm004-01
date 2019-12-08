
# leetcode 64 最小路径和

# 通过逆推得到最小路径

class Solution:
    def minPathSum(self, grid) -> int:
        x, y = len(grid)-1, len(grid[0])-1
        for i in range(x, -1, -1):
            for j in range(y, -1, -1):
                if i == x and j == y:
                    pass
                elif i == x and j < y:
                    grid[i][j] = grid[i][j] + grid[i][j+1]
                elif i < x and j == y:
                    grid[i][j] = grid[i][j] + grid[i+1][j]
                else:
                    grid[i][j] = grid[i][j] + min(grid[i+1][j], grid[i][j+1])
        return grid[0][0]
