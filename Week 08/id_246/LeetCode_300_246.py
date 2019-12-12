'''
longest-increasing-subsequence_300

给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:
输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
'''

# 动态规划
def length0fLIS_1(nums):
    if not nums: return 0
    dp = [1] * len(nums)
    for i in range(len(nums)):
        for j in range(i):
            if nums[j] < nums[i]:
                dp[i] = max(dp[i], dp[j]+1)
    return max(dp)


# 动态规划 + 二分查找
def length0fLIS_2(nums):
    tails, res = [0] * len(nums), 0
    for num in nums:
        i, j = 0, res
        while i < j:
            m = (i + j)//2
            if tails[m] < num:
                i = m + 1
            else:
                j = m
        tails[i] = num
        if j == res:
            res += 1
    return res


# 动态规划 + 二分查找
def lengthOfLIS_3(nums):
    q = [-float('inf')]
    for i in nums:
        if i > q[-1]:
            q += [i]
        else:
            q[bisect.bisect_left(q, i)] = i
    return len(q) - 1