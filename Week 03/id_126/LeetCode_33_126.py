class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:return -1
        n = len(nums)
        left = 0
        right = len(nums) - 1
        while left < right:
            mid = left + (right - left) //2
            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid
        t = left
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = (left + right) //2
            realmid = (mid + t) % n
            if nums[realmid] == target:
                return realmid
            elif nums[realmid] > target:
                right = mid - 1
            else:
                left = mid + 1
        return -1
