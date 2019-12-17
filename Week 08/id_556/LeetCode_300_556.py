from typing import List


# O(n^2)
def lengthOfLIS(nums: List[int]) -> int:
    if not nums:
        return 0
    n = len(nums)
    dp = [1] * n
    for i in range(n):
        for j in range(i):
            if nums[j] < nums[i]:
                dp[i] = max(dp[i], dp[j] + 1)
            else:
                continue
    return max(dp)


# O(nlogn)
def lengthOfLIS2(nums):
    if not nums:
        return 0
    n = len(nums)
    if n < 2:
        return n
    # the min tail element in nums[:i+1]
    tails = [nums[0]]
    for i in range(1, n):
        if nums[i] > tails[-1]:
            tails.append(nums[i])
            continue
        # binary search to find the first tail > nums[i]
        l, r = 0, len(tails) - 1
        while l <= r:
            m = l + ((r - l) >> 1)
            if tails[m] < nums[i]:
                l = m + 1
            else:
                r = m - 1
        tails[l] = nums[i]
    return len(tails)


def lengthOfLIS3(nums):
    n = len(nums)
    tails, res = [0] * n, 0
    for num in nums:
        i, j = 0, res
        while i < j:
            m = i + ((j - i) >> 1)
            if tails[m] < num:
                i = m + 1
            else:
                j = m
        tails[i] = num
        if j == res:
            res += 1
    return res


nums = [10, 9, 2, 5, 3, 7, 101, 18]
print(lengthOfLIS(nums))
print(lengthOfLIS2(nums))
print(lengthOfLIS3(nums))
