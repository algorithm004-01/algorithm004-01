'''
majority element_169

给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2
'''

# 暴力
def majorityElement_1(nums):
    majority_count = len(nums)//2
    for num in nums:
        count = sum(1 for elem in nums if elem == num)
        if count > majority_count:
            return num


# hash
import collections
def majorityElement_2(nums):
    counts = collections.Counter(nums)
    return max(counts.keys(), key = counts.get)


# 分治
def majorityElement_3(nums, lo=0, hi=None):
    def majority_element_rec(lo, hi):
        if lo == hi:
            return nums[lo]

        mid = (hi-lo)//2 + lo
        left = majority_element_rec(lo, mid)
        right = majority_element_rec(mid+1, hi)

        if left == right:
            return left

        left_count = sum(1 for i in range(lo, hi+1) if nums[i] == left)
        right_count = sum(1 for i in range(lo, hi+1) if nums[i] == right)

        return left if left_count > right_count else right

    return majority_element_rec(0, len(nums)-1)