'''
number-of-islands_200

给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

示例 1:

输入:
11110
11010
11000
00000

输出: 1
'''

#并查集

def numIslands_1(grid):
    f = {}

    def find(x):
        f.setdefault(x,x)
        if f[x] != x:
            f[x] = find(f[x])
        return f[x]

    def union(x,y):
        f[find(x)] = find(y)

    if not grid: return 0
    row = len(grid)
    col = len(grid[0])

    for i in range(row):
        for j in range(col):
            if grid[i][j] == '1':
                for x, y in [[-1,0], [0,-1]]:
                    tmp_i = i + x
                    tmp_j = j + y
                    if 0 <= tmp_i < row and 0 <= tmp_j < col and \
                        grid[tmp_i][tmp_j] == '1':
                            union(tmp_i*row+tmp_j, i*row+j)
    res = set()
    for i in range(row):
        for j in range(col):
            if grid[i][j] == '1':
                res.add(find((i*row + j)))

#dfs
def numIslands_2(grid):
    if not grid: return 0
    row = len(grid)
    col = len(grid[0])
    cnt = 0

    def dfs(i,j):
        grid[i][j] = '0'
        for x, y in [[-1,0], [1,0], [0,-1],[0,1]]:
            tmp_i = i + x
            tmp_j = j + y
            if 0 <= tmp_i < row and 0 <= tmp_j < col and \
                        grid[tmp_i][tmp_j] == '1':
                dfs(tmp_i, tmp_j)

    for i in range(row):
        for j in range(col):
            if grid[i][j] == '1':
                dfs(i,j)
                cnt += 1
    return cnt

#bfs
def numIslands_3(grid):
    from collections import deque
    if not grid: return 0
    row = len(grid)
    col = len(grid[0])
    cnt = 0

    def bfs(i,j):
        queue = deque()
        queue.appendleft((i,j))
        grid[i][j] = "0"
        while queue:
            i, j = queue.pop()
            for x, y in [[-1,0], [1,0], [0,-1],[0,1]]:
                tmp_i = i + x
                tmp_j = j + y
                if 0 <= tmp_i < row and 0 <= tmp_j < col and \
                        grid[tmp_i][tmp_j] == '1':
                    grid[tmp_i][tmp_j] = '0'
                    queue.appendleft((tmp_i, tmp_j))

    for i in range(row):
        for j in range(col):
            if grid[i][j] == '1':
                bfs(i,j)
                cnt += 1
    return cnt