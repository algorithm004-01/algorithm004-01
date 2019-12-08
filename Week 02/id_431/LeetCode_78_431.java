package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2019/11/6
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            _subsets(result, new ArrayList<Integer>(), nums, i);
        }
        return result;
    }

    private void _subsets(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
        if (start > nums.length - 1) return;
        list.add(nums[start]);
        result.add(new ArrayList<>(list));
        for (int i = start + 1; i < nums.length; i++) {
            _subsets(result, list, nums, i);
        }
        list.remove(list.size() - 1);
    }
}
