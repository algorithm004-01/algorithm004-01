#Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water. 
#
# Example 1: 
#
# 
#Input:
#11110
#11010
#11000
#00000
#
#Output: 1
# 
#
# Example 2: 
#
# 
#Input:
#11000
#11000
#00100
#00011
#
#Output: 3
# Related Topics Depth-first Search Breadth-first Search Union Find



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]

    def numIslands(self, grid):
        m = len(grid)
        if m == 0:
            return 0
        n = len(grid[0])
        marked = [[False for _ in range(n)] for _ in range(m)]
        count = 0
        for i in range(m):
            for j in range(n):
                if not marked[i][j] and grid[i][j] == '1':
                    count += 1
                    self._dfs(grid, i, j, m, n, marked)

        return count

    def _dfs(self, grid, i, j, m, n, marked):
        marked[i][j] = True
        for k in range(4):
            ni = i + self.dx[k]
            nj = j + self.dy[k]
            if 0 <= ni < m and 0 <= nj < n and not marked[ni][nj] and grid[ni][nj] == '1':
                marked[ni][nj] = True
                self._dfs(grid, ni, nj, m, n, marked)


        
#leetcode submit region end(Prohibit modification and deletion)
