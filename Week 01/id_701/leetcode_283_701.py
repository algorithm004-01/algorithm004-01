class Solution:
    def moveZeroes(self, nums: list) -> None:
        for i in range(len(nums)):
            if nums[i] == 0:
                nums.remove(0)
                nums.append(0)

    def moveZeroes(self, nums: list) -> None:
        id = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[id], nums[i] = nums[i], nums[id]
                id += 1
