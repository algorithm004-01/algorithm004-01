// 求两数之和,输出数组中两个元素之和等于目标数据的元素

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            for (int j = i + 1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}