class Solution:
    def removeDuplicates(self, nums: list) -> int:
        nums_len = len(nums)
        if nums_len <= 1:
            return nums_len
        i = 0
        for j in range(1, nums_len):
            if nums[j] != nums[i]:
                nums[i+1] = nums[j]
                i += 1
        return i + 1
