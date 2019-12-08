class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        int n = M.length;
        DisjointSet disjointSet = new DisjointSet(n);
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++){
                if (M[i][j] == 1) {
                    disjointSet.join(i, j);
                }
            }
        }
        return disjointSet.getCount();
    }
}
class DisjointSet {
    public int count;
    public int[] parent;

    public DisjointSet(int n) {
        this.count = n;
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // 查找根元素
    public int find(int p) {
        while(p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    // 合并
    public void join(int m, int n) {
        int rootM = find(m);
        int rootN = find(n);
        if (rootM != rootN) {
            parent[rootM] = rootN;
            count--;
        }
    }
    // 返回集合个数
    public int getCount(){
        return count;
    }
}