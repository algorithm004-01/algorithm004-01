package week03;

public class LeetCode_74_696 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            throw new IllegalArgumentException();
        }
        int len = matrix[0].length;

        int left = 0, right = matrix.length * len - 1;
        int pivotIdx;
        int pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / len][pivotIdx % len];
            if (target == pivotElement) {
                return true;
            } else {
                if (target < pivotElement) {
                    right = pivotIdx - 1;
                } else {
                    left = pivotIdx + 1;
                }
            }
        }
        return false;
    }
}
