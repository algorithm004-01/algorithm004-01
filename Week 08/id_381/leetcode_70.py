class Solution:
    cache = [0, 1, 2]
    def climbStairs(self, n: int) -> int:
        if n < len(self.cache):
            return self.cache[n]
        for i in range(len(self.cache), n+1):
            self.cache.append(self.cache[i-1] + self.cache[i-2])
        return self.cache[n]
