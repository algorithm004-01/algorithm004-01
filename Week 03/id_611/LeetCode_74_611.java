/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;

        int left = 0, right = n*m -1;
        int pivotIdx , pivotElement;
        while(left <= right){
            pivotIdx  = (left + right)/2;
            //privotIdx / n = 得到第几行 ，pivotIdx % n = 得到第几列
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if(target == pivotElement) return true;
            else{
                if(target < pivotElement) right = pivotIdx -1;
                else left = pivotIdx + 1;
            }
        }
        return false;
    }
}
// @lc code=end

