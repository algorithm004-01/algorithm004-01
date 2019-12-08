package medium;

/**
 * @author 潘磊明
 * @date 2019/11/25
 */
public class FriendCircles {

    /**
     * 使用并查集
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        int len = M.length;
        UnionFind uf = new UnionFind(len);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }

    /**
     * 并查集
     */
    private class UnionFind {
        private int count; //数量
        private int[] parent; //父类集合

        UnionFind(int n) {
            count = n;
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
            parent[rootQ] = rootP;
            count--;
        }
    }

}
