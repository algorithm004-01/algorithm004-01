class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row_num = matrix.length;
        int col_num = matrix[0].length;

        int begin = 0;
        int end = row_num * col_num - 1;

        while(begin <= end){
            int mid = (begin + end) / 2;
            int mid_value = matrix[mid/col_num][mid%col_num];

            if(mid_value == target){
                retunr true;
            }else if(mid_value < target){
                begin = mid + 1;
            }else{
                end = mid - 1;
            }

        }
        return false;
    }
}