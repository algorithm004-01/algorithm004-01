
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid) -> int:

        width = len(obstacleGrid[0])
        res = [0] * width
        res[0] = 1

        # for
        for item in obstacleGrid:
            for j in range(width):
                if item[j] == 1:
                    res[j] = 0
                elif item[j] == 0:
                    res[j] = 1

        return res[-1]

if __name__ == '__main__':
    matrx = [
              [0,0,0,0,1],
              [0,1,0,1,0],
              [0,0,1,0,0],
              [1,0,1,0,0],
            ]

    s = Solution()
    print("res: ", s.uniquePathsWithObstacles(matrx))