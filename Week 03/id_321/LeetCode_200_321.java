package week03;

public class NumIslands200 {
/*
 * ����1.dfs��ÿ������1����½��ʱ��������++��ͬʱ����Ԫ����Χ������������½����0��
 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

	void dfs(char[][] grid, int r, int c) {
		int nr = grid.length;
		int nc = grid[0].length;

		if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
			return;
		}

		grid[r][c] = '0';
		dfs(grid, r - 1, c);
		dfs(grid, r + 1, c);
		dfs(grid, r, c - 1);
		dfs(grid, r, c + 1);
	}

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int nr = grid.length;
		int nc = grid[0].length;
		int sum = 0;
		for (int r = 0; r < nr; ++r) {
			for (int c = 0; c < nc; ++c) {
				if (grid[r][c] == '1') {
					++sum;
					dfs(grid, r, c);
				}
			}
		}

		return sum;
	}
}
