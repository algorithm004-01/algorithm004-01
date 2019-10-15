# 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
#
# 示例: 
#
# 输入: [0,1,0,3,12]
# 输出: [1,3,12,0,0]
#
# 说明: 
#
# 
# 必须在原数组上操作，不能拷贝额外的数组。 
# 尽量减少操作次数。 
# 
# Related Topics 数组 双指针


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    """
    # 1 loop 两层循环统计 0
    # 2 一个新数组，遍历非零存入新数组，最后len(old array) - len(new array)个0
    # 3 index 统计非零
    1 和 3 本质上差别不到，无非就是 一个统计0 一个统计非0
    """

    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        # 双指针法优化版本
        # 速度比two_index 好，0越多越明显
        j = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[j] = nums[i]
                if i != j:
                    nums[i] = 0
                j += 1

    # 双指针交换版 和 上面优化版复杂度一样
    def swap_index(self, nums):
        j = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                """
                # 减少无用的操作，只有在没有0的情况下才生效，意义不大
                if i != j:
                    nums[j], nums[i] = nums[i], nums[j]
                """
                nums[j], nums[i] = nums[i], nums[j]
                j += 1

    def two_index(self, nums):
        # 双指针法好理解的版本
        j = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[j] = nums[i]
                j += 1

        for i in range(j, len(nums)):
            nums[i] = 0

    # 1 count 0
    def count_zeros(self, nums):
        zeros_count = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                zeros_count += 1
            else:
                """
                # 减少无用的赋值操作，只有在没有0的情况下才生效，意义不大
                if i - zeros_count != i:
                    nums[i - zeros_count] = nums[i]
                """
                nums[i - zeros_count] = nums[i]

        for j in range(len(nums) - zeros_count, len(nums)):
            nums[j] = 0

    # 1.2 count 0 改进版
    def count_zeros_(self, nums):
        zeros_count = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                zeros_count += 1
            else:
                """
                # 减少无用的赋值操作，只有在没有0的情况下才生效，意义不大
                if i - zeros_count != i:
                    nums[i - zeros_count], nums[i] = nums[i], nums[i - zeros_count]
                """
                nums[i - zeros_count], nums[i] = nums[i], nums[i - zeros_count]

    # 笨方法 LeetCode 是无法通过的
    def newArray(self, nums):
        new_list = []
        for i in nums:
            if i != 0:
                new_list.append(i)
        zeros_count = len(nums) - len(new_list)
        if zeros_count:
            new_list.extend([0] * zeros_count)
        return new_list


# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    # 笨方法测试
    s = Solution()
    print(s.newArray([0, 1, 0, 3, 12, 0]))
    print(s.newArray([0]))
