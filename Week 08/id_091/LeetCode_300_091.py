from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums: return 0
        dp = [1] * len(nums)
        for i in range(len(nums)):
            for j in range(i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)


if __name__ == "__main__":
    solution = Solution()
    res = solution.lengthOfLIS([4, 5, 5, 4, 20, 19, 30, 21, 20])
    print(res)
