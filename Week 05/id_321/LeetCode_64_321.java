package week04;

public class MinPathSum64 {
	/*
	 * 二维数组动态规划 时间复杂度o(m*n) 空间复杂度o(m*n)
	 */
	public class Solution {
		public int minPathSum1(int[][] grid) {
			int[][] dp = new int[grid.length][grid[0].length];
			for (int i = grid.length - 1; i >= 0; i--) {
				for (int j = grid[0].length - 1; j >= 0; j--) {
					if (i == grid.length - 1 && j != grid[0].length - 1)
						dp[i][j] = grid[i][j] + dp[i][j + 1];
					else if (j == grid[0].length - 1 && i != grid.length - 1)
						dp[i][j] = grid[i][j] + dp[i + 1][j];
					else if (j != grid[0].length - 1 && i != grid.length - 1)
						dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
					else
						dp[i][j] = grid[i][j];
				}
			}
			return dp[0][0];
		}
	}

	/*
	 * 一维数组空间优化
	 */
	public int minPathSum2(int[][] grid) {
		int[] dp = new int[grid[0].length];
		for (int i = grid.length - 1; i >= 0; i--) {
			for (int j = grid[0].length - 1; j >= 0; j--) {
				if (i == grid.length - 1 && j != grid[0].length - 1)
					dp[j] = grid[i][j] + dp[j + 1];
				else if (j == grid[0].length - 1 && i != grid.length - 1)
					dp[j] = grid[i][j] + dp[j];
				else if (j != grid[0].length - 1 && i != grid.length - 1)
					dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
				else
					dp[j] = grid[i][j];
			}
		}
		return dp[0];
	}

	/*
	 * 不需要额外的空间
	 */
	public int minPathSum3(int[][] grid) {
		for (int i = grid.length - 1; i >= 0; i--) {
			for (int j = grid[0].length - 1; j >= 0; j--) {
				if (i == grid.length - 1 && j != grid[0].length - 1)
					grid[i][j] = grid[i][j] + grid[i][j + 1];
				else if (j == grid[0].length - 1 && i != grid.length - 1)
					grid[i][j] = grid[i][j] + grid[i + 1][j];
				else if (j != grid[0].length - 1 && i != grid.length - 1)
					grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
			}
		}
		return grid[0][0];
	}

}
