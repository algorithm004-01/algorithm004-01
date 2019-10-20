class Solution:
    def rotate(self, nums: list, k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k = k % len(nums)   # 防止k太大
        start = 0
        # start + k 的值超出长度后循环next
        next = (start + k) % len(nums)
        tmp = nums[start]
        for i in range(len(nums)):
            nums[next], tmp = tmp, nums[next]
            # 相等会陷入循环，其他数据无法挪动
            if next == start:
                if i == len(nums)-1:
                    # 结束
                    break
                start += 1
                next = (start + k) % len(nums)
                tmp = nums[start]
            else:
                next = (next + k) % len(nums)
