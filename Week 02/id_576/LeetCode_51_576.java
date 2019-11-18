import java.util.ArrayList;
import java.util.HashSet;

/**
 * LeetCode_51_576  solveNQueens
 */
public class LeetCode_51_576 {
    //solution 1
    public List<List<String>> solveNQueens1(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) return res;
        int[] nums = new int[n];
        for (int i : nums) {
            nums[i] = i;
        }

        Set<Integer> col = new HashSet<>();
        Set<Integer> master = new HashSet<>();
        Set<Integer> slave = new HashSet<>();
        Set<Integer> stack = new HashSet<>();
        
        backtrack(nums, 0, col, master, slave, stack, res);
        return res;
        
    }

    private void backtrack(int[] nums, int row, int n,
                            Set<Integer> col ,
                            Set<Integer> master,
                            Set<Integer> slave,
                            Set<Integer> stack,
                            List<List<String>> res) {
        //terminator
        if (row == n) {
            List<String> board = convert2board(stack, n);
            res.add(board);
            return;
        }
        //process current level
        //针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !master.contains(row + i) && !slave.contains(row - i)) {
                stack.add(nums[i]);
                col.add(i);
                master.add(row + i);
                slave.add(row - 1);
                //drill down
                backtrack(nums, row + 1, n, col, master, slave, stack, res);
                //reverse status 保证下面层的结果不要影响上一层
                slave.remove(row - i);
                master.remove(row + i);
                col.remove(i);
                stack.pop();
            }
        }

    }

    private List<String> convert2board(Stack<Integer> stack, int n) {
        
    }
    
    
    

    public List<List<String>> solveNQueens2(int n) {
        
    }
}