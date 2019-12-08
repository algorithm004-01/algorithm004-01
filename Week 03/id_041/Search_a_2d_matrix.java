package search_a_2d_matrix;

import org.junit.Test;

class Solution {
    /**
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

     每行中的整数从左到右按升序排列。
     每行的第一个整数大于前一行的最后一个整数。

     输入:
     matrix = [
     [1,   3,  5,  7],
     [10, 11, 16, 20],
     [23, 30, 34, 50]
     ]
     target = 3
     输出: true


     * */
    static int row = 0;
    static int leftR = 0;
    public static boolean searchMatrix(int[][] matrix, int target) {
        /**
         * 自己的实现：先用二分搜索判断元素的范围在那个一行（数组）里；再二分搜索改行；
         * */
        if(matrix.length == 0) return false;
        leftR = 0;
        row = matrix.length-1;
        if(matrix[row].length==0) return false;
        int cols = matrix[row].length-1;
        if(matrix[row][cols] < target || matrix[0][0] > target ) return false;
        while (leftR <= row ){
            int mid = ( leftR + row )/2;
            if (matrix[mid][0] > target){
                row = mid - 1;
            }else if(matrix[mid][0] < target){
                leftR = mid + 1;
            }else {
                return true;
            }
        }
        int left = 0; int right = matrix[leftR-1].length-1;
        boolean result = false;
        while (left <= right){

            int mid = ( left + right )/2;
            if(matrix[leftR-1][mid] == target){
                return true;
            }else if(matrix[leftR-1][mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }

        }
        return result;

    }
    public static boolean searchMatrix2(int[][] matrix, int target) {
        /**
         * 官方题解：将二维数组视为一个有序的m * n个一维数组
         * */
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        int left = 0; int right = m * n -1;
        while (left <= right){
            int mid = (left + right)/2;
            int elm = matrix[mid / n][mid % n];
            if(elm == target) {
                return true;
            }else {
                if(elm < target){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

     public static void main(String[] args){
//        int[][] matrix = {{1,3,5,6,7},{9,11,12,15,16},{18,20,22,23,25}};
        int[][] matrix = {{}};
        boolean result = searchMatrix(matrix,3);
        System.out.println("row = " + row + " leftR= " + leftR + " result = " + result);
     }

}