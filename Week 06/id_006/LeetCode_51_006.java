package com.mrglint.leetcode.week06.solution51;

import java.util.*;

/**
 * @author luhuancheng
 * @since 2019-11-22 08:39
 */
public class Solution {

    public List<List<String>> solveNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        solveNQueens(0, n, cols, pie, na, new ArrayList<>(), result);
        return renderResult(result);
    }

    private List<List<String>> renderResult(List<List<Integer>> result) {
        List<List<String>> res = new ArrayList<>();
        for (List<Integer> cols : result) {
            List<String> subRes = new ArrayList<>();
            for (Integer col : cols) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < cols.size(); i++) {
                    if (i != col) {
                        stringBuilder.append('.');
                    } else {
                        stringBuilder.append('Q');
                    }
                }
                subRes.add(stringBuilder.toString());
            }
            res.add(subRes);
        }
        return res;
    }

    private void solveNQueens(int row, int n, Set<Integer> cols, Set<Integer> pie, Set<Integer> na,
                              List<Integer> subResult, List<List<Integer>> result) {
        // terminator
        if (row == n) {
            result.add(subResult);
            return;
        }

        // process logical
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || pie.contains(row + col) || na.contains(row - col)) {
                continue;
            }
            cols.add(col);
            pie.add(row + col);
            na.add(row - col);
            subResult.add(col);

            // drill down
            solveNQueens(row + 1, n, cols, pie, na, new ArrayList<>(subResult), result);
            // restore state
            cols.remove(col);
            pie.remove(row + col);
            na.remove(row - col);
            // 回溯时，需要删除下探前的
            subResult.remove(subResult.size() - 1);
        }
    }
}

