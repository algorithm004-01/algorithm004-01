#!/usr/bin/env python3.7
class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        l1, l2 = len(word1) + 1, len(word2) + 1
        pre = [0 for _ in range(l2)]
        for j in range(l2):
            pre[j] = j
        for i in range(1, l1):
            cur = [i] * l2
            for j in range(1, l2):
                cur[j] = min(
                    cur[j - 1] + 1,
                    pre[j] + 1,
                    pre[j - 1] + (word1[i - 1] != word2[j - 1]),
                )
            pre = cur[:]
        return pre[-1]
