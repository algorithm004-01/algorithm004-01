import java.util.*;
/**
 * 子集
 */
public class Solution {
    /**
     * 子集
     */
    private List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        subsetsHelper(0, nums, new LinkedList<>());
        return result;
    }

    private void subsetsHelper(int index, int[] nums, LinkedList<Integer> list) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            subsetsHelper(i + 1, nums, list);
            list.removeLast();
        }
    }
}