class Solution:
    def findMin(self, nums: List[int]) -> int:
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if high - low <= 1:
                return min(nums[high], nums[low])
            if nums[mid] < nums[mid - 1] and nums[mid] < nums[mid+1]:
                return nums[mid]
            if nums[mid] > nums[high]:
                low = mid+1
            else:
                high = mid-1
