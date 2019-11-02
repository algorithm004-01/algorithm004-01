class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if((matrix==null||matrix.length==0)||(matrix.length==1&&matrix[0].length==0)) return false;
        int left = 0;
		int right = 0;
		int l = 0;
		for (int i=0; i<matrix.length; i++) {
			if (target >= matrix[i][0]){
				right = matrix[i].length - 1;
				l = i;
			}
		}
		int mid = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			if (matrix[l][mid] == target) {
		    	return true;
		    }else if (matrix[l][mid] < target) {
		    	left = mid + 1;
		    }else{
		    	right = mid - 1;
		    }
		}
        return false;
    }
}
