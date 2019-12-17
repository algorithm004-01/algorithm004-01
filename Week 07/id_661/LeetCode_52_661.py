#!/usr/bin/env python3.7


class Solution:
    def totalNQueens(self, n: int) -> int:
        if n < 1:
            return []
        self.count = 0
        self.DFS(n, 0, 0, 0, 0)
        return self.count

    def DFS(self, n, row, cols, pie, na):
        if row >= n:
            self.count += 1
            return
        bits = (~(cols | pie | na)) & ((1 << n) - 1)
        while bits:
            p = bits & -bits
            bits = bits & (bits - 1)
            self.DFS(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1)


print(Solution().totalNQueens(4))
