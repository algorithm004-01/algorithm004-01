public class LeetCode_74_SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new LeetCode_74_SearchA2dMatrix().new Solution();
        assert !solution.searchMatrix(new int[][]{{1}, {3}}, 2);
    }


    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {

            if (matrix.length == 0 || matrix[0].length == 0) return false;
            int height = matrix.length;
            int width = matrix[0].length;

            int low = 0;
            int high = height * width - 1;
            while (low < high) {
                int middle = low + (high - low) / 2;
                int x = middle / width;
                int y = middle % width;
                if (matrix[x][y] < target) {
                    low = middle + 1;
                } else {
                    high = middle;
                }
            }
            return matrix[low / width][low % width] == target;
        }
    }

}