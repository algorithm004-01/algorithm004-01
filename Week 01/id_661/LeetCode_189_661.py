#!/usr/bin/env python3.7
class Solution:
    def rotate(self, nums, k):
        n = len(nums)
        k %= n
        if k:
            self.numsReverse(nums, 0, n - 1)
            self.numsReverse(nums, 0, k - 1)
            self.numsReverse(nums, k, n - 1)
        return nums

    def numsReverse(self, nums, start, end):
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1
        return


test = [1, 2, 3, 4, 5, 6, 7, 8]
print(Solution().rotate(test, 3))
