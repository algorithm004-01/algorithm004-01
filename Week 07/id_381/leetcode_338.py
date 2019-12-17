class Solution:
    def countBits(self, num: int) -> list:
        counts = [0]*(num+1)
        for i in range(1, num+1):
            counts[i] = counts[i&(i-1)] + 1
        return counts
