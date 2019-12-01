#!/usr/bin/env python3.7


class Solution:
    """
    Don't return anything, modify nums in-place instead.
    """

    def moveZeros(self, nums):
        zero = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[zero], nums[i] = nums[i], nums[zero]
                zero += 1

    def test_case(self, nums):
        self.moveZeros(nums)
        return nums


test = [0, 1, 0, -1, 4, 0, 6]
print(Solution().test_case(test))
