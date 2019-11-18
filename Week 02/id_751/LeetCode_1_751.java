/**
 * 两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */

//1.暴力求解
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         for (int i = 0; i < nums.length - 1; ++i) {
//             for (int j = i + 1; j < nums.length; ++j) {
//                 if (nums[i] + nums[j] == target)
//                     return new int[]{i, j};
//             }
//         }
//         return new int[0];
//     }
// }
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> h = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            h.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; ++j) {
            int scd = target - nums[j];
            if (h.containsKey(scd) && h.get(scd) != j) {
                return new int[]{j, h.get(scd)};
            }
        }
        return new int[0];
    }
}