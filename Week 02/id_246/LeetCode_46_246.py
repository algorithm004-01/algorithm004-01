'''
permutations_46

给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
'''

#回溯
def permute_1(nums):
    def backtrack(first = 0):
        if first == n:
            output.append(nums[:])
        for i in range(first, n):
            nums[first], nums[i] = nums[i], nums[first]
            backtrack(first+1)
            nums[first], nums[i] = nums[i], nums[first]
    n = len(nums)
    output = []
    backtrack()
    return output


def permute_2(nums):
    return [[n] + p
            for i, n in enumerate(nums)
            for p in permute_2(nums[:i] + nums[i+1:])] or [[]]