'''
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
例如，给定三角形：
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
说明：
如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
'''
# 暴力法 brute-force ,递归 ,n层：left or right : O2^n
'''DP 
 1. 找重复性（分治）problem(i,j) = min(sub(i+1,j),sub(i+1, j+1)) + a[i,j]
 2. 定义状态数组 f[i,j]
 3. DP方程 ： f[i,j] = min(f[i+1,j],f[i+1,j+1] + a[i,j])
 找最小路径
''' 
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        '''
        DP方程：
            f[i,j] = min(f[i+1,j],f[i+1,j+1] + a[i,j])
        '''
        #dp 直接赋值给到 triangle
        dp=triangle
        #开始循环
        for i in range(len(triangle)-2, -1, -1):
            for j in range(len(triangle[i])):
                dp[i][j] += min(dp[i+1][j],dp[i+1][j+1])
        return dp[0][0]
