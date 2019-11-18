import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListResourceBundle;

/**
 * LeetCode_78_576
 */
public class LeetCode_78_576 {
    //solution 1: O(2^n)
    public List<List<Integer>> subsets1(int[] nums) {
        //   climb staris and coins problems ，和左右括号问题
        /**
         * 每一层考虑的问题就是选或者不选这个数
         */
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) return ans;
        dfs(ans, nums, new ArrayList<Integer>(), 0);
        return ans;

    }

    private void dfs(List<List<Integer>> ans, int[] nums, List<Integer> list , int index) {
        // terminator
        if (index == nums.length) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        //如果不想用reverse，用list.clone 替代list也是可以的，是浅拷贝
        dfs(ans, nums, list, index + 1); //not pick the number at this index

        list.add(nums[index]);
        dfs(ans, nums, list, index + 1); //pick the number at this index

        //reverse the state
        /**
         * 为什么这里需要reverse，应为list不是本层的参数，如果不去掉改变，会影响到其他层
         */
        list.remove(list.size() - 1);
    }

    // solution2:用迭代的方法，用java怎么写？o(n^2)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        // it's hard to think and loop by human brain, so try to remember it at first time.
        for(int n : nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }
}