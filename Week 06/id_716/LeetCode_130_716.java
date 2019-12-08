import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_130_716 {
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    // 1. dfs
    public void solve1(char[][] board) {
        if (board.length == 0) return;
        int rows = board.length, cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    if (board[i][j] == 'O')
                        dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (board[i][j] == 'X' || board[i][j] == '#') return;

        board[i][j] = '#';
        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length)
                dfs(board, x, y);
        }
    }

    // 2. dfs 非递归
    private int rows;
    private int cols;

    public void solve2(char[][] board) {
        if (board.length == 0) return;
        rows = board.length;
        cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    if (board[i][j] == 'O')
                        dfs2(board, i * cols + j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private void dfs2(char[][] board, int pos) {
        int row = pos / cols, col = pos % cols;
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(pos);
        board[row][col] = '#';
        while (!stack.isEmpty()) {
            int curr = stack.peekFirst();
            row = curr / cols;
            col = curr % cols;

            boolean hasMore = false;
            for (int k = 0; k < dx.length; k++) {
                int x = row + dx[k], y = col + dy[k];
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length
                        && board[x][y] == 'O') {
                    stack.addFirst(x * cols + y);
                    board[x][y] = '#';
                    hasMore = true;
                }
            }
            if (!hasMore)
                stack.removeFirst();
        }
    }

    // 3. bfs
    public void solve3(char[][] board) {
        if (board.length == 0) return;
        rows = board.length;
        cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    if (board[i][j] == 'O')
                        bfs(board, i * cols + j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private void bfs(char[][] board, int pos) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(pos);
        int row = pos / cols, col = pos % cols;
        board[row][col] = '#';
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer curr = queue.poll();
                row = curr / cols;
                col = curr % cols;
                for (int j = 0; j < dx.length; j++) {
                    int x = row + dx[j], y = col + dy[j];
                    if (x >= 0 && x < board.length && y >= 0 && y < board[0].length
                            && board[x][y] == 'O') {
                        queue.offer(x * cols + y);
                        board[x][y] = '#';
                    }
                }
            }
        }
    }

    // 4. Disjoint set
    public void solve4(char[][] board) {
        if (board.length == 0) return;
        rows = board.length;
        cols = board[0].length;

        UnionFind uf = new UnionFind(rows * cols + 1);
        int dummy = rows * cols;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (board[row][col] == 'O') {
                    if (row == 0 || col == 0 || row == rows - 1 || col == cols - 1) {
                        uf.union(row * cols + col, dummy);
                    } else {
                        for (int i = 0; i < dx.length; i++) {
                            int x = row + dx[i], y = col + dy[i];
                            if (x >= 0 && x < rows && y >= 0 && y < cols && board[x][y] == 'O')
                                uf.union(row * cols + col, x * cols + y);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (uf.isConnected(i * cols + j, dummy)) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
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
            if (rootP != rootQ) {
                // union
                parent[rootQ] = rootP;
            }
        }

        public boolean isConnected(int p, int dummy) {
            return find(p) == find(dummy);
        }
    }
}