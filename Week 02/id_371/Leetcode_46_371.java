import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-05 08:30
 **/

public class Leetcode_46_371 {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        List<List<Integer>> res = permute(nums);
        res.forEach(System.out::println);

    }

    /**
     * 仿解1:(回溯+enumerate numbers for a position)
     * @author Shaobo.Qian
     * @date 2019/11/9
     * @link https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
     * @link https://www.youtube.com/watch?v=d2ivgA4F1As
     */
    public static List<List<Integer>> permute1(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;
        //因为需要考虑当前的位置可以放哪些
        boolean[] visited = new boolean[len];

        generatePermute1(nums, visited, 0, len, new Stack<Integer>(), res);
        return res;
    }

    private static void generatePermute1(int[] nums, boolean[] visited, int curSize, int len, Stack<Integer> path, List<List<Integer>> res) {
        //1.递归出口
        if (curSize == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        //2.处理当前层(// enumerate possible numbers for current position)
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.push(nums[i]);
                //3.去下一层
                generatePermute1(nums, visited, curSize + 1, len, path, res);
                //4.回溯,所有状态清除(restore for the next possible number for current position)
                path.pop();
                visited[i] = false;
            }
        }
    }

    /**
     * 原解1:回溯法(未解除,对回溯时,状态的重置理解不够深入,应该需要将所有改变的状态重置)
     *
     * @author Shaobo.Qian
     * @date 2019/11/9
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) return results;
        List<Integer> subList = new ArrayList<>();
        backtrace(nums, 0, subList, results);
        return results;
    }

    private static void backtrace(int[] nums, int index, List<Integer> subList, List<List<Integer>> results) {
        if (subList.size() == nums.length) {
            results.add(new ArrayList<>(subList));
            return;
        }

        int count = nums.length - subList.size();
        for (int i = index; count > 0; count--) {
            subList.add(nums[i]);
            i++;
            if (i == nums.length) {
                i = 0;
            }
            backtrace(nums, i, subList, results);
            subList.remove(subList.size() - 1);
        }
    }
}
