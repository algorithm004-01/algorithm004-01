class Solution {
    private int count;
    public int totalNQueens(int n) {
        recursion(0, n, 0, 0, 0);
        return this.count;
    }

    void recursion(int current, int n, int lie, int pie, int na) {
        if (current == n) {
            this.count++;
        }

        for (int i = 0; i < n; i++) {
            if ((lie & (1 << i)) == 0 && (pie & (1 << (i + current))) == 0 && (na & ( 1 << (current + n - 1 - i))) == 0) {
                recursion(current + 1, n, lie + (1 << i), pie + (1 << (i + current)), na + (1 << (current + n - 1 - i)));
            }
        }

    }
}
