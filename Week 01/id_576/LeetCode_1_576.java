/**
 * _1TwoSum
 */
public class _1TwoSum {

    public int[] twoSum(int[] nums, int target) {
        //肌肉记忆的两层遍历数组的模版
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
                 
            }
        }
        return new int[0];
    }
}