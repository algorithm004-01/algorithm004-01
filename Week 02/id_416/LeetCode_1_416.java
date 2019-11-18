package com.leetcode.week02;

import java.util.HashMap;
import java.util.Map;

/**
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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_1_416 {
    //1.暴力求解法
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    //2.Hash解法,空间换时间，多了一个HashMap，但是时间复杂度就变成了O (n) 了。
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer,Integer> result = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];//相减的计算的结果
            //如果相减的结果，在HashMap中存在，那么就直接返回
            if(result.containsKey(a)) {
                return new int[]{i,result.get(a)};
            }
            result.put(nums[i],i);
        }
        return null;
    }
}
