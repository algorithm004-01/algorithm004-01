package Week6;

class UnionFind {
    private int count = 0;
    private int[] parent;
    public UnionFind(int n) {
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

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY)
            return;
        parent[rootX] = rootY;
        count--;
    }

    public int getCount() {
        return this.count;
    }
}
public class Leetcode_547_711 {
    public static void main(String[] args) {
        int[][] M = {
            {1,1,0},
            {1,1,0},
            {0,0,1}
        };
        System.out.println(findCircleNum(M));
    }

    private static int findCircleNum(int[][] M  ) {
        int n = M.length;
        UnionFind union = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i == j) continue;
                if (M[i][j] == 1) {
                    union.union(i,j);
                }
            }
        }
        return union.getCount();
    }
}
