package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 潘磊明
 * @date 2019/11/26
 */
public class SurroundedRegions {
    /**
     * DFS
     * @param board
     */
//    public void solve(char[][] board) {
//        if (board.length == 0) return;
//        for (int i = 0; i < board.length; i++) {
//            if (board[i][0] == 'O') _dfs(board, i, 0);
//            if (board[i][board[0].length - 1] == 'O') _dfs(board, i, board[0].length - 1);
//        }
//        for (int j = 0; j < board[0].length; j++) {
//            if (board[0][j] == 'O') _dfs(board, 0, j);
//            if (board[board.length - 1][j] == 'O') _dfs(board, board.length - 1, j);
//        }
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if (board[i][j] == 'O') board[i][j] = 'X';
//                else if (board[i][j] == '*') board[i][j] = 'O';
//            }
//        }
//    }
//
//    private void _dfs(char[][] board, int i, int j){
//        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1
//                || board[i][j] == 'X' || board[i][j] == '*') return;
//        board[i][j] = '*';
//        _dfs(board, i + 1, j);
//        _dfs(board, i - 1, j);
//        _dfs(board, i, j + 1);
//        _dfs(board, i, j - 1);
//    }


    /**
     * 使用并查集
     * @param board
     */
    public void solve(char[][] board) {
        int row = board.length;
        if (row == 0) return;
        int col = board[0].length;
        UnionFind uf = new UnionFind(board);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    int tmpBoard = i * col + j;
                    if (i == 0 || i == row - 1 || j == 0 || j == col - 1)
                        uf.unionSet(row * col, tmpBoard);
                    else {
                        if (board[i + 1][j] == 'O') uf.unionSet(tmpBoard, (i + 1) * col + j);
                        if (board[i - 1][j] == 'O') uf.unionSet(tmpBoard, (i - 1) * col + j);
                        if (board[i][j - 1] == 'O') uf.unionSet(tmpBoard, i * col + j - 1);
                        if (board[i][j + 1] == 'O') uf.unionSet(tmpBoard, i * col + j + 1);
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ( board[i][j] == 'O' && uf.find(i * col + j) != uf.find( row * col)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    class UnionFind {
        int[] parent;

        UnionFind (char[][] board) {
            int row = board.length;
            int col = board[0].length;
            parent = new int[row * col + 1];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'O') {
                        int val = i * col + j;
                        parent[val] = val;
                    }
                }
            }
            parent[row * col] = row * col;
        }

        int find (int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        void unionSet(int p, int q) {
            int rootp = find(p);
            int rootq = find(q);
            if (rootp != rootq) {
                parent[rootq] = rootp;
            }
        }
    }
}
