//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 示例 1: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false 
// Related Topics 数组 二分查找

package leetcode.editor.cn;
//Java：搜索二维矩阵
public class P74SearchA2dMatrix{
    public static void main(String[] args) {
        Solution solution = new P74SearchA2dMatrix().new Solution();
        int[][] matrix = {
                { 1,  2,  3,   4  , 20 },
                { 5,  6,  7,   10  , 21 },
                { 9,  10, 11,  12 , 22 },
                { 13, 14, 15,  16 , 23 }
        };
        System.out.println(solution.searchMatrix(matrix,7));
        // TO TEST
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length-1;
        while (row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return true;
            } else if(matrix[row][col] > target){
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
