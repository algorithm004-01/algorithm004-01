//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//
//
// 上图为 8 皇后问题的一种解法。
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
// 示例:
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
//
// Related Topics 回溯算法
package com.aseara.leetcode.editor.cn.a51;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * desc: 51.N皇后 <br />
 * Date: 2019/11/22 <br/>
 *
 * @author qiujingde
 */
class NQueens {
    private Solution solution = new Solution();

    @Test
    void test1() {
        System.out.println(solution.solveNQueens(1));
        System.out.println(solution.solveNQueens(4));
        System.out.println(solution.solveNQueens(8));
    }

}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return null;
        }
        return method2(n);
    }

    private List<List<String>> method1(int n) {
        List<List<String>> resultStore = new LinkedList<>();

        // init chars
        char[] chars = new char[n];
        Arrays.fill(chars, '.');

        boolean[] col = new boolean[n];
        // 撇
        boolean[] left = new boolean[2 * n];
        // 捺
        boolean[] right = new boolean[2 * n];

        // 位置记录
        LinkedList<Integer> stack = new LinkedList<>();

        dfs(0, stack, n, col, left, right, resultStore, chars);

        return resultStore;
    }

    private void dfs(int row, LinkedList<Integer> stack, int n,
                     boolean[] col, boolean[] left, boolean[] right,
                     List<List<String>> resultStore, char[] chars) {
        if (row == n) {
            // 遍历完成，合法数据
            resultStore.add(to2D(chars, stack));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col[i] && !left[i - row + n] && !right[i + row]) {
                stack.add(i);
                col[i] = true;
                left[i - row + n] = true;
                right[i + row] = true;

                dfs(row + 1, stack, n, col, left, right, resultStore, chars);

                right[i + row] = false;
                left[i - row + n] = false;
                col[i] = false;
                stack.removeLast();
            }
        }
    }

    private List<String> to2D(char[] chars, List<Integer> result) {
        List<String> results = new LinkedList<>();
        for (int index : result) {
            chars[index] = 'Q';
            results.add(new String(chars));
            chars[index] = '.';
        }
        return results;
    }

    private List<List<String>> method2(int n) {
        List<List<String>> store = new LinkedList<>();
        LinkedList<Integer> stack = new LinkedList<>();

        // init chars
        char[] chars = new char[n];
        Arrays.fill(chars, '.');

        dfs2(n, 0, 0, 0, 0, store, stack, chars);

        return store;
    }

    private void dfs2(int n, int row, int cols, int pl, int pr, List<List<String>> store, LinkedList<Integer> stack,
                      char[] chars) {
        if (row == n) {
            store.add(to2D2(chars, stack));
        }
        int pos = (~(cols | pl | pr)) & ((1 << n) - 1);
        while (pos != 0) {
            int p = pos & (-pos);
            pos = pos & (pos - 1);
            stack.add(p);
            dfs2(n, row + 1, cols | p, (pl | p) << 1, (pr | p) >> 1, store, stack, chars);
            stack.removeLast();
        }
    }

    private List<String> to2D2(char[] chars, List<Integer> result) {
        List<String> results = new LinkedList<>();
        int n = chars.length;
        for (int p : result) {
            int index = n - 1 - Integer.numberOfTrailingZeros(p);
            chars[index] = 'Q';
            results.add(new String(chars));
            chars[index] = '.';
        }
        return results;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
