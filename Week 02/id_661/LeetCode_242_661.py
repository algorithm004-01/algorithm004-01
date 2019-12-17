#!/usr/bin/env python3.7


class Solution:
    def isAnagram(self, s, t):
        d1, d2 = {}, {}
        for c in s:
            d1[c] = d1.get(c, 0) + 1
        for c in t:
            d2[c] = d2.get(c, 0) + 1
        return d1 == d2


print(Solution().isAnagram("anagram", "naagrma"))
