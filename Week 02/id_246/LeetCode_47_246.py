'''
permutations ii_47

给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:
输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
'''

#回溯
def permuteUnique_1(nums):
    if not nums: return []
    nums.sort()
    res = []

    def backtrack(nums, tmp):
        if not nums:
            res.append(tmp)
            return
        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            backtrack(nums[:i] + nums[i+1:], tmp+[nums[i]])
    backtrack(nums,[])
    return res