#n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
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
#输出: [
# [".Q..",  // 解法 1
#  "...Q",
#  "Q...",
#  "..Q."],
#
# ["..Q.",  // 解法 2
#  "Q...",
#  "...Q",
#  ".Q.."]
#]
#解释: 4 皇后问题存在两个不同的解法。
# 
# Related Topics 回溯算法



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        def dfs(queens, xy_diff, xy_sum):
            p = len(queens)
            if p == n:
                res.append(queens)
                return None
            for q in range(n):
                if q not in queens \
                    and p-q not in xy_diff \
                    and p+q not in xy_sum:
                    dfs(queens + [q], xy_diff+[p-q], xy_sum+[p+q])

        res = []
        dfs([], [], [])
        return [["."*i + "Q" + "."*(n-i-1) for i in single] for single in res]
        
#leetcode submit region end(Prohibit modification and deletion)
