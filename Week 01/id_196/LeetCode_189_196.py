class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k %= n
        if k == 0:return
        start = 0
        tmp = nums[start]
        cnt = 0
        while cnt < n:
            nxt = (start + k) % n
            while nxt != start:
                nums[nxt], tmp = tmp, nums[nxt]
                nxt = (nxt+k) % n
                cnt += 1
            nums[nxt] = tmp
            start += 1
            tmp = nums[start]
            cnt += 1

