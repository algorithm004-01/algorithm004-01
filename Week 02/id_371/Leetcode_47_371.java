import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-05 08:30
 **/

public class Leetcode_47_371 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
    }

    /**
     * 仿解1:(回溯+当前位置可能的值)
     *
     * @author Shaobo.Qian
     * @date 2019/11/10
     * @link https://www.youtube.com/watch?v=eLUPUB_hC8I
     * @link https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        if (length == 0) return res;
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrace(nums, 0, length, visited, new Stack<Integer>(), res);
        return res;
    }

    private void backtrace(int[] nums, int depth, int length, boolean[] visited, Stack<Integer> path, List<List<Integer>> res) {
        //1.递归出口
        if (depth == length) {
            res.add(new ArrayList<>(path));
            return;
        }
        //2.处理当前层(// enumerate possible numbers for current position)
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {//判断当前元素是否可选
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue; //回溯里的剪枝
                path.push(nums[i]);
                visited[i] = true;
                //3.去下一层
                backtrace(nums, depth + 1, length, visited, path, res);
                //4.回溯,重置状态(restore for the next possible number for current position)
                path.pop();
                visited[i] = false;
            }
        }
    }

}
