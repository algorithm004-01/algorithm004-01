#!/usr/bin/env python3.7


class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()

        child = 0
        cookie = 0

        while cookie < len(s) and child < len(g):
            if s[cookie] >= g[child]:
                child += 1
            cookie += 1

        return child
