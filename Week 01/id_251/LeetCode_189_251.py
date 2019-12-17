# 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
#
# 示例 1: 
#
# 输入: [1,2,3,4,5,6,7] 和 k = 3
# 输出: [5,6,7,1,2,3,4]
# 解释:
# 向右旋转 1 步: [7,1,2,3,4,5,6]
# 向右旋转 2 步: [6,7,1,2,3,4,5]
# 向右旋转 3 步: [5,6,7,1,2,3,4]
# 
#
# 示例 2: 
#
# 输入: [-1,-100,3,99] 和 k = 2
# 输出: [3,99,-1,-100]
# 解释:
# 向右旋转 1 步: [99,-1,-100,3]
# 向右旋转 2 步: [3,99,-1,-100]
#
# 说明: 
#
# 
# 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
# 要求使用空间复杂度为 O(1) 的 原地 算法。 
# 
# Related Topics 数组

"""
1 暴力解法 旋转 k 次，每次将数组旋转 1 个元素。
2 使用额外的数组
3 环形旋转
4 三次使用反转
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """

    # 1 暴力解法 O(n*k) 超时
    def force_rotate(self, nums, k):
        k %= len(nums)
        for _ in range(k):
            previous = nums[-1]
            for i in range(len(nums)):
                previous, nums[i] = nums[i], previous

    # 2 使用额外的数组 时间空间：O(n)
    def new_arr_rotate(self, nums, k):
        k %= len(nums)
        new_list = [None] * len(nums)
        for i in range(len(nums)):
            new_list[(i + k) % len(nums)] = nums[i]

        nums[:] = new_list

    # 3 环形旋转 ?
    def ring_rotation(self, nums, k):
        size = len(nums)
        k %= size
        count = start = 0  # start是当出现循环时最开始的点
        while count < size:
            target = start
            prev = nums[target]
            while True:
                target = (target + k) % size
                prev, nums[target] = nums[target], prev
                count += 1
                if target == start:
                    break  # 次数到了或者出现循环则跳出
            start += 1

    # 4 三次使用反转 最优解法
    def three_reverse_rotation(self, nums, k):
        k %= len(nums)
        """
        self.reverse(nums, 0, len(nums) - 1)
        self.reverse(nums, 0, k - 1)
        self.reverse(nums, k, len(nums) - 1)
        """
        nums[:] = nums[::-1]
        nums[:k] = nums[:k][::-1]
        nums[k:] = nums[k:][::-1]

    # 反转list
    def reverse(self, nums, start, end):
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1

    # other 1 Python语言特性解法 性能一般
    def p_rotate(self, nums, k):
        k %= len(nums)
        for _ in range(k):
            nums.insert(0, nums.pop())

    # other 2 Python语言特性解法
    def p_rotate1(self, nums, k):
        k %= len(nums)
        nums[:] = nums[-k:] + nums[:-k]


if __name__ == '__main__':
    s = Solution()
    l = [1, 2, 3, 4]
    s.reverse(l, 1, 3)
    print(l)
