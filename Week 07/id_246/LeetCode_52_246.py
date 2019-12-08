'''
n_queen_ii_52

n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

给定一个整数 n，返回 n 皇后不同的解决方案的数量。
'''

#位运算_1
def totalNQueens_1(n):
    def backtrack(row = 0, hills = 0, next_row = 0, dales = 0, count = 0):
        """
        :type row: 当前放置皇后的行号
        :type hills: 主对角线占据情况 [1 = 被占据，0 = 未被占据]
        :type next_row: 下一行被占据的情况 [1 = 被占据，0 = 未被占据]
        :type dales: 次对角线占据情况 [1 = 被占据，0 = 未被占据]
        :rtype: 所有可行解的个数
        """
        if row == n:
            count += 1
        else:
            #  [1 = 未被占据，0 = 被占据],和上述变量含义相反
            free_columns = columns & ~(hills | next_row | dales)

            while free_columns:
                # free_columns 的第一个为 '1' 的位
                # 在该列我们放置当前皇后
                curr_column = - free_columns & free_columns
                # 并且排除对应的列
                free_columns ^= curr_column
                count = backtrack(row+1,
                                  (hills|curr_column) <<1,
                                   next_row|curr_column,
                                  (dales|curr_column) >>1,
                                   count)
        return count
    # 棋盘所有的列都可放置，
    # 即，按位表示为 n 个 '1'
    # bin(cols) = 0b1111 (n = 4), bin(cols) = 0b111 (n = 3)
    # [1 = 可放置]
    columns = (1 << n) - 1
    return backtrack()


#位运算_2
def totalNQueens_2(self, n):
    if n<1: return []
    self.count = 0
    self.DFS(n,0,0,0,0)
    return self.count

def DFS(self, n, row, cols, pie, na):
    if row >= n:
        count += 1
        return
    bits = (~(cols|pie|na)) & ((1<<n)-1) # 得到所有空位
    while bits:
        p = bits & -bits # 取最低位1
        bits = bits & (bits - 1) # 表示在p位置放皇后
        self.DFS(n, row+1, cols|p, (pie|p)<<1, (na|p)>>1)