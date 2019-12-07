import java.util.*;
/**
 * N皇后
 */
public class Solution {
    /**
     * N皇后
     */
    List<List<String>> results;

    public List<List<String>> solveNQueens(int n) {
        results = new ArrayList<>();
        if (n == 0) return results;
        Set<Integer> col = new HashSet<>();
        Set<Integer> left = new HashSet<>();
        Set<Integer> right = new HashSet<>();
        solveNQueensHelper(0, col, left, right, new int[n]);
        return results;
    }

    private void solveNQueensHelper(int index,
                                    Set<Integer> col,
                                    Set<Integer> left,
                                    Set<Integer> right,
                                    int[] res) {
        if (index > res.length - 1) {
            List<String> list = new ArrayList<>();
            for (int r : res) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < res.length; i++) {
                    if (r == i)
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                list.add(sb.toString());
            }
            results.add(list);
            return;
        }
        for (int i = 0; i < res.length; i++) {
            if (col.contains(i) || left.contains(i + index) || right.contains(index - i))
                continue;
            col.add(i);
            left.add(i + index);
            right.add(index - i);
            res[index] = i;
            solveNQueensHelper(index + 1, col, left, right, res);
            col.remove(i);
            left.remove(i + index);
            right.remove(index - i);
        }
    }
}