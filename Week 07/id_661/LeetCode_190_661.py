#!/usr/bin/env python3.7


class Solution:
    def reverseBits(self, n):
        result = 0
        for i in range(32):
            result = (result << 1) + (n & 1)
            n >>= 1

        return result


test = 0b11000111000110101100110010010101
print(bin(Solution().reverseBits(test)))
