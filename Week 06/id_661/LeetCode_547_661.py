#!/usr/bin/env python3.7


class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        n = len(M)
        seen = set()

        def dfs(node):
            for nei, adj in enumerate(M[node]):
                if adj and nei not in seen:
                    seen.add(nei)
                    dfs(nei)

        ans = 0
        for i in range(n):
            if i not in seen:
                dfs(i)
                ans += 1
        return ans
