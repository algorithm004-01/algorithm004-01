class Solution:
    def twoSum(self, nums: list, target: int) -> list:
        tmp_dict = {}
        for i in range(len(nums)):
            sub = target - nums[i]
            if sub in tmp_dict:
                if tmp_dict[sub] != i:
                    return [i, tmp_dict[sub]]
            tmp_dict[nums[i]] = i
