package sf.week6;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LynnSun on 2019/11/24.
 * 更优版
 */
public class ShortestPathBinaryMatrixOther {
    private class State {
        int i;
        int j;

        public State(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static final int[][] direc = new int[][]{{1,0},{-1,0},{1,1},{-1,1}, {0,1},{1,-1},{-1,-1},{0,-1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0) {
            return -1;
        }

        if (grid.length == 1) {
            return grid[0][0] == 0 ? 1 : -1;
        }

        final int N = grid.length;

        if ((grid[0][0] == 1) || (grid[N-1][N-1] == 1)) {
            return -1;
        }

        List<State> startSta = new ArrayList<>(N*N);
        List<State> endSta = new ArrayList<>(N*N);
        startSta.add(new State(0, 0));
        endSta.add(new State(N-1, N-1));

        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;
        visited[N-1][N-1] = true;

        boolean[][] startVisited = new boolean[N][N];
        boolean[][] endVisited = new boolean[N][N];
        startVisited[0][0] = true;
        endVisited[N-1][N-1] = true;

        int len = 1;

        while (!startSta.isEmpty() && !endSta.isEmpty()) {

            if (startSta.size() > endSta.size()) {
                List<State> tmp = startSta; startSta = endSta; endSta = tmp;
                boolean[][] tmpA = startVisited; startVisited = endVisited; endVisited = tmpA;
            }

            List<State> newStaSet = new ArrayList<>();
            for (State curSta : startSta) {
                int i = curSta.i, j = curSta.j;
                for (int[] pos : direc) {
                    int new_i = i + pos[0], new_j = j + pos[1];
                    if (new_i >= 0 && new_i < N && new_j >= 0 && new_j < N && grid[new_i][new_j] == 0) {
                        State newSta = new State(new_i, new_j);

                        if (endVisited[newSta.i][newSta.j]) {
                            return len + 1;
                        }

                        if (visited[newSta.i][newSta.j]) {
                            continue;
                        }

                        newStaSet.add(newSta);
                        visited[newSta.i][newSta.j] = true;
                        startVisited[newSta.i][newSta.j] = true;
                    }
                }
            }

            startSta = newStaSet;
            len++;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestPathBinaryMatrixOther().shortestPathBinaryMatrix(new int[][]
                {{0,0,1,0,0,0,0},
                        {0,1,0,0,0,0,1},
                        {0,0,1,0,1,0,0},
                        {0,0,0,1,1,1,0},
                        {1,0,0,1,1,0,0},
                        {1,1,1,1,1,0,1},
                        {0,0,1,0,0,0,0}}));
    }
}
