class Solution:
    def reverseBits(self, n: int) -> int:
        res = 0
        for i in range(32):
            res <<= 1
            res += n&1
            n >>= 1
        return res
