# 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
#
# 注意：答案中不可以包含重复的三元组。 
#
# 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
#
# 满足要求的三元组集合为：
# [
#  [-1, 0, 1],
#  [-1, -1, 2]
# ]
# 
# Related Topics 数组 双指针

"""
1 暴力解法 三层循环 O(n^3)
2 排序 + 双指针
3 排序 hash 转换为两数之和问题
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

    def force_three_sum(self, nums):
        nums.sort()
        res = set()
        for i in range(len(nums) - 2):
            for j in range(i + 1, len(nums) - 1):
                for k in range(j + 1, len(nums)):
                    if nums[i] + nums[j] + nums[k] == 0:
                        res.add((nums[i], nums[j], nums[k]))
        return map(list, res)

    def sort_towIndex_three_sum(self, nums):
        nums.sort()
        res = []
        for k in range(len(nums) - 2):
            if nums[k] > 0: break  # 因为 nums[r] > nums[l] > nums[k]
            if k > 0 and nums[k] == nums[k - 1]: continue  # skip 重复项

            l, r = k + 1, len(nums) - 1
            while l < r:
                s = nums[k] + nums[l] + nums[r]
                if s < 0:
                    while l < r and nums[l] == nums[l + 1]: l += 1  # skip 重复项
                    l += 1
                elif s > 0:
                    while l < r and nums[r] == nums[r - 1]: r -= 1  # skip 重复项
                    r -= 1
                else:
                    res.append([nums[k], nums[l], nums[r]])
                    while l < r and nums[l] == nums[l + 1]: l += 1  # skip 重复项
                    while l < r and nums[r] == nums[r - 1]: r -= 1  # skip 重复项
                    l += 1
                    r -= 1
        return res

    def hash_three_sum(self, nums):
        if len(nums) < 3:
            return []

        nums.sort()
        res = set()
        for i, v in enumerate(nums[:-2]):
            if v > 0: break
            if i > 0 and v == nums[i - 1]: continue  # skip 重复项

            vist = {}
            for x in nums[i + 1:]:
                if x not in vist:
                    vist[-v - x] = 1
                else:
                    res.add((v, -v - x, x))
        return map(list, res)
# leetcode submit region end(Prohibit modification and deletion)
