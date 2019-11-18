import java.util.*;
/**
 * 搜索二维矩阵
 */
public class Solution {
    /**
     * 搜索二维矩阵
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        for (int[] ints : matrix) {
            if (target >= ints[0] && target <= ints[ints.length - 1]) {
                int left = 0;
                int right = ints.length - 1;
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (ints[mid] == target)
                        return true;
                    if (ints[mid] < target)
                        left = mid + 1;
                    else
                        right = mid - 1;
                }
                break;
            }
        }
        return false;
    }
}