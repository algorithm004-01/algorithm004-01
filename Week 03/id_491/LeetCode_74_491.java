class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            int row = mid / matrix[0].length;
            int column = mid % matrix[0].length;
            if(matrix[row][column] < target){
                left = mid + 1;
            } else if(matrix[row][column] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
