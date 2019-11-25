package week06;

public class FindCircleNum547two {

	public int findCircleNum1(int[][] M) {
		int n = M.length;
		Unionimpl un = new Unionimpl(n);
		for (int i = 0; i < M.length - 1; i++) {
			for (int j = i + 1; j < M.length; j++) {
				if (M[i][j] == 1) {
					un.union(i, j);
				}
			}
		}
		return un.count();
	}
}

class Unionimpl {
	private int count = 0;
	private int[] parent;

	public Unionimpl(int n) {
		count = n;
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	public int count() {
		
		return count;
	}

	public int find(int p) {
		while (p != parent[p]) {
			parent[p] = parent[parent[p]];
			p = parent[p];
		}
		return p;
	}

	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ) {
			return;
		}
		parent[rootP] = rootQ;
		count--;
	}
}