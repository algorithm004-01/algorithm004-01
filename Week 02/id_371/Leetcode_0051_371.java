import java.util.*;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-05 08:28
 **/

public class Leetcode_0051_371 {
    public static void main(String[] args) {
        List<List<String>> res = solveNQueens(4);
        res.forEach(System.out::println);
    }

    /**
     * 仿解1:回溯+减枝
     *
     * @author Shaobo.Qian
     * @date 2019/11/10
     * @link https://leetcode-cn.com/problems/n-queens/solution/gen-ju-di-46-ti-quan-pai-lie-de-hui-su-suan-fa-si-/
     */
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) return res;
        //构建列,为列赋值
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        //被占用的主对角线
        Set<Integer> master = new HashSet<>();
        //被占用的副对角线
        Set<Integer> slave = new HashSet<>();
        //被占用的列
        Set<Integer> colSet = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        backtrace(nums, 0, n, colSet, master, slave, stack, res);
        return res;
    }

    private static void backtrace(int[] nums, int row, int n, Set<Integer> colSet, Set<Integer> master, Set<Integer> slave, Stack<Integer> stack, List<List<String>> res) {
        //1.出口
        if (row == n) {
            List<String> board = convert2board(stack, n);
            res.add(board);
            return;
        }
        //2.  enumerate possible col position for queen of current row)
        for (int col = 0; col < n; col++) {
            if (!colSet.contains(col) && !master.contains(row + col) && !slave.contains(row - col)) {
                //2.处理当前层(当前行)的状态
                stack.add(nums[col]);
                colSet.add(col);
                master.add(row + col);
                slave.add(row - col);
                //3.去下一层(下一行)
                backtrace(nums, row + 1, n, colSet, master, slave, stack, res);

                //4.回溯,重置状态(restore for the next possible col position for queen of current row)
                stack.pop();
                colSet.remove(col);
                master.remove(row + col);
                slave.remove(row - col);
            }
        }
    }

    private static List<String> convert2board(Stack<Integer> stack, int n) {
        List<String> board = new ArrayList<>();
        for (Integer num : stack) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(".");
            }
            sb.replace(num, num + 1, "Q");
            board.add(sb.toString());
        }
        return board;
    }
}
