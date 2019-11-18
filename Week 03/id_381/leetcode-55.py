
# 从右往左贪心
class Solution:
    def canJump(self, nums) -> bool:
        end = len(nums) - 1
        for i in range(len(nums)-1, 0-1, -1):
            if nums[i] + i >= end:
                end = i
            if end == 0:
                return True
        return end == 0
