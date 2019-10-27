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
"""
1 合并后排序
2 双指针 / 从前往后
3 双指针 / 从后往前
"""


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

    # 1 合并后排序
    # 时间复杂度: O((n + m)log(n + m))
    # 空间复杂度: O(1)
    def merege_sort(self, nums1, m, nums2, n):
        nums1[:] = sorted(nums1[:m] + nums2)

    # 2 双指针 / 从前往后
    # 时间复杂度: O(n + m)
    # 空间复杂度: O(m)
    def two_index1(self, nums1, m, nums2, n):
        nums1_copy, nums1[:] = nums1[:m], []
        p1 = p2 = 0

        while p1 < m and p2 < n:
            if nums1_copy[p1] < nums2[p2]:
                nums1.append(nums1_copy[p1])
                p1 += 1
            else:
                nums1.append(nums2[p2])
                p2 += 1

        if p1 < m:
            nums1[p1 + p2:] = nums1_copy[p1:]
        if p2 < n:
            nums1[p1 + p2:] = nums2[p2:]

    # 3 双指针 / 从后往前
    # 时间复杂度: O(n + m)
    # 空间复杂度: O(1)
    def two_index2(self, nums1, m, nums2, n):
        p1, p2, p = m - 1, n - 1, m + n - 1
        while p1 >= 0 and p2 >= 0:
            if nums1[p1] > nums2[p2]:
                nums1[p] = nums1[p1]
                p1 -= 1
            else:
                nums1[p] = nums2[p2]
                p2 -= 1
            p -= 1

        if p2 != -1:  # if p2 left
            nums1[:p2 + 1] = nums2[:p2 + 1]

    # 方法3 改进版
    def two_index3(self, nums1, m, nums2, n):
        m, n = m - 1, n - 1

        while m >= 0 and n >= 0:
            if nums1[m] > nums2[n]:
                nums1[m + n + 1] = nums1[m]
                m -= 1
            else:
                nums1[m + n + 1] = nums2[n]
                n -= 1

        if n != -1:  # nums2 is still left
            nums1[:n + 1] = nums2[:n + 1]


if __name__ == '__main__':
    n1 = [1, 2, 3, 0, 0, 0]
    n2 = [2, 5, 6]
    s = Solution()
    s.two_index2(n1, 3, n2, 3)
    print(n1)
