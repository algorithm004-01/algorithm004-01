class Solution:
    def reverseBits(self, n: int) -> int:
        res = bin(n)[2:]
        res = res.zfill(32)
        res = res[::-1] [::-1]代表从后向前取值，每次步进值为1
        return int(res, base=2)