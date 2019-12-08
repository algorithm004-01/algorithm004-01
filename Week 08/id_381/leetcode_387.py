class Solution:
    def firstUniqChar(self, s: str) -> int:
        cache = {}
        for c in s:
            if c in cache:
                cache[c] += 1
            else:
                cache[c] = 1
        for i in range(len(s)):
            if cache[s[i]] == 1:
                return i
        return -1
