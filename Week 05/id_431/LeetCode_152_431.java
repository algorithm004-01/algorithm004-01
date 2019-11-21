package medium;

/**
 * @author 潘磊明
 * @date 2019/11/12
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int[] minNums = new int[nums.length];
        int[] maxNums = new int[nums.length];
        minNums[0] = nums[0];
        maxNums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                minNums[i] = Math.min(nums[i] * maxNums[i - 1], nums[i]);
                maxNums[i] = Math.max(nums[i] * minNums[i - 1], nums[i]);
            }else {
                minNums[i] = Math.min(nums[i] * minNums[i - 1], nums[i]);
                maxNums[i] = Math.max(nums[i] * maxNums[i - 1], nums[i]);
            }
            max = Math.max(max, maxNums[i]);
        }
        return max;
    }
}
