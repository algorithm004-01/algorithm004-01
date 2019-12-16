#!/usr/bin/env python3.7


class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not any(board):
            return

        m, n = len(board), len(board[0])
        save = [
            ij for k in range(m + n) for ij in ((0, k), (m - 1, k), (k, 0), (k, n - 1))
        ]
        while save:
            i, j = save.pop()
            if 0 <= i < m and 0 <= j < n and board[i][j] == "O":
                board[i][j] = "S"
                save += (i, j - 1), (i, j + 1), (i - 1, j), (i + 1, j)

        board[:] = [["XO"[c == "S"] for c in row] for row in board]
