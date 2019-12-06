/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-03 11:53
 **/

public class Leetcode_74_371 {

    public static void main(String[] args) {
//        int[][] martrix = {};
        int[][] martrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        boolean res = searchMatrix(martrix, 51);
        System.out.println("res = " + res);
    }
    /**
     * 原解1:2次二分搜素
     *
     * @author Shaobo.Qian
     * @date 2019/11/3
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        //0.处理边界值
        if(matrix==null ||  matrix.length == 0 || matrix[0].length == 0 ||  target < matrix[0][0]) return false;
        //1.先确定在哪一行
        int rMinIndex = 0;
        int rMaxIndex = matrix.length - 1;
        int rMidIndex = 0;
        // 如果没有搜索到target,出循环后,target肯定matrix[rMaxIndex]这一行
        while (rMinIndex <= rMaxIndex) {
            rMidIndex = rMinIndex + (rMaxIndex - rMinIndex) / 2;
            if (matrix[rMidIndex][0] == target) {
                return true;
            } else if (matrix[rMidIndex][0] < target) {
                rMinIndex = rMidIndex + 1;
            } else {
                rMaxIndex = rMidIndex - 1;
            }
        }
        int cMinIndex = 0;
        int cMaxIndex = matrix[0].length - 1;
        int cMidIndex = 0;
        while (cMinIndex <= cMaxIndex) {
            cMidIndex = cMinIndex + (cMaxIndex - cMinIndex) / 2;
            if (matrix[rMaxIndex][cMidIndex] == target) {
                return true;
            } else if (matrix[rMaxIndex][cMidIndex] < target) {
                cMinIndex = cMidIndex + 1;
            } else {
                cMaxIndex = cMidIndex - 1;
            }
        }

        return false;
    }
}
