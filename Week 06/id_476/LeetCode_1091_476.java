//在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。 
//
// 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成： 
//
// 
// 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角） 
// C_1 位于 (0, 0)（即，值为 grid[0][0]） 
// C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]） 
// 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0） 
// 
//
// 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：[[0,1],[1,0]]
//
//输出：2
//
// 
//
// 示例 2： 
//
// 输入：[[0,0,0],[1,1,0],[1,1,0]]
//
//输出：4
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length == grid[0].length <= 100 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 广度优先搜索

package com.markdown.leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LeetCode_1091_ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        Solution solution = new LeetCode_1091_ShortestPathInBinaryMatrix().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {

            if (grid == null || grid.length == 0) {
                return 0;
            }
            int N = grid.length;
            if (grid[0][0] == 1 || grid[N - 1][N - 1] == 1) {
                return -1;
            }
            return BFS(grid);
        }

        private int BFS(int[][] grid) {

            int N = grid.length;
            int end = N * N - 1;
            int distance = 0;
            int[][] direction = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);
            Set<Integer> visited = new HashSet<>();
            while (!queue.isEmpty()) {
                distance++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer index = queue.poll();
                    if (index == end) return distance;
                    visited.add(index);
                    int x = index / N;
                    int y = index % N;
                    for (int[] dir : direction) {
                        int n_x = x + dir[0];
                        int n_y = y + dir[1];
                        int n_index = n_x * N + n_y;
                        if (n_x >= 0 && n_x <= N - 1 && n_y >= 0 && n_y <= N - 1 && !visited.contains(n_index) && grid[n_x][n_y] == 0) {
                            queue.offer(n_index);
                        }
                    }
                    /*if (x > 0 && y > 0 && !visited.contains((x - 1) * N + y - 1) && grid[x - 1][y - 1] == 0) {
                        queue.offer((x - 1) * N + y - 1);
                    }
                    if (x > 0 && y >= 0 && !visited.contains((x - 1) * N + y) && grid[x - 1][y] == 0) {
                        queue.offer((x - 1) * N + y);
                    }
                    if (x > 0 && y < N - 1 && !visited.contains((x - 1) * N + y + 1) && grid[x - 1][y + 1] == 0) {
                        queue.offer((x - 1) * N + y + 1);
                    }
                    if (x >= 0 && y > 0 && !visited.contains((x) * N + y - 1) && grid[x][y - 1] == 0) {
                        queue.offer((x) * N + y - 1);
                    }
                    if (x >= 0 && y < N - 1 && !visited.contains((x) * N + y + 1) && grid[x][y + 1] == 0) {
                        queue.offer((x) * N + y + 1);
                    }
                    if (x < N - 1 && y > 0 && !visited.contains((x + 1) * N + y - 1) && grid[x + 1][y - 1] == 0) {
                        queue.offer((x + 1) * N + y - 1);
                    }
                    if (x < N - 1 && y >= 0 && !visited.contains((x + 1) * N + y) && grid[x + 1][y] == 0) {
                        queue.offer((x + 1) * N + y);
                    }
                    if (x < N - 1 && y < N - 1 && !visited.contains((x + 1) * N + y + 1) && grid[x + 1][y + 1] == 0) {
                        queue.offer((x + 1) * N + y + 1);
                    }*/
                }

            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}