# 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
#
# ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
#
# 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
#
# 你可以假设数组中不存在重复的元素。 
#
# 你的算法时间复杂度必须是 O(log n) 级别。 
#
# 示例 1: 
#
# 输入: nums = [4,5,6,7,0,1,2], target = 0
# 输出: 4
# 
#
# 示例 2: 
#
# 输入: nums = [4,5,6,7,0,1,2], target = 3
# 输出: -1
# Related Topics 数组 二分查找


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        left, right = 0, len(nums) - 1
        while left < right:
            mid = left + (right - left) // 2
            if (nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]):
                left = mid + 1
            else:
                right = mid
        return left if target in nums[left: left + 1] else -1


# 好理解的解法
class Solution1(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if not nums:
            return -1

        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid
            if nums[left] <= nums[mid]:
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1


if __name__ == '__main__':
    s = Solution1()
    print(s.search([], 0))
    print(s.search([1, 2, 3], 2))
    print(s.search([4, 5, 6, 0, 1, 3], 0))
