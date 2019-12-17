#!/usr/bin/env python3.7


class Solution(object):
    def firstUniqChar(self, s: str) -> int:
        dic = {c: s.count(c) for c in set(s)}

        for i, c in enumerate(s):
            if dic[c] == 1:
                return i

        return -1
