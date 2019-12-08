"""
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
"""

class Solution(object):
    # x,y轴的正负方向
    directions = [(-1, 0), (0,-1), (1, 0), (0, 1)]

    # TODO 方法一： DFS
    def numIslands(self, grid):
        m = len(grid)
        if m == 0:
            return 0
        n = len(grid[0])
        marked = [[False for _ in range(n)] for _ in range(m)]
        count = 0
        for i in range(m):
            for j in range(n):
                # 只要是陆地，且没有被访问过的，就用DFS发现与之相连的陆地，并进行标记
                if not marked[i][j] and grid[i][j] == '1':
                    count += 1
                    self.dfs(grid, i, j, m, n, marked)
        return count
    
    def dfs(self, grid, i, j, m, n marked):
        marked[i][j] = True
        for direction in self.directions:
            new_i = i + direction[0]
            new_j = j + direction[1]
            if 0 <= new_i < m and 0 <= new_j < n and
                not marked[new_i][new_j] and grid[new_i][new_j] == '1':
                self.dfs(grid, new_i, new_j, m, n, marked)

    # TODO 方法二： BFS
    def numIsland(self, grid):
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

    # TODO 方法三： 并查集
    def numIslands(self, grid):
        class UnionFind(object):
            def __init__(self, n):
                self.count = n
                self.parent = [i for i in range(n)]
                self.rank = [1 for _ in range(n)]
            def get_count(self):
                return self.count
            def find(self,p):
                while p != self.parent[p]:
                    self.parent[p] = self.parent[self.parent[p]]
                    p = self.parent[p]
                return p

            def is_connected(self,p,q):
                return self.find(p) == self.find(q)

            def union(self, p, q):
                p_root = self.find(p)
                q_root = self.find(q)
                if p_root == q_root:
                    return
                if self.rank[p_root] > self.rank[q_root]:
                    self.parent[q_root] = p_root
                elif self.rank[p_root] < self.rank[q_root]:
                    self.parent[p_root] = q_root
                else:
                    self.parent[q_root] = p_root
                    self.rank[p_root] += 1
                self.count -= 1
        row = len(grid)
        if row == 0:
            return 0
        col = len(grid[0])

        def get_index(x, y):
            return x*col + y
        
        directions = [(1, 0), (0, 1)]
        dummy_node = row * col
        # 虚拟空间
        uf = UnionFind(dummy_node + 1)
        for i in range(row):
            for j in range(col):
                # 如果是水， 都连到虚拟空间
                if grid[i][j] == '0':
                    uf.union(get_index(i, j), dummy_node)
                if grid[i][j] == '1':
                    # 向下向右 是陆地就合并
                    for direction in directions:
                        new_x = i + direction[0]
                        new_y = j + direction[1]
                        if new_x < row and new_y < col and grid[new_x][new_y] == '1':
                            uf.union(get_index(i, j), get_index(new_x, new_y))
        return uf.get_count() - 1