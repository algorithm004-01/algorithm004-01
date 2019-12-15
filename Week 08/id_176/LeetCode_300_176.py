cclass Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums: return 0
        length = len(nums)
        dp = [1] * length
        for i in range(length):
            for j in range(i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)
