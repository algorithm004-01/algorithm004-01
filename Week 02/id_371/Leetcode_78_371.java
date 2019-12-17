import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: algorithm004-01
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-11-05 08:27
 **/

public class Leetcode_78_371 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        List<List<Integer>> subsets = subsets2(nums);
        subsets.stream().forEach(System.out::println);

    }


    /**
     * 仿解2:dfs+一层一层决策
     *
     * @author Shaobo.Qian
     * @date 2019/11/5
     */
    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) return results;
        ArrayList<Integer> subList = new ArrayList<>();
        if (nums.length == 0) {
            results.add(subList);
            return results;
        }
        Arrays.sort(nums);
        return dfs(nums, subList, 0, results);
    }

    private static List<List<Integer>> dfs(int[] nums, ArrayList<Integer> subList, int index, List<List<Integer>> results) {
        //1.递归出口
        if (index == nums.length) {
            results.add(new ArrayList<>(subList));
            return results;
        }
        //2.1处理当前层,决策:当前层加入元素
        subList.add(nums[index]);
        //3.1去下一层
        dfs(nums, subList, index + 1, results);
        //2.1处理当前层,决策:当前层不加入元素
        subList.remove(subList.size() - 1);
        //3.2去下一层
        dfs(nums, subList, index + 1, results);
        return results;
    }

    /**
     * 仿解1:回溯法
     *
     * @author Shaobo.Qian
     * @date 2019/11/5
     * @link https://www.jiuzhang.com/solution/subsets
     */
    public static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) return results;
        ArrayList<Integer> subList = new ArrayList<>();
        if (nums.length == 0) {
            results.add(subList);
            return results;
        }
        Arrays.sort(nums);
        backtrace(nums, subList, 0, results);
        return results;

    }

    private static void backtrace(int[] nums, ArrayList<Integer> subList, int startIndex, List<List<Integer>> results) {
        results.add(new ArrayList<>(subList));
        for (int i = startIndex; i < nums.length; i++) {
            //[1] ->[1,2]
            subList.add(nums[i]);
            //寻找以[1,2]开头的集合,存入 results
            backtrace(nums, subList, i + 1, results);
            //[1,2]->[1] 移除末尾的元素,回溯
            subList.remove(subList.size() - 1);
        }
    }

}
