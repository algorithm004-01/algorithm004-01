/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;
        
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (target == matrix[row][col])
                return true;
            else if (target > matrix[row][col])
                row++;
            else {
                // col--;
                //这道题是参照了其中一个题解，通过每行最右边一个元素来查找，如果发现在这一行里就一个一个继续滚动
                //我突然觉得在最后这里可以再插入一个二分查找
                //结果是可以的，而且打败了100%的提交者，开心
                //不过这里也占用了一些内存，相当于用空间换时间了
                int left = 0, right = matrix[0].length - 2, mid = 0;
                while (left <= right) {
                    mid = (left + right) / 2;
                    if (target == matrix[row][mid])
                        return true;
                    else if (target > matrix[row][mid]){
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                return false;
            }   
        }
        return false;
    }
}
// @lc code=end

