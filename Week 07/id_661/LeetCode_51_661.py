#!/usr/bin/env python3.7


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []
        self._DFS(result, [], [], [], n)
        return [["." * i + "Q" + "." * (n - i - 1) for i in sol] for sol in result]

    def _DFS(self, result, queens, xy_dif, xy_sum, n):
        p = len(queens)
        if p == n:
            result.append(queens)
            return None
        for q in range(n):
            if q not in queens and p - q not in xy_dif and p + q not in xy_sum:
                self._DFS(result, queens +
                          [q], xy_dif + [p - q], xy_sum + [p + q], n)
