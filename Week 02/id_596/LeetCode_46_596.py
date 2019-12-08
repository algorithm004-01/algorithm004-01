#
# @lc app=leetcode.cn id=46 lang=python3
#
# [46] 全排列
#

# @lc code=start
class Solution:
    # 基本思路：
    # 和左右括号的问题差不多，每个位置填入一个数字，限制条件变成：
    # 填入的数字在之前没有出现过。
    # 解决的方案为填入数字之后将其从选项中移除，下一层就无法选择相同的数字

    def permute(self, nums: List[int]) -> List[List[int]]:
        resultList = []
        self.helper(nums, [], resultList)
        return resultList
        
    def helper(self, nums, result, resultList):
        if not nums:
            resultList.append(result)
            return
        for i in range(len(nums)):
            self.helper(nums[:i]+nums[i+1:], result+[nums[i]], resultList)
# @lc code=end

