package week06;

public class NumIslands200 {

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int nr = grid.length;
		int nc = grid[0].length;
		
		UnionFind uf = new UnionFind(grid);
		for (int r = 0; r < nr; ++r) {
			for (int c = 0; c < nc; ++c) {
				if (grid[r][c] == '1') {
					grid[r][c] = '0';
					if (r - 1 >= 0 && grid[r - 1][c] == '1') {
						uf.union(r * nc + c, (r - 1) * nc + c);
					}
					if (r + 1 < nr && grid[r + 1][c] == '1') {
						uf.union(r * nc + c, (r + 1) * nc + c);
					}
					if (c - 1 >= 0 && grid[r][c - 1] == '1') {
						uf.union(r * nc + c, r * nc + c - 1);
					}
					if (c + 1 < nc && grid[r][c + 1] == '1') {
						uf.union(r * nc + c, r * nc + c + 1);
					}
				}
			}
		}

		return uf.getCount();
	}
}

class UnionFind {
	int count; 
	int[] parent;
	int[] rank;

	public UnionFind(char[][] grid) { 
		count = 0;
		int m = grid.length;
		int n = grid[0].length;
		parent = new int[m * n];
		rank = new int[m * n];
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] == '1') {
					parent[i * n + j] = i * n + j;
					++count;
				}
				rank[i * n + j] = 0;
			}
		}
	}

	public int find(int i) { 
		if (parent[i] != i)
			parent[i] = find(parent[i]);
		return parent[i];
	}

	public void union(int x, int y) { 
		int rootx = find(x);
		int rooty = find(y);
		if (rootx != rooty) {
			if (rank[rootx] > rank[rooty]) {
				parent[rooty] = rootx;
			} else if (rank[rootx] < rank[rooty]) {
				parent[rootx] = rooty;
			} else {
				parent[rooty] = rootx;
				rank[rootx] += 1;
			}
			--count;
		}
	}

	public int getCount() {
		return count;
	}
}
