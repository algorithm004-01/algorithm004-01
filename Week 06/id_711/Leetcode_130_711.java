package Week6;

import java.util.HashSet;
import java.util.Set;

class UnionFindXO {
    private int[] parent;

    public UnionFindXO(char[][] board) {
        parent = new int[board.length * board[0].length];
        for (int i = 0; i < parent.length; i++) {
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
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }
}

public class Leetcode_130_711 {
    public static void main(String[] args) {
        char[][] board = {
                {'x','O','x','x'},
                {'O','X','O','x'},
                {'x','O','X','O'},
                {'O','X','O','x'},
                {'x','O','X','O'},
                {'O','X','O','x'}
        };
        new Leetcode_130_711().solve(board);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    int[] a = {0,0,1,-1};
    int[] b = {1,-1,0,0};

    /**
     * 并查集写法
     * 执行用时 :10 ms, 在所有 java 提交中击败了18.86%的用户
     * 内存消耗 :46 MB, 在所有 java 提交中击败了84.49%的用户
     * @param board
     */
    private void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        int n = board.length;
        int m = board[0].length;
        UnionFindXO union = new UnionFindXO(board);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    for (int k = 0; k < 4; k++) {
                        int x = i + a[k];
                        int y = j + b[k];
                        if (x >= 0 && x < n && y >= 0 && y < m && board[x][y] == 'O') {
                            union.union(i * m + j, x * m + y);
                        }
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                set.add(union.find(i * m));
            }
            if (board[i][m - 1] == 'O') {
                set.add(union.find(i * m + m - 1));
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[0][i] == 'O') {
                set.add(union.find(i));
            }
            if (board[n - 1][i] == 'O') {
                set.add(union.find((n - 1) * m + i));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !set.contains(union.find(i * m + j))) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
