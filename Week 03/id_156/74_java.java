    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {return false;}
        int n = matrix[0].length;

        /*二分查找*/
        int left = 0;
        int right = m * n -1;
        int midIndex;
        int midValue;

        while(left <= right) {
            midIndex = (left + right) / 2;
            midValue = matrix[midIndex / n][midIndex % n];
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = midIndex + 1;
            } else {
                right = midIndex - 1;
            }
        }
        return false;
    }
