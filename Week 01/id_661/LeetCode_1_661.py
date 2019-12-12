#!/usr/bin/env python3.7


class Solution:
    def twoSum(self, nums, target):
        dct = {}
        for k, v in enumerate(nums):
            if target - v in dct:
                return [dct[target - v], k]
            dct[v] = k
        return []


nums = [2, 7, 11, 15]
print(Solution().twoSum(nums, 9))
