# DFS 深度优先 只要可以往下查就往下查
from typing import List
from collections import deque

class Solution:
    # 方向数组
    directions=[(-1,0),(0,-1),(1,0),(0,1)]
    
    def numIslands(self, grid: List[List[str]]) -> int:
        # grid的高度
        m = len(grid) 
        
        if m==0:
            return 0
        # grid的宽度
        n=len(grid[0])
        # 初始化一个全是False的数组，用以标记遍历过的节点
        marked = [[False for _ in range(n)] for _ in range(m)]
        
        count = 0
        
        for i in range(m):
            for j in range(n):
                # 没有遍历过，且是岛屿
                if not marked[i][j] and grid[i][j] == '1':
                    count += 1
                    self.__dfs(grid, i, j, m, n, marked)
  
        return count

    def __dfs(self, grid, i, j, m, n, marked):
        marked[i][j] = True
        for direction in self.directions:
            new_i = i + direction[0]
            new_j = j + direction[1]
            # 没有过界 没有遍历过 且是岛屿
            if 0 <= new_i < m and 0 <= new_j < n and not marked[new_i][new_j] and grid[new_i][new_j] == '1':
                self.__dfs(grid, new_i, new_j, m, n, marked)
    # 广度优先算法,围绕某个节点只深入一层 数组是待遍历的节点       
    def numIslands(self,grid:List[List[str]]) -> int:
        m = len(grid)
        if m == 0:
            return 0
        n=len(grid[0])
        marked = [[False for _ in range(n)] for _ in range(m)]
        count = 0
        # 从第 1 行、第 1 格开始，对每一格尝试进行一次 DFS 操作
        for i in range(m):
            for j in range(n):
                # 只要是陆地，且没有被访问过的，就可以使用 BFS 发现与之相连的陆地，并进行标记
                if not marked[i][j] and grid[i][j] == '1':
                    # count 可以理解为连通分量，你可以在广度优先遍历完成以后，再计数，
                    count += 1
                    queue = deque()
                    queue.append((i, j))
                    # 标记上已经访问过
                    marked[i][j] = True
                    while queue:
                        cur_x, cur_y = queue.popleft()
                        # 得到 4 个方向的坐标
                        for direction in self.directions:
                            new_i = cur_x + direction[0]
                            new_j = cur_y + direction[1]
                            # 如果不越界、没有被访问过、并且还要是陆地，我就继续放入队列，放入队列的同时，要记得标记已经访问过
                            if 0 <= new_i < m and 0 <= new_j < n and not marked[new_i][new_j] and grid[new_i][new_j] == '1':
                                queue.append((new_i, new_j))
                                # 在放入队列以后，要马上标记成已经访问过
                                marked[new_i][new_j] = True
        return count