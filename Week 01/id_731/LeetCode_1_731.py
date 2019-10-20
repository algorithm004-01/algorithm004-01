class Solution(object):
    def twoSum(self, nums, target):
        lens = len(nums)
        for i in range(lens):
            if target - nums[i] in nums[i+1:]:
                return [i, nums.index(target - nums[i], i+1)]