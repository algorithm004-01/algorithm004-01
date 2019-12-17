class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if nums == []:
            return 0
        cell = [1] * len(nums)
        for i in range(1, len(nums)):
            for j in range(i):
                if nums[j] < nums[i]:
                    cell[i] = max(cell[i], cell[j]+1)
        return max(cell)