class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        # 非法输入
        if not board or not board[0]:
            return board
        
        x, y = click[0], click[1]
        # 一下就挖到地雷，提前返回
        if board[x][y] == 'M':
            board[x][y] = 'X'
            return board
        # 得到地图的长宽
        m, n = len(board), len(board[0])
        # 用来记录访问历史的二维数组，0为未访问，1为访问过
        visited = [[0 for _ in range(n + 1)] for j in range(m + 1)]
        # 用来组成向八个方向搜索的向量
        dx = [1, 1, -1, -1, 0, 0, -1, 1]
        dy = [1, 0, -1, 0, 1, -1, 1, -1]
    
        def dfs(x, y):
            # 如果是地雷或者访问过，停止搜索
            if board[x][y] == 'M' or visited[x][y] == 1:
                return

            visited[x][y] = 1
            mineCount = 0 # 用来统计附近的地雷个数
            
            # 向八个方向搜索
            for k in range(len(dx)):
                x1 = x + dx[k]
                y1 = y + dy[k]
                
                # 判断是否是地雷
                if 0 <= x1 < m and 0 <= y1 < n and board[x1][y1] == 'M':
                    mineCount += 1
                    
            if mineCount > 0:
                board[x][y] = str(mineCount) # 在地图上标记地雷个数
            else:
                board[x][y] = 'B' # 没有相邻地雷，需要对该位置的八个方向做相同的搜索

                for k in range(len(dx)):
                    x1 = x + dx[k]
                    y1 = y + dy[k]
                    
                    # 过滤掉越界和访问过的位置

                    if 0 <= x1 < m and 0 <= y1 < n and visited[x1][y1] == 0:
                        dfs(x1, y1)
        dfs(x, y)
        return board