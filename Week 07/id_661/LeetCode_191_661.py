#!/usr/bin/env python3.7


class Solution:
    def hammingWeight(self, n):
        count = 0
        while n > 0:
            count += 1
            n &= n - 1
        return count


test = 0b00000000000000000000000000001011

print(Solution().hammingWeight(test))
