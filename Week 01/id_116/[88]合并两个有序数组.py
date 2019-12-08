# 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
#
# 说明: 
#
# 
# 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 
# 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
# 
#
# 示例: 
#
# 输入:
# nums1 = [1,2,3,0,0,0], m = 3
# nums2 = [2,5,6],       n = 3
#
# 输出: [1,2,2,3,5,6]
# Related Topics 数组 双指针


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """
        # 方式一，双指针，从前往后
        # 时间复杂度O(m+n)
        # 空间复杂度O(m)
        new_nums = nums1[:m]
        # print(id(nums1))
        nums1[:] = []
        # nums1=[]
        # print(id(nums1))
        p1 = 0
        p2 = 0
        while p1 < m and p2 < n:
            if new_nums[p1] < nums2[p2]:
                nums1.append(new_nums[p1])
                p1 += 1
            else:
                nums1.append(nums2[p2])
                p2 += 1
        if p1 < m:
            nums1[p1 + p2:] = new_nums[p1:]
        if p2 < n:
            nums1[p1 + p2:] = nums2[p2:]

        # 方式二
        # 双指针,从后往前
        # 时间复杂度O(m+n)
        # 空间复杂度O(1)
        p = m + n - 1
        p1 = m-1
        p2 = n-1

        while p1 >= 0 and p2 >= 0:
            if nums1[p1] < nums2[p2]:
                nums1[p] = nums2[p2]
                p2 -= 1
            else:
                nums1[p] = nums1[p1]
                p1 -= 1
            p -= 1
        nums1[:p2 + 1] = nums2[:p2+1]
        # print(nums1)
        # print(nums2)
    # leetcode submit region end(Prohibit modification and deletion)


# Solution().merge([1, 2, 3, 0, 0, 0], 3, [2, 5, 6], 3)
# Solution().merge([1], 1, [], 0)

l1 = [1,2,2,3,5,6]
l2 = [2,5,6]
print(l1[:0])
print(l2[:0])
print(l1)