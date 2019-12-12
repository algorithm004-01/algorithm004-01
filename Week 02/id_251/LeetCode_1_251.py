# 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
#
# 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
#
# 示例: 
#
# 给定 nums = [2, 7, 11, 15], target = 9
#
# 因为 nums[0] + nums[1] = 2 + 7 = 9
# 所以返回 [0, 1]
# 
# Related Topics 数组 哈希表

"""
1 两重循环暴力解法 O(n^2)
2 hash/set 存储 O(n) target - nums[i] 是否在i之前的 nums中
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

    # 1 暴力法
    def force_two_Sum(self, nums, target):
        for i in range(len(nums) - 1):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]

    def hash_two_sum(self, nums, target):
        dic = {}
        for i, v in enumerate(nums):
            if target - v in dic:
                return [dic[target - v], i]
            dic[v] = i

# leetcode submit region end(Prohibit modification and deletion)
