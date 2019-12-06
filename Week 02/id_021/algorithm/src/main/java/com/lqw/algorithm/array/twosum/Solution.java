package com.lqw.algorithm.array.twosum;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 链接：https://leetcode-cn.com/problems/two-sum
 * <p>
 * 示例：
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 思路
 * 1、暴力解决，两层for循环，时间复杂度O（n^2）
 * 2、使用哈希法，将所有的元素加入到hash表中，然后使用target-减去每个元素，到hash表中获取，并且不能是同一个元素
 * 3、使用hash法，将所有到元素和target减去元素得到的元素也放入到hash中，再加入的过程中判断下是否已经有存在
 * @author linqiwen
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] indexs = null;
        out:
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == (nums[i] + nums[j])) {
                    indexs = new int[2];
                    indexs[0] = i;
                    indexs[1] = j;
                    break out;
                }
            }
        }
        return indexs;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 3};
        solution.twoSum(nums, 6);
    }

}
