# n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
#
# 
#
# 上图为 8 皇后问题的一种解法。 
#
# 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
#
# 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
#
# 示例: 
#
# 输入: 4
# 输出: [
# [".Q..",  // 解法 1
#  "...Q",
#  "Q...",
#  "..Q."],
#
# ["..Q.",  // 解法 2
#  "Q...",
#  "...Q",
#  ".Q.."]
# ]
# 解释: 4 皇后问题存在两个不同的解法。
# 
# Related Topics 回溯算法
"""
1 回溯法 剪枝
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        if n < 1: return []

        self.result = []
        self.cols, self.pie, self.na = set(), set(), set()
        self.DFS(n, 0, [])
        return self._generate_result(n)

    def DFS(self, n, row, cur_state):
        # recursion terminator
        if row >= n:
            self.result.append(cur_state)
            return

        # current level! Do it !
        for col in range(n):
            if col in self.cols or row + col in self.pie or row - col in self.na:
                # go die!
                continue

            # update the flags
            self.cols.add(col)
            self.pie.add(row + col)
            self.na.add(row - col)

            self.DFS(n, row + 1, cur_state + [col])

            # reverse states
            self.cols.remove(col)
            self.pie.remove(row + col)
            self.na.remove(row - col)

    def _generate_result(self, n):
        board = []
        for res in self.result:
            for i in res:
                board.append('.' * i + 'Q' + '.' * (n - i - 1))
        return [board[i: i + n] for i in range(0, len(board), n)]


# 回溯法优化写法
class Solution1(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        result = []
        self.dfs([], [], [], n, result)
        return [['.' * i + 'Q' + '.' * (n - i - 1) for i in sol] for sol in result]

    def dfs(self, queens, xy_dif, xy_sum, n, result):
        p = len(queens)
        if p == n:
            result.append(queens)
        for q in range(n):
            if q not in queens and p - q not in xy_dif and p + q not in xy_sum:
                self.dfs(queens + [q], xy_dif + [p - q], xy_sum + [p + q], n, result)
