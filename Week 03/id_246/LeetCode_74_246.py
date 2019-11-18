'''
search-a-2d-matrix_74

编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。
示例 1:

输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
 ]
target = 3
输出: true

'''

def searchMatrix(matrix):
    m = len(matrix)
    if m == 0:
        return False
    n = len(matrix[0])

    left, right = 0, m*n-1
    while left<=right:
        pivot_idx = (left+right)//2
        pivot_element = matrix[pivot_idx//n][pivot_idx%n]
        if target == pivot_element:
            return True
        else:
            if target < pivot_element:
                right = pivot_idx - 1
            else:
                left = pivot_idx + 1
    return False