    public int maximalSquare(char[][] matrix) {   
        int row = matrix.length, col = row > 0 ? matrix[0].length : 0;
        int[][] dp = new int[row+1][col+1];
        int maxLen = 0;
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                    // 更新当前最大边长
                    maxLen = Math.max(dp[i][j],maxLen);
                }
            }
        } 
        return maxLen * maxLen;
    }