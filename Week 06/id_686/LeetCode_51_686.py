#
# @lc app=leetcode.cn id=51 lang=python3
#
# [51] N皇后
#

# @lc code=start
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [['.' for _ in range(n)] for _ in range(n)]
        d1 = set()
        d2 = set()
        h = set()
        v = set()
        soln = []

        def util(col):
            if col == n: # Found a soln, so add it
                soln.append([])
                for row in board:
                    soln[-1].append("".join(row))
                return
                        
            for row in range(n): 
                if col not in v and row not in h and col+row not in d1 and (n-col-1 + row) not in d2:
                    board[col][row] = 'Q'
                    v.add(col)
                    h.add(row)
                    d1.add(col+row)
                    d2.add(n-col-1 + row)

                    util(col+1)

                    board[col][row] = '.'
                    v.remove(col)
                    h.remove(row)
                    d1.remove(col+row)
                    d2.remove(n-col-1 + row)
 
        util(0)
        return soln      
# @lc code=end

