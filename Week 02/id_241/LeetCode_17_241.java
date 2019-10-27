/**
 * 两数之和
 */
public class Solution {
    /**
     * 基于 map 实现
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) map.put(nums[i], i);
            else return new int[]{i, map.get(target - nums[i])};
        }
        return new int[0];
    }

    /**
     * 模拟 map 桶实现
     * 不足：这里的 max 容量，很可能因为 nums数据过大而发生哈希碰撞
     */
    public int[] twoSum2(int[] nums, int target) {
        int max = 4095;
        int[] arr = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            int diff = (target - nums[i]) & max;
            if (arr[diff] != 0) return new int[]{arr[diff] - 1, i};
            arr[nums[i] & max] = i + 1;
        }
        return new int[0];
    }
}