class Solution:
    def rotate(self, nums: list, k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k = k % len(nums)
        start = 0
        next = (start + k) % len(nums)
        tmp = nums[start]
        for i in range(len(nums)):
            nums[next], tmp = tmp, nums[next]
            if next == start:
                if i == len(nums)-1:
                    break
                start += 1
                next = (start + k) % len(nums)
                tmp = nums[start]
            else:
                next = (next + k) % len(nums)
