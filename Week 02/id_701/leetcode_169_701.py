class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        return list(sorted(nums))[len(nums)//2]
