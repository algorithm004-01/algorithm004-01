#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dict_1 = {}
        for i,m in enumerate(nums):
            n = target - m
            if n in dict_1:
                return [dict_1[n],i]
            else:
                dict_1[m] = i
# @lc code=end

