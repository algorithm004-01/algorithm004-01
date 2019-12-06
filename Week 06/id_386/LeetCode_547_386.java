class Solution {
    private int[] parent;
    // 并查集
    public int findCircleNum(int[][] M) {
        int N = M.length;
        parent = new int[N];
        // 默认初始化-1自己为根
        Arrays.fill(parent, -1);

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (M[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        // 查找所有的根(值为-1)的个数即为集合的个数
        int cnt = 0;
        for (int id : parent) {
            if (id == -1)
                cnt++;
        }
        return cnt;
    }

    private void union(int x, int y) {
        int xp = findRoot(x);
        int yp = findRoot(y);
        if (xp != yp)  // 如果已经在同一个集合中则不必合并
            parent[yp] = xp;
    }

    private int findRoot(int id) {
        if (parent[id] == -1)
            return id;
        parent[id] = findRoot(parent[id]); // 路径压缩
        return parent[id];
    }
}
