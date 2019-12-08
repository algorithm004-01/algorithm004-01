/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (44.62%)
 * Likes:    12133
 * Dislikes: 423
 * Total Accepted:    2.2M
 * Total Submissions: 4.9M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(numsMap.containsKey(temp) && numsMap.get(temp) != i){
                return new int[]{numsMap.get(temp), i};
            }
            numsMap.put(nums[i], i);
        }
        return null;
    }
}
// @lc code=end

/**
 * 通过求值来寻找索引，建立索引与值的关系，使用map
 * 其中对target的转换的思想需要学习
 */