class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        UnionFind union = new UnionFind(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if(M[i][j] == 1) {
                    union.union(i, j);
                    if(union.count == 1) {
                        return 1;
                    }
                }
            }
        }

        return union.count;
    }

    class UnionFind {
        public int count;
        private int[] parent;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            int temp = p;
            while (parent[temp] != temp) {
                parent[temp] = parent[parent[temp]];
                temp = parent[temp];
            }
            return temp;
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
}
