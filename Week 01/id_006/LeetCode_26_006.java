/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * @author luhuancheng
 * @since 2019-10-16 13:45
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
