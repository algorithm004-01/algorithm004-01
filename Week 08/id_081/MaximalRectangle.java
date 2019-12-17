class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] diagram = new int[row][col];
        for (int i = 0; i < row; ++i)
            for (int j = 0; j < col; ++j) {
                if (i == 0) {
                    diagram[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    diagram[i][j] = matrix[i][j] == '1' ? diagram[i - 1][j] + 1: 0;
                }
            } 
            
        int maxArea = 0;
        for(int i = 0; i < row; ++i) {
            int partMax = largestRectangleArea(diagram[i]);
            maxArea = Math.max(partMax, maxArea);
        }
        
        return maxArea;
    }


    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) 
            return 0;
        
        int[] lessFromLeft = new int[height.length]; 
        int[] lessFromRight = new int[height.length]; 
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;
    
        for (int i = 1; i < height.length; i++) {
            int p = i - 1;
    
            while (p >= 0 && height[p] >= height[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }
    
        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;
    
            while (p < height.length && height[p] >= height[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }
    
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }
    
        return maxArea;
    }
}
