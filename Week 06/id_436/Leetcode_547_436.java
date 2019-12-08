class UnionfindSet {
    public int[] parents;
    public int[] ranks;
    public int count;

    public UnionfindSet(int n){
        parents = new int[n];
        ranks = new int[n];
        count = n;
        for (int i = 0; i < parents.length; ++i) {
            parents[i] = i;
            ranks[i] = 1;
        }
    }

    public int find(int u) {
        if (parents[u] != u) {
            parents[u] = find(parents[u]);
        }
        return parents[u];
    }

    public boolean Union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) {
            return false;
        }
        if (ranks[pu] > ranks[pv]) {
            parents[pv] = pu;
        }
        else if (ranks[pu] < ranks[pv]) {
            parents[pu] = pv;
        }
        else {
            parents[pu] = pv;
            ranks[pv]++;
        }
        count--;
        return true;
    }
}

class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionfindSet uf = new UnionfindSet(n);
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (M[i][j] == 1) {
                    uf.Union(i, j);
                }
            }
        }
        return uf.count;
    }
}
