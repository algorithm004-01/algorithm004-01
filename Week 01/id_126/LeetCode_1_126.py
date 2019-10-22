class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        hashmap = {}
        for index, num in enumerate(nums):
            complement = target - num
            if complement in hashmap:
                return [hashmap[complement], index]
            hashmap[num] = index
        return None