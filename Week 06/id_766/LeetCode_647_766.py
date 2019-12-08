#
# @lc app=leetcode.cn id=647 lang=python3
#
# [647] 回文子串
#

# @lc code=start
class Solution:
    def countSubstrings(self, s: str) -> int:
        counts, count = [], 1
        for i in range(len(s)-1):
            if s[i] == s[i+1]:
                count += 1
            else:
                counts.append((s[i], count))
                count = 1
        counts.append((s[-1], count))
        res = 0
        for i in range(len(counts)):
            res += counts[i][1]*(counts[i][1]+1)//2
           
            j = 1  
            while i-j >= 0 and i+j < len(counts):
                left, right = counts[i-j], counts[i+j]
                if left[0] == right[0]:  
                    if left[1] != right[1]:  
                        res += min(left[1], right[1]) 
                        break  
                    else:
                        res += left[1] 
                        j += 1  
                else:
                    break  
        return res
        
# @lc code=end

