class Solution:
    # 逆序遍历
    def removeDuplicates(self, nums: list) -> int:
        if nums is None:
            return 0
        for i in range(len(nums) - 1, 0, -1):
            if nums[i] == nums[i-1]:
                nums.pop(i)
        return len(nums)

    # 下标法
    def removeDuplicates2(self, nums: list) -> int:
        if nums is None:
            return 0
        id = 0
        for i in range(1, len(nums)):
            if nums[i] == nums[id]:
                nums[id+1] = nums[i]
                id += 1
        return id+1
