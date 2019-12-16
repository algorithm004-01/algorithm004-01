#!/usr/bin/env python3.7


class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        root = {}
        for word in words:
            node = root
            for c in word:
                node = node.setdefault(c, {})
            node[None] = True
        board = {
            i + 1j * j: c for i, row in enumerate(board) for j, c in enumerate(row)
        }

        found = []

        def search(node, z, word):
            if node.pop(None, None):
                found.append(word)
            c = board.get(z)
            if c in node:
                board[z] = None
                for k in range(4):
                    search(node[c], z + 1j ** k, word + c)
                board[z] = c

        for z in board:
            search(root, z, "")

        return found
