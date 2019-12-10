'''
number of islands_200

给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

示例 1:
输入:
11110
11010
11000
00000

输出: 1

示例 2:
输入:
11000
11000
00100
00011

输出: 3
'''

#dfs

from typing import List

class Solution:
    directions = [(-1,0), (0,-1), (1,0), (0,1)]

    def numIslands(self, grid):
        m = len(grid)
        if m == 0: return 0
        n = len(grid[0])
        marked = [[False for _ in range(n)] for _ in range(m)]
        count = 0

        for i in range(m):
            for j in range(n):
                if not marked[i][j] and grid[i][j] == '1':
                    count += 1
                    self.__dfs(grid, i, j, m, n, marked)
        return count

    def __dfs(self,grid, i, j, m, n, marked):
        marked[i][j] = True
        for directions in self.directions:
            new_i = i + directions[0]
            new_j = j + directions[1]
            if 0 <= new_i < m and 0 <= new_j < n and not marked[new_i][new_j] and grid[new_i][new_j] == '1':
                self.__dfs(grid, new_i, new_j, m, n, marked)

grid =   [['1', '1', '1', '0', '0'],
            ['1', '1', '0', '1', '0'],
            ['1', '1', '0', '0', '0'],
            ['0', '0', '0', '0', '1']]

solution = Solution()
result = solution.numIslands(grid)
print(result)


#bfs
from typing import List
from collections import deque

class Solution:
    directions = [(-1,0), (0,-1), (1,0), (0,1)]

    def numIslands(self, grid):
        m = len(grid)
        if m == 0: return 0
        n = len(grid[0])
        marked = [[False for _ in range(n)] for _ in range(m)]
        count = 0

        for i in range(m):
            for j in range(n):
                if not marked[i][j] and grid[i][j] == '1':
                    count += 1
                    queue = deque()
                    queue.append((i,j))
                    marked[i][j] = True
                    while queue:
                        cur_x, cur_y = queue.popleft()
                        for direction in self.directions:
                            new_i = cur_x + direction[0]
                            new_j = cur_y + direction[1]
                            if 0 <= new_i < m and 0 <= new_j < n and not marked[new_i][new_j] and grid[new_i][new_j] == '1':
                                queue.append((new_i, new_j))
                                marked[new_i][new_j] = True
        return count

grid =   [['1', '1', '1', '0', '0'],
            ['1', '1', '0', '1', '0'],
            ['1', '1', '0', '0', '0'],
            ['0', '0', '0', '0', '1']]

solution = Solution()
result = solution.numIslands(grid)
print(result)


