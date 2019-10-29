class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        if n == 0:
            return res

        nums = [i for i in range(n)]
        col = set()
        master = set()
        slave = set()
        stack = []

        self.__backtracking(nums, 0, n, col, master, slave, stack, res)
        return res

    def __backtracking(self, nums, row, n, col, master, slave, stack, res):
        if row == n:
            board = self.__convert2board(stack, n)
            res.append(board)
            return

        for i in range(n):
            if i not in col and row + i not in master and row - i not in slave:
                stack.append(nums[i])
                col.add(i)
                master.add(row + i)
                slave.add(row - i)
