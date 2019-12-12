#
# @lc app=leetcode.cn id=85 lang=python3
#
# [85] 最大矩形
#

# @lc code=start
class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        if len(matrix)==0:
            return 0
        m,n=len(matrix),len(matrix[0])
        rec=[0]*(n+1)
        
        max_rec=0
        for i in range(m):
            stack=[-1]
            for j in range(n+1):
                
                if j<n and matrix[i][j]=='1':
                    rec[j]=rec[j]+1
                else:
                    rec[j]=0
                while(rec[stack[-1]]>rec[j]):
                    h=rec[stack.pop()]
                    
                    max_rec=max(max_rec,h*(j-stack[-1]-1))
                stack.append(j)
        return max_rec

        
# @lc code=end

