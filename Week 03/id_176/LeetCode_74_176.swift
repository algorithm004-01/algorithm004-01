/*
 * @lc app=leetcode.cn id=74 lang=swift
 *
 * [74] 搜索二维矩阵
 *
 * https://leetcode-cn.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (35.90%)
 * Likes:    95
 * Dislikes: 0
 * Total Accepted:    20.5K
 * Total Submissions: 56.6K
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,50]]\n3'
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 
 * 
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * 
 */

// @lc code=start
class Solution {

    // 沿左下方向查找
    // func searchMatrix(_ matrix: [[Int]], _ target: Int) -> Bool {
    //     let rowSize = matrix.count
    //     guard rowSize > 0 else {
    //         return false
    //     }
        
    //     let colSize = matrix[0].count
    //     var row = 0, col = colSize - 1
        
    //     while row < rowSize && col >= 0 {
    //         let element = matrix[row][col]
    //         if element < target {
    //             row += 1
    //         } else if (element > target) {
    //             col -= 1
    //         } else {
    //             return true
    //         }
    //     }
        
    //     return false
    // }

    //二分法
    func searchMatrix(_ matrix: [[Int]], _ target: Int) -> Bool {
        let rowSize = matrix.count
        guard rowSize > 0 else {
            return false
        }

        let colSize = matrix[0].count
        var low = 0, high = rowSize * colSize - 1
        while low <= high {
            let mid = low + (high - low) / 2
            let element = matrix[mid / colSize][mid % colSize]
            if element < target {
                low = mid + 1
            } else if (element > target) {
                high = mid - 1
            } else {
                return true
            }
        }

        return false
    }
}
// @lc code=end

