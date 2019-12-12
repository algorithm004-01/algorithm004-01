class Solution {
    private int count;
    public int totalNQueens(int n) {
        int size = (1 << n) - 1;
        count = 0;
        dfs(0, 0, 0, size);
        return count;
    }

    public void dfs(int row, int pie, int na, int size) {
        if (row == size) {
            count++;
            return;
        }

        int pos = size & (~(row | pie | na));
        while (pos != 0) {
            int p = pos & (-pos);
            pos -= p;
            dfs(row | p, (pie | p) >> 1, (na | p) << 1, size);
        }
    }
}