#!/usr/bin/env python3.7
class Solution:
    def removeDuplication(self, nums):
        if not nums:
            return 0
        j = 1
        for i in range(1, len(nums)):
            if nums[i] != nums[i - 1]:
                nums[j] = nums[i]
                j += 1
        return j


nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
print(Solution().removeDuplication(nums))
