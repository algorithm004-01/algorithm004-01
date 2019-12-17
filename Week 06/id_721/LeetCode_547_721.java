package tree;

/**
 * 题意：一个n*n的数组M，n代表一个班级的学生数，
 * M每个数字表示第i个学生和第j个学生是否为朋友关系，并且朋友关系可以传导；
 * 求这个M数组中，有多少个朋友圈
 * <p>
 * 思路：
 *
 * @date 2019/11/24 1:56 PM
 */
public class LeetCode_547_721 {

    /**
     * 深度优先
     */
    public int findCircleNumDFS(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] m, int[] visited, int i) {
        for (int j = 0; j < m.length; j++) {
            if (m[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(m, visited, j);
            }
        }
    }


    /**
     * 并查集
     */
    public int findCircleNumUnion(int[][] M) {
        int n = M.length;
        // 创建并查集
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 如果i和j是朋友关系，就合并i、j
                if (M[i][j] == 1)
                    uf.union(i, j);
            }
        }
        return uf.count;
    }

    class UnionFind {
        private int count = 0;
        private int[] parent;

        public UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
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
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }
    }
}
