class Solution:
    def uniquePaths(self, m: int, n: int):
        res = [([0] * n) for _ in range(m)]
        # for
        for i in range(m):
            for j in range(n):
                if i == 0 or j == 0:
                    res[i][j] = 1
                    continue
                res[i][j] = res[i-1][j] +  res[i][j-1]

        return res[-1][-1]

if __name__ == '__main__':
    s = Solution()
    res = s.uniquePaths(7, 3)
    print("res: ", res)