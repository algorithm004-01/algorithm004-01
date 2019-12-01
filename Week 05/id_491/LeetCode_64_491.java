class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] memo = new int[row + 1][column + 1];
        for(int i = row - 1; i >= 0; i--) {
            for(int j = column - 1; j >= 0; j--) {
                if(i == row - 1 || j == column - 1) {
                    memo[i][j] = memo[i + 1][j] + memo[i][j + 1] + grid[i][j];
                } else {
                    memo[i][j] = Math.min(memo[i + 1][j], memo[i][j + 1]) + grid[i][j];
                }
            } 
        }

        return memo[0][0];
    }
}
