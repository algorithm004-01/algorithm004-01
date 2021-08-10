#!/usr/bin/env python3.7


class Solution:
    def isPowerOfTwo(self, n):
        return n != 0 and n & (n - 1) == 0


print(Solution().isPowerOfTwo(218))
