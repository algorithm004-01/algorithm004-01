class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int zeroCount = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0'){
                    zeroCount++;
                }
            }
        }
        Disjoint disjoint = new Disjoint(rows * cols);
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        disjoint.join(i * cols + j, (i - 1) * cols + j);
                    }
                    if (i + 1 < rows && grid[i + 1][j] == '1') {
                        disjoint.join(i * cols + j, (i + 1) * cols + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        disjoint.join(i * cols + j, i * cols + j - 1);
                    }
                    if (j + 1 < cols && grid[i][j + 1] == '1') {
                        disjoint.join(i * cols + j, i * cols + j + 1);
                    }
                }
            }
        }
        return disjoint.getCount() - zeroCount;
    }
}

class Disjoint {
    private int[] parent;
    private int count;

    public Disjoint(int n){
        this.count = n;
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while(p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void join(int m, int n) {
        int rootM = find(m);
        int rootN = find(n);
        if (rootM != rootN) {
            parent[rootM] = rootN;
            count--;
        }
    }

    public int getCount() {
        return count;
    }

}