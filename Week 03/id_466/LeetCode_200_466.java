//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
//
// 示例 1:
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
//
//
// 示例 2:
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
//
// Related Topics 深度优先搜索 广度优先搜索 并查集
package com.aseara.leetcode.editor.cn.a200;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * desc: 200.岛屿数量 <br />
 * Date: 2019/11/3 <br/>
 *
 * @author qiujingde
 */
class NumberOfIslands {
    private Solution solution = new Solution();

    @Test
    void test1() {
        char[][] island = new char[][] {
                new char[] {'1','1','1','1','0'},
                new char[] {'1','1','0','1','0'},
                new char[] {'1','1','0','0','0'},
                new char[] {'0','0','0','0','0'}
        };
        assertEquals(1, solution.numIslands(island));

        island = new char[][] {
                new char[] {'1','1','0','0','0'},
                new char[] {'1','1','0','0','0'},
                new char[] {'0','0','1','0','0'},
                new char[] {'0','0','0','1','1'}
        };
        assertEquals(3, solution.numIslands(island));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    cnt ++;
                    destroyIsland(grid, i, j);
                }
            }
        }
        return cnt;
    }

    private void destroyIsland(char[][] grid, int x, int y) {
        grid[x][y] = '0';

        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
            destroyIsland(grid, x - 1, y);
        }

        if (x + 1 < grid.length && grid[x + 1][y] == '1') {
            destroyIsland(grid, x + 1, y);
        }

        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
            destroyIsland(grid, x, y - 1);
        }

        if (y + 1 < grid[x].length && grid[x][y + 1] == '1') {
            destroyIsland(grid, x, y + 1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
