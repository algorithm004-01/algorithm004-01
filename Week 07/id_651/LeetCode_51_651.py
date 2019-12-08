"""
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
示例:
输入: 4
输出: [
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。
"""
class Solution:
	def solveNQueens(self, n):
		self.result = []
		self.n = n
		self.DFS([], [], [])
		return [["."*i + "Q" + "."*(n-i-1) for i in sol] for sol in self.result]

	def DFS(self, queens, xy_dif, xy_sum):
		q_num = len(queens)
		if q_num == self.n:
			result.append(queens)
			return None
		for q in range(self.n):
			if q not in queens and q_num-q not in xy_dif and q_num+q not in xy_sum:
				self.DFS(queens+[q], xy_dif+[q_num-q], xy_sum+[q_num+q])

if __name__ == '__main__':
	sol = Solution()
	sol.solveNQueens(4)
	pass