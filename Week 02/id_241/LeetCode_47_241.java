import java.util.*;
/**
 * 全排列 II
 */
public class Solution {
    /**
     * 全排列 II(基于全排列I 的修改)
     */
    private List<List<Integer>> result;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        permuteUniqueHelper(0, nums);
        return result;
    }

    private void permuteUniqueHelper(int index, int[] nums) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int value : nums.clone()) list.add(value);
            result.add(list);
        }
        int[] change = nums.clone();
        for (int i = index; i < nums.length; i++) {
            if (isRepeat(change, index, i)) continue;
            int tmp = change[index];
            change[index] = change[i];
            change[i] = tmp;
            permuteUniqueHelper(index + 1, change);
            change = nums.clone();
        }
    }

    //判断是否重复，比如 1322，1 与第一个 2 换位后回溯，1 与下一个 2 比较，但是之前 2 已经存在
    //所以，从 index 开始，到当前需要比较的数之间查询是否曾经存在过
    private boolean isRepeat(int[] nums, int index, int i) {
        for (int j = index; j < i; j++) {
            if (nums[i] == nums[j])
                return true;
        }
        return false;
    }
}