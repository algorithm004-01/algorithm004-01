#
# @lc app=leetcode.cn id=1122 lang=python3
#
# [1122] 数组的相对排序
#

# @lc code=start
class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        cnt = [0 for _ in range(1001)]
        
        for a in arr1:
            cnt[a] += 1
        
        i = 0
        for a in arr2:
            while cnt[a] > 0:
                arr1[i] = a
                i += 1
                cnt[a] -= 1
        
        for j in range(1001):
            while cnt[j] > 0:
                arr1[i] = j
                i += 1
                cnt[j] -= 1
        
        return arr1
        
# @lc code=end

