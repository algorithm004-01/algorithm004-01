# g 是孩子 s 是饼干
# 饼干代表的数值必须大于等于孩子需要
class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g_length = len(g)
        s_length = len(s)
        if s_length == 0 or g_length == 0:
            return 0 
        g.sort()
        s.sort() 
        
        res = i = j= 0
        
        while i < g_length and j < s_length:
            if g[i] <= s[j]:
                res += 1
                i += 1
                j += 1      
            else:
                j += 1
                
        return res