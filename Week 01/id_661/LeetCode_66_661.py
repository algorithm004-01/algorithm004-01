#!/usr/bin/env python3.7


class Solution:
    def plusOne(self, digits):
        n = len(digits) - 1
        return self._plusOne(digits, n)

    def _plusOne(self, nums, n):
        if not nums[n] < 9:
            nums[n] = (nums[n] + 1) % 10
            if n == 0:
                nums.insert(0, 1)
            else:
                self._plusOne(nums, n - 1)
        else:
            nums[n] += 1

        return nums


test = [9, 9]
print(Solution().plusOne(test))
