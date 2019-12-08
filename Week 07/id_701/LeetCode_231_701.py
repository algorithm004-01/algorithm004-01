class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        return n > 0 and not (n & n-1)
