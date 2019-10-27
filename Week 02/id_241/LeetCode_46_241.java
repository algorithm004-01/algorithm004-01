import java.util.*;
/**
 * 全排列
 */
public class Solution {
    /**
     * 全排列I
     */
    private List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        List<Integer> curr = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            curr.add(nums[i - 1]);
        }
        permuteHelper(0, curr);
        return result;
    }

    private void permuteHelper(int index, List<Integer> curr) {
        if (index == curr.size())
            result.add(new ArrayList<>(curr));
        List<Integer> change = new ArrayList<>(curr);
        //i = index，让第一个数沉底，以便输出
        for (int i = index; i < curr.size(); i++) {
            int tmp = change.get(index);
            change.set(index, change.get(i));
            change.set(i, tmp);
            permuteHelper(index + 1, change);
            change = new ArrayList<>(curr);
        }
    }
}