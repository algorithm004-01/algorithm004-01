#Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties: 
#
# 
# Integers in each row are sorted from left to right. 
# The first integer of each row is greater than the last integer of the previous row. 
# 
#
# Example 1: 
#
# 
#Input:
#matrix = [
#  [1,   3,  5,  7],
#  [10, 11, 16, 20],
#  [23, 30, 34, 50]
#]
#target = 3
#Output: true
# 
#
# Example 2: 
#
# 
#Input:
#matrix = [
#  [1,   3,  5,  7],
#  [10, 11, 16, 20],
#  [23, 30, 34, 50]
#]
#target = 13
#Output: false 
# Related Topics Array Binary Search



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        # start = 0, end = m * n - 1
        # pivot = (start + end) // 2
        # row = pivot // n, col = pivot % n

        # edge case check
        if not matrix or not len(matrix[0]):
            return False

        m, n = len(matrix), len(matrix[0])
        start, end = 0, m*n-1
        while start <= end:
            mid = start + (end - start) // 2
            row, col = mid // n, mid % n
            pivot = matrix[row][col]
            if target == pivot:
                return True
            else:
                if target < pivot:
                    end = mid-1
                else:
                    start = mid+1
        return False
        
#leetcode submit region end(Prohibit modification and deletion)
