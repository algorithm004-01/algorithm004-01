class Solution:
    def search(self, nums: List[int], target: int) -> int:
        index = -1
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                index = mid
                break
            elif nums[left] > target:
                if nums[left] < nums[right]:
                    right = mid - 1
                else:
                    left = mid+1
            else:
                if nums[left] < nums[right]:
                    left = mid+1
                else:
                    right = mid-1

        return index
