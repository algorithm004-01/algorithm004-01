import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_200_NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new LeetCode_200_NumberOfIslands().new Solution();
        char[][] grid = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        assert solution.numIslands(grid) == 3;
        grid = new char[][] {
            {'1','0','0','1','1','1','0','1','1','0','0','0','0','0','0','0','0','0','0','0'},
            {'1','0','0','1','1','0','0','1','0','0','0','1','0','1','0','1','0','0','1','0'},
            {'0','0','0','1','1','1','1','0','1','0','1','1','0','0','0','0','1','0','1','0'},
            {'0','0','0','1','1','0','0','1','0','0','0','1','1','1','0','0','1','0','0','1'},
            {'0','0','0','0','0','0','0','1','1','1','0','0','0','0','0','0','0','0','0','0'},
            {'1','0','0','0','0','1','0','1','0','1','1','0','0','0','0','0','0','1','0','1'},
            {'0','0','0','1','0','0','0','1','0','1','0','1','0','1','0','1','0','1','0','1'},
            {'0','0','0','1','0','1','0','0','1','1','0','1','0','1','1','0','1','1','1','0'},
            {'0','0','0','0','1','0','0','1','1','0','0','0','0','1','0','0','0','1','0','1'},
            {'0','0','1','0','0','1','0','0','0','0','0','1','0','0','1','0','0','0','1','0'},
            {'1','0','0','1','0','0','0','0','0','0','0','1','0','0','1','0','1','0','1','0'},
            {'0','1','0','0','0','1','0','1','0','1','1','0','1','1','1','0','1','1','0','0'},
            {'1','1','0','1','0','0','0','0','1','0','0','0','0','0','0','1','0','0','0','1'},
            {'0','1','0','0','1','1','1','0','0','0','1','1','1','1','1','0','1','0','0','0'},
            {'0','0','1','1','1','0','0','0','1','1','0','0','0','1','0','1','0','0','0','0'},
            {'1','0','0','1','0','1','0','0','0','0','1','0','0','0','1','0','1','0','1','1'},
            {'1','0','1','0','0','0','0','0','0','1','0','0','0','1','0','1','0','0','0','0'},
            {'0','1','1','0','0','0','1','1','1','0','1','0','1','0','1','1','1','1','0','0'},
            {'0','1','0','0','0','0','1','1','0','0','1','0','1','0','0','1','0','0','1','1'},
            {'0','0','0','0','0','0','1','1','1','1','0','1','0','0','0','1','1','0','0','0'}
        };
        assert solution.numIslands(grid) == 58;
        // TODO bfs 的解法，结果比答案少一个，不知道错在什么地方。老师看到了烦请指点一下。
        // TODO bfs 的解法，结果比答案少一个，不知道错在什么地方。老师看到了烦请指点一下。
        // TODO bfs 的解法，结果比答案少一个，不知道错在什么地方。老师看到了烦请指点一下。
    }


    class Solution {
        public int numIslands(char[][] grid) {

            if (grid == null || grid.length == 0) return 0;

            int res = 0;

            int height = grid.length;
            int width = grid[0].length;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (grid[i][j] == '1') {
                        bfs(i, j, width, height, grid);
                        res++;
                    }
                }
            }
            return res;
        }

        private void bfs(int i, int j, int width, int height, char[][] grid) {

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i * width + j);
            while (!queue.isEmpty()) {
                Integer index = queue.poll();
                int x = index / width;
                int y = index % width;
                if (x < height && x >= 0 && width > y && y >= 0 && grid[x][y] == '1') {
                    grid[x][y] = '0';
                    queue.add((x + 1) * width + y);
                    queue.add(x * width + y + 1);
                    queue.add((x - 1) * width + y);
                    queue.add(x * width + y - 1);
                }
            }
        }
    }

    class Solution1 {
        public int numIslands(char[][] grid) {

            if (grid == null || grid.length == 0) return 0;

            int res = 0;

            int height = grid.length;
            int width = grid[0].length;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (grid[i][j] == '1') {
                        dfs(i, j, width, height, grid);
                        res++;
                    }
                }
            }
            return res;
        }

        private void dfs(int x, int y, int width, int height, char[][] grid) {

            if (x == height || x < 0 || width == y || y < 0 || grid[x][y] == '0') {
                return;
            }
            grid[x][y] = '0';
            dfs(x + 1, y, width, height, grid);
            dfs(x, y + 1, width, height, grid);
            dfs(x - 1, y, width, height, grid);
            dfs(x, y - 1, width, height, grid);
        }
    }

}