class Solution:
    def numIslands(self, grid: list) -> int:
        def dfs(grid: list, i: int, j: int):
            if i < 0 or j < 0 or i >= len(grid) or j >= len(grid[0]) or grid[i][j] != '1':
                return
            grid[i][j] = '#'

            dfs(grid, i-1, j)
            dfs(grid, i+1, j)
            dfs(grid, i, j-1)
            dfs(grid, i, j+1)

        count = 0
        if grid:
            for i in range(len(grid)):
                for j in range(len(grid[i])):
                    if grid[i][j] == '1':
                        dfs(grid, i, j)
                        count += 1
        return count
